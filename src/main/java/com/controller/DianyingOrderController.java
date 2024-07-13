
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
 * 电影购买
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/dianyingOrder")
public class DianyingOrderController {
    private static final Logger logger = LoggerFactory.getLogger(DianyingOrderController.class);

    private static final String TABLE_NAME = "dianyingOrder";

    @Autowired
    private DianyingOrderService dianyingOrderService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DianyingService dianyingService;//付费电影
    @Autowired
    private DianyingCollectionService dianyingCollectionService;//付费电影收藏
    @Autowired
    private DianyingLiuyanService dianyingLiuyanService;//付费电影评价
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
        CommonUtil.checkMap(params);
        PageUtils page = dianyingOrderService.queryPage(params);

        //字典表数据转换
        List<DianyingOrderView> list =(List<DianyingOrderView>)page.getList();
        for(DianyingOrderView c:list){
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
        DianyingOrderEntity dianyingOrder = dianyingOrderService.selectById(id);
        if(dianyingOrder !=null){
            //entity转view
            DianyingOrderView view = new DianyingOrderView();
            BeanUtils.copyProperties( dianyingOrder , view );//把实体数据重构到view中
            //级联表 付费电影
            //级联表
            DianyingEntity dianying = dianyingService.selectById(dianyingOrder.getDianyingId());
            if(dianying != null){
            BeanUtils.copyProperties( dianying , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setDianyingId(dianying.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(dianyingOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody DianyingOrderEntity dianyingOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,dianyingOrder:{}",this.getClass().getName(),dianyingOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            dianyingOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        dianyingOrder.setCreateTime(new Date());
        dianyingOrder.setInsertTime(new Date());
        dianyingOrderService.insert(dianyingOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DianyingOrderEntity dianyingOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,dianyingOrder:{}",this.getClass().getName(),dianyingOrder.toString());
        DianyingOrderEntity oldDianyingOrderEntity = dianyingOrderService.selectById(dianyingOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            dianyingOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            dianyingOrderService.updateById(dianyingOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<DianyingOrderEntity> oldDianyingOrderList =dianyingOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        dianyingOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<DianyingOrderEntity> dianyingOrderList = new ArrayList<>();//上传的东西
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
                            DianyingOrderEntity dianyingOrderEntity = new DianyingOrderEntity();
//                            dianyingOrderEntity.setDianyingOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            dianyingOrderEntity.setDianyingId(Integer.valueOf(data.get(0)));   //电影 要改的
//                            dianyingOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            dianyingOrderEntity.setDianyingOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            dianyingOrderEntity.setDianyingOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            dianyingOrderEntity.setInsertTime(date);//时间
//                            dianyingOrderEntity.setCreateTime(date);//时间
                            dianyingOrderList.add(dianyingOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("dianyingOrderUuidNumber")){
                                    List<String> dianyingOrderUuidNumber = seachFields.get("dianyingOrderUuidNumber");
                                    dianyingOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> dianyingOrderUuidNumber = new ArrayList<>();
                                    dianyingOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("dianyingOrderUuidNumber",dianyingOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<DianyingOrderEntity> dianyingOrderEntities_dianyingOrderUuidNumber = dianyingOrderService.selectList(new EntityWrapper<DianyingOrderEntity>().in("dianying_order_uuid_number", seachFields.get("dianyingOrderUuidNumber")));
                        if(dianyingOrderEntities_dianyingOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DianyingOrderEntity s:dianyingOrderEntities_dianyingOrderUuidNumber){
                                repeatFields.add(s.getDianyingOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        dianyingOrderService.insertBatch(dianyingOrderList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = dianyingOrderService.queryPage(params);

        //字典表数据转换
        List<DianyingOrderView> list =(List<DianyingOrderView>)page.getList();
        for(DianyingOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DianyingOrderEntity dianyingOrder = dianyingOrderService.selectById(id);
            if(dianyingOrder !=null){


                //entity转view
                DianyingOrderView view = new DianyingOrderView();
                BeanUtils.copyProperties( dianyingOrder , view );//把实体数据重构到view中

                //级联表
                    DianyingEntity dianying = dianyingService.selectById(dianyingOrder.getDianyingId());
                if(dianying != null){
                    BeanUtils.copyProperties( dianying , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setDianyingId(dianying.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(dianyingOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R add(@RequestBody DianyingOrderEntity dianyingOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,dianyingOrder:{}",this.getClass().getName(),dianyingOrder.toString());
            DianyingEntity dianyingEntity = dianyingService.selectById(dianyingOrder.getDianyingId());
            if(dianyingEntity == null){
                return R.error(511,"查不到该付费电影");
            }
            // Double dianyingNewMoney = dianyingEntity.getDianyingNewMoney();

            if(false){
            }
            else if(dianyingEntity.getDianyingNewMoney() == null){
                return R.error(511,"金额不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - dianyingEntity.getDianyingNewMoney()*1;//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            dianyingOrder.setDianyingOrderTypes(101); //设置订单状态为已购买
            dianyingOrder.setDianyingOrderTruePrice(dianyingEntity.getDianyingNewMoney()*1); //设置实付价格
            dianyingOrder.setYonghuId(userId); //设置订单支付人id
            dianyingOrder.setDianyingOrderUuidNumber(String.valueOf(new Date().getTime()));
            dianyingOrder.setInsertTime(new Date());
            dianyingOrder.setCreateTime(new Date());
                dianyingOrderService.insert(dianyingOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }


}

