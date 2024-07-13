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
 * 付费电影
 *
 * @author 
 * @email
 */
@TableName("dianying")
public class DianyingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DianyingEntity() {

	}

	public DianyingEntity(T t) {
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
     * 付费电影名称
     */
    @ColumnInfo(comment="付费电影名称",type="varchar(200)")
    @TableField(value = "dianying_name")

    private String dianyingName;


    /**
     * 付费电影编号
     */
    @ColumnInfo(comment="付费电影编号",type="varchar(200)")
    @TableField(value = "dianying_uuid_number")

    private String dianyingUuidNumber;


    /**
     * 付费电影照片
     */
    @ColumnInfo(comment="付费电影照片",type="varchar(200)")
    @TableField(value = "dianying_photo")

    private String dianyingPhoto;


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
    @TableField(value = "dianying_video")

    private String dianyingVideo;


    /**
     * 付费电影类型
     */
    @ColumnInfo(comment="付费电影类型",type="int(11)")
    @TableField(value = "dianying_types")

    private Integer dianyingTypes;


    /**
     * 金额
     */
    @ColumnInfo(comment="金额",type="decimal(10,2)")
    @TableField(value = "dianying_new_money")

    private Double dianyingNewMoney;


    /**
     * 付费电影热度
     */
    @ColumnInfo(comment="付费电影热度",type="int(11)")
    @TableField(value = "dianying_clicknum")

    private Integer dianyingClicknum;


    /**
     * 付费电影介绍
     */
    @ColumnInfo(comment="付费电影介绍",type="longtext")
    @TableField(value = "dianying_content")

    private String dianyingContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "dianying_delete")

    private Integer dianyingDelete;


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
	 * 获取：付费电影名称
	 */
    public String getDianyingName() {
        return dianyingName;
    }
    /**
	 * 设置：付费电影名称
	 */

    public void setDianyingName(String dianyingName) {
        this.dianyingName = dianyingName;
    }
    /**
	 * 获取：付费电影编号
	 */
    public String getDianyingUuidNumber() {
        return dianyingUuidNumber;
    }
    /**
	 * 设置：付费电影编号
	 */

    public void setDianyingUuidNumber(String dianyingUuidNumber) {
        this.dianyingUuidNumber = dianyingUuidNumber;
    }
    /**
	 * 获取：付费电影照片
	 */
    public String getDianyingPhoto() {
        return dianyingPhoto;
    }
    /**
	 * 设置：付费电影照片
	 */

    public void setDianyingPhoto(String dianyingPhoto) {
        this.dianyingPhoto = dianyingPhoto;
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
    public String getDianyingVideo() {
        return dianyingVideo;
    }
    /**
	 * 设置：电影
	 */

    public void setDianyingVideo(String dianyingVideo) {
        this.dianyingVideo = dianyingVideo;
    }
    /**
	 * 获取：付费电影类型
	 */
    public Integer getDianyingTypes() {
        return dianyingTypes;
    }
    /**
	 * 设置：付费电影类型
	 */

    public void setDianyingTypes(Integer dianyingTypes) {
        this.dianyingTypes = dianyingTypes;
    }
    /**
	 * 获取：金额
	 */
    public Double getDianyingNewMoney() {
        return dianyingNewMoney;
    }
    /**
	 * 设置：金额
	 */

    public void setDianyingNewMoney(Double dianyingNewMoney) {
        this.dianyingNewMoney = dianyingNewMoney;
    }
    /**
	 * 获取：付费电影热度
	 */
    public Integer getDianyingClicknum() {
        return dianyingClicknum;
    }
    /**
	 * 设置：付费电影热度
	 */

    public void setDianyingClicknum(Integer dianyingClicknum) {
        this.dianyingClicknum = dianyingClicknum;
    }
    /**
	 * 获取：付费电影介绍
	 */
    public String getDianyingContent() {
        return dianyingContent;
    }
    /**
	 * 设置：付费电影介绍
	 */

    public void setDianyingContent(String dianyingContent) {
        this.dianyingContent = dianyingContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getDianyingDelete() {
        return dianyingDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setDianyingDelete(Integer dianyingDelete) {
        this.dianyingDelete = dianyingDelete;
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
        return "Dianying{" +
            ", id=" + id +
            ", dianyingName=" + dianyingName +
            ", dianyingUuidNumber=" + dianyingUuidNumber +
            ", dianyingPhoto=" + dianyingPhoto +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", dianyingVideo=" + dianyingVideo +
            ", dianyingTypes=" + dianyingTypes +
            ", dianyingNewMoney=" + dianyingNewMoney +
            ", dianyingClicknum=" + dianyingClicknum +
            ", dianyingContent=" + dianyingContent +
            ", dianyingDelete=" + dianyingDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
