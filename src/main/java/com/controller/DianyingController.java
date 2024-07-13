
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 付费电影
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/dianying")
public class DianyingController {
    private static final Logger logger = LoggerFactory.getLogger(DianyingController.class);

    private static final String TABLE_NAME = "dianying";

    @Autowired
    private DianyingService dianyingService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DianyingCollectionService dianyingCollectionService;//付费电影收藏
    @Autowired
    private DianyingLiuyanService dianyingLiuyanService;//付费电影评价
    @Autowired
    private DianyingOrderService dianyingOrderService;//电影购买
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//电影论坛
    @Autowired
    private GonggaoService gonggaoService;//电影资讯
    @Autowired
    private MianfeiService mianfeiService;//免费电影
    @Autowired
    private MianfeiCollectionService mianfeiCollectionService;//免费电影收藏
    @Autowired
    private MianfeiLiuyanService mianfeiLiuyanService;//免费电影评论
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("dianyingDeleteStart",1);params.put("dianyingDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = dianyingService.queryPage(params);

        //字典表数据转换
        List<DianyingView> list =(List<DianyingView>)page.getList();
        for(DianyingView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DianyingEntity dianying = dianyingService.selectById(id);
        if(dianying !=null){
            //entity转view
            DianyingView view = new DianyingView();
            BeanUtils.copyProperties( dianying , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody DianyingEntity dianying, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,dianying:{}",this.getClass().getName(),dianying.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<DianyingEntity> queryWrapper = new EntityWrapper<DianyingEntity>()
            .eq("dianying_name", dianying.getDianyingName())
            .eq("zan_number", dianying.getZanNumber())
            .eq("cai_number", dianying.getCaiNumber())
            .eq("dianying_video", dianying.getDianyingVideo())
            .eq("dianying_types", dianying.getDianyingTypes())
            .eq("dianying_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DianyingEntity dianyingEntity = dianyingService.selectOne(queryWrapper);
        if(dianyingEntity==null){
            dianying.setZanNumber(1);
            dianying.setCaiNumber(1);
            dianying.setDianyingClicknum(1);
            dianying.setDianyingDelete(1);
            dianying.setInsertTime(new Date());
            dianying.setCreateTime(new Date());
            dianyingService.insert(dianying);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DianyingEntity dianying, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,dianying:{}",this.getClass().getName(),dianying.toString());
        DianyingEntity oldDianyingEntity = dianyingService.selectById(dianying.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(dianying.getDianyingPhoto()) || "null".equals(dianying.getDianyingPhoto())){
                dianying.setDianyingPhoto(null);
        }
        if("".equals(dianying.getDianyingVideo()) || "null".equals(dianying.getDianyingVideo())){
                dianying.setDianyingVideo(null);
        }
        if("".equals(dianying.getDianyingContent()) || "null".equals(dianying.getDianyingContent())){
                dianying.setDianyingContent(null);
        }

            dianyingService.updateById(dianying);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<DianyingEntity> oldDianyingList =dianyingService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<DianyingEntity> list = new ArrayList<>();
        for(Integer id:ids){
            DianyingEntity dianyingEntity = new DianyingEntity();
            dianyingEntity.setId(id);
            dianyingEntity.setDianyingDelete(2);
            list.add(dianyingEntity);
        }
        if(list != null && list.size() >0){
            dianyingService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<DianyingEntity> dianyingList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            DianyingEntity dianyingEntity = new DianyingEntity();
//                            dianyingEntity.setDianyingName(data.get(0));                    //付费电影名称 要改的
//                            dianyingEntity.setDianyingUuidNumber(data.get(0));                    //付费电影编号 要改的
//                            dianyingEntity.setDianyingPhoto("");//详情和图片
//                            dianyingEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            dianyingEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            dianyingEntity.setDianyingVideo(data.get(0));                    //电影 要改的
//                            dianyingEntity.setDianyingTypes(Integer.valueOf(data.get(0)));   //付费电影类型 要改的
//                            dianyingEntity.setDianyingNewMoney(data.get(0));                    //金额 要改的
//                            dianyingEntity.setDianyingClicknum(Integer.valueOf(data.get(0)));   //付费电影热度 要改的
//                            dianyingEntity.setDianyingContent("");//详情和图片
//                            dianyingEntity.setDianyingDelete(1);//逻辑删除字段
//                            dianyingEntity.setInsertTime(date);//时间
//                            dianyingEntity.setCreateTime(date);//时间
                            dianyingList.add(dianyingEntity);


                            //把要查询是否重复的字段放入map中
                                //付费电影编号
                                if(seachFields.containsKey("dianyingUuidNumber")){
                                    List<String> dianyingUuidNumber = seachFields.get("dianyingUuidNumber");
                                    dianyingUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> dianyingUuidNumber = new ArrayList<>();
                                    dianyingUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("dianyingUuidNumber",dianyingUuidNumber);
                                }
                        }

                        //查询是否重复
                         //付费电影编号
                        List<DianyingEntity> dianyingEntities_dianyingUuidNumber = dianyingService.selectList(new EntityWrapper<DianyingEntity>().in("dianying_uuid_number", seachFields.get("dianyingUuidNumber")).eq("dianying_delete", 1));
                        if(dianyingEntities_dianyingUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DianyingEntity s:dianyingEntities_dianyingUuidNumber){
                                repeatFields.add(s.getDianyingUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [付费电影编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        dianyingService.insertBatch(dianyingList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<DianyingView> returnDianyingViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("dianyingYesnoTypes",2);
        PageUtils pageUtils = dianyingOrderService.queryPage(params1);
        List<DianyingOrderView> orderViewsList =(List<DianyingOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(DianyingOrderView orderView:orderViewsList){
            Integer dianyingTypes = orderView.getDianyingTypes();
            if(typeMap.containsKey(dianyingTypes)){
                typeMap.put(dianyingTypes,typeMap.get(dianyingTypes)+1);
            }else{
                typeMap.put(dianyingTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("dianyingTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("dianyingYesnoTypes",2);
            PageUtils pageUtils1 = dianyingService.queryPage(params2);
            List<DianyingView> dianyingViewList =(List<DianyingView>)pageUtils1.getList();
            returnDianyingViewList.addAll(dianyingViewList);
            if(returnDianyingViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("dianyingYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = dianyingService.queryPage(params);
        if(returnDianyingViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnDianyingViewList.size();//要添加的数量
            List<DianyingView> dianyingViewList =(List<DianyingView>)page.getList();
            for(DianyingView dianyingView:dianyingViewList){
                Boolean addFlag = true;
                for(DianyingView returnDianyingView:returnDianyingViewList){
                    if(returnDianyingView.getId().intValue() ==dianyingView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnDianyingViewList.add(dianyingView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnDianyingViewList = returnDianyingViewList.subList(0, limit);
        }

        for(DianyingView c:returnDianyingViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnDianyingViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = dianyingService.queryPage(params);

        //字典表数据转换
        List<DianyingView> list =(List<DianyingView>)page.getList();
        for(DianyingView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DianyingEntity dianying = dianyingService.selectById(id);
            if(dianying !=null){

                //点击数量加1
                dianying.setDianyingClicknum(dianying.getDianyingClicknum()+1);
                dianyingService.updateById(dianying);

                //entity转view
                DianyingView view = new DianyingView();
                BeanUtils.copyProperties( dianying , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody DianyingEntity dianying, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,dianying:{}",this.getClass().getName(),dianying.toString());
        Wrapper<DianyingEntity> queryWrapper = new EntityWrapper<DianyingEntity>()
            .eq("dianying_name", dianying.getDianyingName())
            .eq("dianying_uuid_number", dianying.getDianyingUuidNumber())
            .eq("zan_number", dianying.getZanNumber())
            .eq("cai_number", dianying.getCaiNumber())
            .eq("dianying_video", dianying.getDianyingVideo())
            .eq("dianying_types", dianying.getDianyingTypes())
            .eq("dianying_clicknum", dianying.getDianyingClicknum())
            .eq("dianying_delete", dianying.getDianyingDelete())
//            .notIn("dianying_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DianyingEntity dianyingEntity = dianyingService.selectOne(queryWrapper);
        if(dianyingEntity==null){
                dianying.setZanNumber(1);
                dianying.setCaiNumber(1);
            dianying.setDianyingClicknum(1);
            dianying.setDianyingDelete(1);
            dianying.setInsertTime(new Date());
            dianying.setCreateTime(new Date());
        dianyingService.insert(dianying);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

