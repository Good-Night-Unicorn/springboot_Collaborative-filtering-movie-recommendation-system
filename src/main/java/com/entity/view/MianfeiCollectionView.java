package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.MianfeiCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 免费电影收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("mianfei_collection")
public class MianfeiCollectionView extends MianfeiCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String mianfeiCollectionValue;

	//级联表 免费电影
		/**
		* 免费电影名称
		*/

		@ColumnInfo(comment="免费电影名称",type="varchar(200)")
		private String mianfeiName;
		/**
		* 免费电影编号
		*/

		@ColumnInfo(comment="免费电影编号",type="varchar(200)")
		private String mianfeiUuidNumber;
		/**
		* 免费电影照片
		*/

		@ColumnInfo(comment="免费电影照片",type="varchar(200)")
		private String mianfeiPhoto;
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
		private String mianfeiVideo;
		/**
		* 免费电影类型
		*/
		@ColumnInfo(comment="免费电影类型",type="int(11)")
		private Integer mianfeiTypes;
			/**
			* 免费电影类型的值
			*/
			@ColumnInfo(comment="免费电影类型的字典表值",type="varchar(200)")
			private String mianfeiValue;
		/**
		* 免费电影热度
		*/

		@ColumnInfo(comment="免费电影热度",type="int(11)")
		private Integer mianfeiClicknum;
		/**
		* 免费电影介绍
		*/

		@ColumnInfo(comment="免费电影介绍",type="longtext")
		private String mianfeiContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer mianfeiDelete;
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



	public MianfeiCollectionView() {

	}

	public MianfeiCollectionView(MianfeiCollectionEntity mianfeiCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, mianfeiCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getMianfeiCollectionValue() {
		return mianfeiCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setMianfeiCollectionValue(String mianfeiCollectionValue) {
		this.mianfeiCollectionValue = mianfeiCollectionValue;
	}


	//级联表的get和set 免费电影

		/**
		* 获取： 免费电影名称
		*/
		public String getMianfeiName() {
			return mianfeiName;
		}
		/**
		* 设置： 免费电影名称
		*/
		public void setMianfeiName(String mianfeiName) {
			this.mianfeiName = mianfeiName;
		}

		/**
		* 获取： 免费电影编号
		*/
		public String getMianfeiUuidNumber() {
			return mianfeiUuidNumber;
		}
		/**
		* 设置： 免费电影编号
		*/
		public void setMianfeiUuidNumber(String mianfeiUuidNumber) {
			this.mianfeiUuidNumber = mianfeiUuidNumber;
		}

		/**
		* 获取： 免费电影照片
		*/
		public String getMianfeiPhoto() {
			return mianfeiPhoto;
		}
		/**
		* 设置： 免费电影照片
		*/
		public void setMianfeiPhoto(String mianfeiPhoto) {
			this.mianfeiPhoto = mianfeiPhoto;
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
		public String getMianfeiVideo() {
			return mianfeiVideo;
		}
		/**
		* 设置： 电影
		*/
		public void setMianfeiVideo(String mianfeiVideo) {
			this.mianfeiVideo = mianfeiVideo;
		}
		/**
		* 获取： 免费电影类型
		*/
		public Integer getMianfeiTypes() {
			return mianfeiTypes;
		}
		/**
		* 设置： 免费电影类型
		*/
		public void setMianfeiTypes(Integer mianfeiTypes) {
			this.mianfeiTypes = mianfeiTypes;
		}


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

		/**
		* 获取： 免费电影热度
		*/
		public Integer getMianfeiClicknum() {
			return mianfeiClicknum;
		}
		/**
		* 设置： 免费电影热度
		*/
		public void setMianfeiClicknum(Integer mianfeiClicknum) {
			this.mianfeiClicknum = mianfeiClicknum;
		}

		/**
		* 获取： 免费电影介绍
		*/
		public String getMianfeiContent() {
			return mianfeiContent;
		}
		/**
		* 设置： 免费电影介绍
		*/
		public void setMianfeiContent(String mianfeiContent) {
			this.mianfeiContent = mianfeiContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getMianfeiDelete() {
			return mianfeiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setMianfeiDelete(Integer mianfeiDelete) {
			this.mianfeiDelete = mianfeiDelete;
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
		return "MianfeiCollectionView{" +
			", mianfeiCollectionValue=" + mianfeiCollectionValue +
			", mianfeiName=" + mianfeiName +
			", mianfeiUuidNumber=" + mianfeiUuidNumber +
			", mianfeiPhoto=" + mianfeiPhoto +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", mianfeiVideo=" + mianfeiVideo +
			", mianfeiClicknum=" + mianfeiClicknum +
			", mianfeiContent=" + mianfeiContent +
			", mianfeiDelete=" + mianfeiDelete +
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
