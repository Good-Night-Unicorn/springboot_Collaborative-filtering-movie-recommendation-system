package com.dao;

import com.entity.MianfeiCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MianfeiCollectionView;

/**
 * 免费电影收藏 Dao 接口
 *
 * @author 
 */
public interface MianfeiCollectionDao extends BaseMapper<MianfeiCollectionEntity> {

   List<MianfeiCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
