package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.DianyingCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 付费电影收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("dianying_collection")
public class DianyingCollectionView extends DianyingCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String dianyingCollectionValue;

	//级联表 付费电影
		/**
		* 付费电影名称
		*/

		@ColumnInfo(comment="付费电影名称",type="varchar(200)")
		private String dianyingName;
		/**
		* 付费电影编号
		*/

		@ColumnInfo(comment="付费电影编号",type="varchar(200)")
		private String dianyingUuidNumber;
		/**
		* 付费电影照片
		*/

		@ColumnInfo(comment="付费电影照片",type="varchar(200)")
		private String dianyingPhoto;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 电影
		*/

		@ColumnInfo(comment="电影",type="varchar(200)")
		private String dianyingVideo;
		/**
		* 付费电影类型
		*/
		@ColumnInfo(comment="付费电影类型",type="int(11)")
		private Integer dianyingTypes;
			/**
			* 付费电影类型的值
			*/
			@ColumnInfo(comment="付费电影类型的字典表值",type="varchar(200)")
			private String dianyingValue;
		/**
		* 金额
		*/
		@ColumnInfo(comment="金额",type="decimal(10,2)")
		private Double dianyingNewMoney;
		/**
		* 付费电影热度
		*/

		@ColumnInfo(comment="付费电影热度",type="int(11)")
		private Integer dianyingClicknum;
		/**
		* 付费电影介绍
		*/

		@ColumnInfo(comment="付费电影介绍",type="longtext")
		private String dianyingContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer dianyingDelete;
	//级联表 用户
		/**
		* 用户编号
		*/

		@ColumnInfo(comment="用户编号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;



	public DianyingCollectionView() {

	}

	public DianyingCollectionView(DianyingCollectionEntity dianyingCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, dianyingCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getDianyingCollectionValue() {
		return dianyingCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setDianyingCollectionValue(String dianyingCollectionValue) {
		this.dianyingCollectionValue = dianyingCollectionValue;
	}


	//级联表的get和set 付费电影

		/**
		* 获取： 付费电影名称
		*/
		public String getDianyingName() {
			return dianyingName;
		}
		/**
		* 设置： 付费电影名称
		*/
		public void setDianyingName(String dianyingName) {
			this.dianyingName = dianyingName;
		}

		/**
		* 获取： 付费电影编号
		*/
		public String getDianyingUuidNumber() {
			return dianyingUuidNumber;
		}
		/**
		* 设置： 付费电影编号
		*/
		public void setDianyingUuidNumber(String dianyingUuidNumber) {
			this.dianyingUuidNumber = dianyingUuidNumber;
		}

		/**
		* 获取： 付费电影照片
		*/
		public String getDianyingPhoto() {
			return dianyingPhoto;
		}
		/**
		* 设置： 付费电影照片
		*/
		public void setDianyingPhoto(String dianyingPhoto) {
			this.dianyingPhoto = dianyingPhoto;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}

		/**
		* 获取： 电影
		*/
		public String getDianyingVideo() {
			return dianyingVideo;
		}
		/**
		* 设置： 电影
		*/
		public void setDianyingVideo(String dianyingVideo) {
			this.dianyingVideo = dianyingVideo;
		}
		/**
		* 获取： 付费电影类型
		*/
		public Integer getDianyingTypes() {
			return dianyingTypes;
		}
		/**
		* 设置： 付费电影类型
		*/
		public void setDianyingTypes(Integer dianyingTypes) {
			this.dianyingTypes = dianyingTypes;
		}


			/**
			* 获取： 付费电影类型的值
			*/
			public String getDianyingValue() {
				return dianyingValue;
			}
			/**
			* 设置： 付费电影类型的值
			*/
			public void setDianyingValue(String dianyingValue) {
				this.dianyingValue = dianyingValue;
			}

		/**
		* 获取： 金额
		*/
		public Double getDianyingNewMoney() {
			return dianyingNewMoney;
		}
		/**
		* 设置： 金额
		*/
		public void setDianyingNewMoney(Double dianyingNewMoney) {
			this.dianyingNewMoney = dianyingNewMoney;
		}

		/**
		* 获取： 付费电影热度
		*/
		public Integer getDianyingClicknum() {
			return dianyingClicknum;
		}
		/**
		* 设置： 付费电影热度
		*/
		public void setDianyingClicknum(Integer dianyingClicknum) {
			this.dianyingClicknum = dianyingClicknum;
		}

		/**
		* 获取： 付费电影介绍
		*/
		public String getDianyingContent() {
			return dianyingContent;
		}
		/**
		* 设置： 付费电影介绍
		*/
		public void setDianyingContent(String dianyingContent) {
			this.dianyingContent = dianyingContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getDianyingDelete() {
			return dianyingDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setDianyingDelete(Integer dianyingDelete) {
			this.dianyingDelete = dianyingDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户编号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 用户编号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "DianyingCollectionView{" +
			", dianyingCollectionValue=" + dianyingCollectionValue +
			", dianyingName=" + dianyingName +
			", dianyingUuidNumber=" + dianyingUuidNumber +
			", dianyingPhoto=" + dianyingPhoto +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", dianyingVideo=" + dianyingVideo +
			", dianyingNewMoney=" + dianyingNewMoney +
			", dianyingClicknum=" + dianyingClicknum +
			", dianyingContent=" + dianyingContent +
			", dianyingDelete=" + dianyingDelete +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", newMoney=" + newMoney +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
