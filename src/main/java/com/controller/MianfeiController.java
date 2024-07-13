
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
 * 免费电影
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/mianfei")
public class MianfeiController {
    private static final Logger logger = LoggerFactory.getLogger(MianfeiController.class);

    private static final String TABLE_NAME = "mianfei";

    @Autowired
    private MianfeiService mianfeiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DianyingService dianyingService;//付费电影
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
        params.put("mianfeiDeleteStart",1);params.put("mianfeiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = mianfeiService.queryPage(params);

        //字典表数据转换
        List<MianfeiView> list =(List<MianfeiView>)page.getList();
        for(MianfeiView c:list){
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
        MianfeiEntity mianfei = mianfeiService.selectById(id);
        if(mianfei !=null){
            //entity转view
            MianfeiView view = new MianfeiView();
            BeanUtils.copyProperties( mianfei , view );//把实体数据重构到view中
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
    public R save(@RequestBody MianfeiEntity mianfei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,mianfei:{}",this.getClass().getName(),mianfei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<MianfeiEntity> queryWrapper = new EntityWrapper<MianfeiEntity>()
            .eq("mianfei_name", mianfei.getMianfeiName())
            .eq("zan_number", mianfei.getZanNumber())
            .eq("cai_number", mianfei.getCaiNumber())
            .eq("mianfei_video", mianfei.getMianfeiVideo())
            .eq("mianfei_types", mianfei.getMianfeiTypes())
            .eq("mianfei_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MianfeiEntity mianfeiEntity = mianfeiService.selectOne(queryWrapper);
        if(mianfeiEntity==null){
            mianfei.setZanNumber(1);
            mianfei.setCaiNumber(1);
            mianfei.setMianfeiClicknum(1);
            mianfei.setMianfeiDelete(1);
            mianfei.setInsertTime(new Date());
            mianfei.setCreateTime(new Date());
            mianfeiService.insert(mianfei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MianfeiEntity mianfei, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,mianfei:{}",this.getClass().getName(),mianfei.toString());
        MianfeiEntity oldMianfeiEntity = mianfeiService.selectById(mianfei.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(mianfei.getMianfeiPhoto()) || "null".equals(mianfei.getMianfeiPhoto())){
                mianfei.setMianfeiPhoto(null);
        }
        if("".equals(mianfei.getMianfeiVideo()) || "null".equals(mianfei.getMianfeiVideo())){
                mianfei.setMianfeiVideo(null);
        }
        if("".equals(mianfei.getMianfeiContent()) || "null".equals(mianfei.getMianfeiContent())){
                mianfei.setMianfeiContent(null);
        }

            mianfeiService.updateById(mianfei);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<MianfeiEntity> oldMianfeiList =mianfeiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<MianfeiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            MianfeiEntity mianfeiEntity = new MianfeiEntity();
            mianfeiEntity.setId(id);
            mianfeiEntity.setMianfeiDelete(2);
            list.add(mianfeiEntity);
        }
        if(list != null && list.size() >0){
            mianfeiService.updateBatchById(list);
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
            List<MianfeiEntity> mianfeiList = new ArrayList<>();//上传的东西
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
                            MianfeiEntity mianfeiEntity = new MianfeiEntity();
//                            mianfeiEntity.setMianfeiName(data.get(0));                    //免费电影名称 要改的
//                            mianfeiEntity.setMianfeiUuidNumber(data.get(0));                    //免费电影编号 要改的
//                            mianfeiEntity.setMianfeiPhoto("");//详情和图片
//                            mianfeiEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            mianfeiEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            mianfeiEntity.setMianfeiVideo(data.get(0));                    //电影 要改的
//                            mianfeiEntity.setMianfeiTypes(Integer.valueOf(data.get(0)));   //免费电影类型 要改的
//                            mianfeiEntity.setMianfeiClicknum(Integer.valueOf(data.get(0)));   //免费电影热度 要改的
//                            mianfeiEntity.setMianfeiContent("");//详情和图片
//                            mianfeiEntity.setMianfeiDelete(1);//逻辑删除字段
//                            mianfeiEntity.setInsertTime(date);//时间
//                            mianfeiEntity.setCreateTime(date);//时间
                            mianfeiList.add(mianfeiEntity);


                            //把要查询是否重复的字段放入map中
                                //免费电影编号
                                if(seachFields.containsKey("mianfeiUuidNumber")){
                                    List<String> mianfeiUuidNumber = seachFields.get("mianfeiUuidNumber");
                                    mianfeiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> mianfeiUuidNumber = new ArrayList<>();
                                    mianfeiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("mianfeiUuidNumber",mianfeiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //免费电影编号
                        List<MianfeiEntity> mianfeiEntities_mianfeiUuidNumber = mianfeiService.selectList(new EntityWrapper<MianfeiEntity>().in("mianfei_uuid_number", seachFields.get("mianfeiUuidNumber")).eq("mianfei_delete", 1));
                        if(mianfeiEntities_mianfeiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(MianfeiEntity s:mianfeiEntities_mianfeiUuidNumber){
                                repeatFields.add(s.getMianfeiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [免费电影编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        mianfeiService.insertBatch(mianfeiList);
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
        List<MianfeiView> returnMianfeiViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("mianfeiYesnoTypes",2);
        PageUtils pageUtils = mianfeiCollectionService.queryPage(params1);
        List<MianfeiCollectionView> collectionViewsList =(List<MianfeiCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(MianfeiCollectionView collectionView:collectionViewsList){
            Integer mianfeiTypes = collectionView.getMianfeiTypes();
            if(typeMap.containsKey(mianfeiTypes)){
                typeMap.put(mianfeiTypes,typeMap.get(mianfeiTypes)+1);
            }else{
                typeMap.put(mianfeiTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("mianfeiTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("mianfeiYesnoTypes",2);
            PageUtils pageUtils1 = mianfeiService.queryPage(params2);
            List<MianfeiView> mianfeiViewList =(List<MianfeiView>)pageUtils1.getList();
            returnMianfeiViewList.addAll(mianfeiViewList);
            if(returnMianfeiViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("mianfeiYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = mianfeiService.queryPage(params);
        if(returnMianfeiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnMianfeiViewList.size();//要添加的数量
            List<MianfeiView> mianfeiViewList =(List<MianfeiView>)page.getList();
            for(MianfeiView mianfeiView:mianfeiViewList){
                Boolean addFlag = true;
                for(MianfeiView returnMianfeiView:returnMianfeiViewList){
                    if(returnMianfeiView.getId().intValue() ==mianfeiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnMianfeiViewList.add(mianfeiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnMianfeiViewList = returnMianfeiViewList.subList(0, limit);
        }

        for(MianfeiView c:returnMianfeiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnMianfeiViewList);
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
        PageUtils page = mianfeiService.queryPage(params);

        //字典表数据转换
        List<MianfeiView> list =(List<MianfeiView>)page.getList();
        for(MianfeiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MianfeiEntity mianfei = mianfeiService.selectById(id);
            if(mianfei !=null){

                //点击数量加1
                mianfei.setMianfeiClicknum(mianfei.getMianfeiClicknum()+1);
                mianfeiService.updateById(mianfei);

                //entity转view
                MianfeiView view = new MianfeiView();
                BeanUtils.copyProperties( mianfei , view );//把实体数据重构到view中

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
    public R add(@RequestBody MianfeiEntity mianfei, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,mianfei:{}",this.getClass().getName(),mianfei.toString());
        Wrapper<MianfeiEntity> queryWrapper = new EntityWrapper<MianfeiEntity>()
            .eq("mianfei_name", mianfei.getMianfeiName())
            .eq("mianfei_uuid_number", mianfei.getMianfeiUuidNumber())
            .eq("zan_number", mianfei.getZanNumber())
            .eq("cai_number", mianfei.getCaiNumber())
            .eq("mianfei_video", mianfei.getMianfeiVideo())
            .eq("mianfei_types", mianfei.getMianfeiTypes())
            .eq("mianfei_clicknum", mianfei.getMianfeiClicknum())
            .eq("mianfei_delete", mianfei.getMianfeiDelete())
//            .notIn("mianfei_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MianfeiEntity mianfeiEntity = mianfeiService.selectOne(queryWrapper);
        if(mianfeiEntity==null){
                mianfei.setZanNumber(1);
                mianfei.setCaiNumber(1);
            mianfei.setMianfeiClicknum(1);
            mianfei.setMianfeiDelete(1);
            mianfei.setInsertTime(new Date());
            mianfei.setCreateTime(new Date());
        mianfeiService.insert(mianfei);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

