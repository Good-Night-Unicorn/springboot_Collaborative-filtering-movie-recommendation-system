package com.dao;

import com.entity.MianfeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MianfeiView;

/**
 * 免费电影 Dao 接口
 *
 * @author 
 */
public interface MianfeiDao extends BaseMapper<MianfeiEntity> {

   List<MianfeiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
