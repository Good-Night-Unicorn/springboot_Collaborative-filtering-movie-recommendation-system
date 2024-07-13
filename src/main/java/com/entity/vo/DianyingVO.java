package com.entity.vo;

import com.entity.DianyingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 付费电影
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("dianying")
public class DianyingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 付费电影名称
     */

    @TableField(value = "dianying_name")
    private String dianyingName;


    /**
     * 付费电影编号
     */

    @TableField(value = "dianying_uuid_number")
    private String dianyingUuidNumber;


    /**
     * 付费电影照片
     */

    @TableField(value = "dianying_photo")
    private String dianyingPhoto;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 电影
     */

    @TableField(value = "dianying_video")
    private String dianyingVideo;


    /**
     * 付费电影类型
     */

    @TableField(value = "dianying_types")
    private Integer dianyingTypes;


    /**
     * 金额
     */

    @TableField(value = "dianying_new_money")
    private Double dianyingNewMoney;


    /**
     * 付费电影热度
     */

    @TableField(value = "dianying_clicknum")
    private Integer dianyingClicknum;


    /**
     * 付费电影介绍
     */

    @TableField(value = "dianying_content")
    private String dianyingContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "dianying_delete")
    private Integer dianyingDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：付费电影名称
	 */
    public String getDianyingName() {
        return dianyingName;
    }


    /**
	 * 获取：付费电影名称
	 */

    public void setDianyingName(String dianyingName) {
        this.dianyingName = dianyingName;
    }
    /**
	 * 设置：付费电影编号
	 */
    public String getDianyingUuidNumber() {
        return dianyingUuidNumber;
    }


    /**
	 * 获取：付费电影编号
	 */

    public void setDianyingUuidNumber(String dianyingUuidNumber) {
        this.dianyingUuidNumber = dianyingUuidNumber;
    }
    /**
	 * 设置：付费电影照片
	 */
    public String getDianyingPhoto() {
        return dianyingPhoto;
    }


    /**
	 * 获取：付费电影照片
	 */

    public void setDianyingPhoto(String dianyingPhoto) {
        this.dianyingPhoto = dianyingPhoto;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：电影
	 */
    public String getDianyingVideo() {
        return dianyingVideo;
    }


    /**
	 * 获取：电影
	 */

    public void setDianyingVideo(String dianyingVideo) {
        this.dianyingVideo = dianyingVideo;
    }
    /**
	 * 设置：付费电影类型
	 */
    public Integer getDianyingTypes() {
        return dianyingTypes;
    }


    /**
	 * 获取：付费电影类型
	 */

    public void setDianyingTypes(Integer dianyingTypes) {
        this.dianyingTypes = dianyingTypes;
    }
    /**
	 * 设置：金额
	 */
    public Double getDianyingNewMoney() {
        return dianyingNewMoney;
    }


    /**
	 * 获取：金额
	 */

    public void setDianyingNewMoney(Double dianyingNewMoney) {
        this.dianyingNewMoney = dianyingNewMoney;
    }
    /**
	 * 设置：付费电影热度
	 */
    public Integer getDianyingClicknum() {
        return dianyingClicknum;
    }


    /**
	 * 获取：付费电影热度
	 */

    public void setDianyingClicknum(Integer dianyingClicknum) {
        this.dianyingClicknum = dianyingClicknum;
    }
    /**
	 * 设置：付费电影介绍
	 */
    public String getDianyingContent() {
        return dianyingContent;
    }


    /**
	 * 获取：付费电影介绍
	 */

    public void setDianyingContent(String dianyingContent) {
        this.dianyingContent = dianyingContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getDianyingDelete() {
        return dianyingDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setDianyingDelete(Integer dianyingDelete) {
        this.dianyingDelete = dianyingDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
