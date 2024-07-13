package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 免费电影
 *
 * @author 
 * @email
 */
@TableName("mianfei")
public class MianfeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MianfeiEntity() {

	}

	public MianfeiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 免费电影名称
     */
    @ColumnInfo(comment="免费电影名称",type="varchar(200)")
    @TableField(value = "mianfei_name")

    private String mianfeiName;


    /**
     * 免费电影编号
     */
    @ColumnInfo(comment="免费电影编号",type="varchar(200)")
    @TableField(value = "mianfei_uuid_number")

    private String mianfeiUuidNumber;


    /**
     * 免费电影照片
     */
    @ColumnInfo(comment="免费电影照片",type="varchar(200)")
    @TableField(value = "mianfei_photo")

    private String mianfeiPhoto;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 电影
     */
    @ColumnInfo(comment="电影",type="varchar(200)")
    @TableField(value = "mianfei_video")

    private String mianfeiVideo;


    /**
     * 免费电影类型
     */
    @ColumnInfo(comment="免费电影类型",type="int(11)")
    @TableField(value = "mianfei_types")

    private Integer mianfeiTypes;


    /**
     * 免费电影热度
     */
    @ColumnInfo(comment="免费电影热度",type="int(11)")
    @TableField(value = "mianfei_clicknum")

    private Integer mianfeiClicknum;


    /**
     * 免费电影介绍
     */
    @ColumnInfo(comment="免费电影介绍",type="longtext")
    @TableField(value = "mianfei_content")

    private String mianfeiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "mianfei_delete")

    private Integer mianfeiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：免费电影名称
	 */
    public String getMianfeiName() {
        return mianfeiName;
    }
    /**
	 * 设置：免费电影名称
	 */

    public void setMianfeiName(String mianfeiName) {
        this.mianfeiName = mianfeiName;
    }
    /**
	 * 获取：免费电影编号
	 */
    public String getMianfeiUuidNumber() {
        return mianfeiUuidNumber;
    }
    /**
	 * 设置：免费电影编号
	 */

    public void setMianfeiUuidNumber(String mianfeiUuidNumber) {
        this.mianfeiUuidNumber = mianfeiUuidNumber;
    }
    /**
	 * 获取：免费电影照片
	 */
    public String getMianfeiPhoto() {
        return mianfeiPhoto;
    }
    /**
	 * 设置：免费电影照片
	 */

    public void setMianfeiPhoto(String mianfeiPhoto) {
        this.mianfeiPhoto = mianfeiPhoto;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：电影
	 */
    public String getMianfeiVideo() {
        return mianfeiVideo;
    }
    /**
	 * 设置：电影
	 */

    public void setMianfeiVideo(String mianfeiVideo) {
        this.mianfeiVideo = mianfeiVideo;
    }
    /**
	 * 获取：免费电影类型
	 */
    public Integer getMianfeiTypes() {
        return mianfeiTypes;
    }
    /**
	 * 设置：免费电影类型
	 */

    public void setMianfeiTypes(Integer mianfeiTypes) {
        this.mianfeiTypes = mianfeiTypes;
    }
    /**
	 * 获取：免费电影热度
	 */
    public Integer getMianfeiClicknum() {
        return mianfeiClicknum;
    }
    /**
	 * 设置：免费电影热度
	 */

    public void setMianfeiClicknum(Integer mianfeiClicknum) {
        this.mianfeiClicknum = mianfeiClicknum;
    }
    /**
	 * 获取：免费电影介绍
	 */
    public String getMianfeiContent() {
        return mianfeiContent;
    }
    /**
	 * 设置：免费电影介绍
	 */

    public void setMianfeiContent(String mianfeiContent) {
        this.mianfeiContent = mianfeiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getMianfeiDelete() {
        return mianfeiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setMianfeiDelete(Integer mianfeiDelete) {
        this.mianfeiDelete = mianfeiDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Mianfei{" +
            ", id=" + id +
            ", mianfeiName=" + mianfeiName +
            ", mianfeiUuidNumber=" + mianfeiUuidNumber +
            ", mianfeiPhoto=" + mianfeiPhoto +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", mianfeiVideo=" + mianfeiVideo +
            ", mianfeiTypes=" + mianfeiTypes +
            ", mianfeiClicknum=" + mianfeiClicknum +
            ", mianfeiContent=" + mianfeiContent +
            ", mianfeiDelete=" + mianfeiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
