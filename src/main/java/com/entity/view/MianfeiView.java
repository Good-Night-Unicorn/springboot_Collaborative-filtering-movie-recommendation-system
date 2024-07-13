package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.MianfeiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 免费电影
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("mianfei")
public class MianfeiView extends MianfeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 免费电影类型的值
	*/
	@ColumnInfo(comment="免费电影类型的字典表值",type="varchar(200)")
	private String mianfeiValue;




	public MianfeiView() {

	}

	public MianfeiView(MianfeiEntity mianfeiEntity) {
		try {
			BeanUtils.copyProperties(this, mianfeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 免费电影类型的值
	*/
	public String getMianfeiValue() {
		return mianfeiValue;
	}
	/**
	* 设置： 免费电影类型的值
	*/
	public void setMianfeiValue(String mianfeiValue) {
		this.mianfeiValue = mianfeiValue;
	}




	@Override
	public String toString() {
		return "MianfeiView{" +
			", mianfeiValue=" + mianfeiValue +
			"} " + super.toString();
	}
}
