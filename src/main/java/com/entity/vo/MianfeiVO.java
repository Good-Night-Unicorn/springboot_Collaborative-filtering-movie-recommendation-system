package com.entity.vo;

import com.entity.MianfeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 免费电影
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("mianfei")
public class MianfeiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 免费电影名称
     */

    @TableField(value = "mianfei_name")
    private String mianfeiName;


    /**
     * 免费电影编号
     */

    @TableField(value = "mianfei_uuid_number")
    private String mianfeiUuidNumber;


    /**
     * 免费电影照片
     */

    @TableField(value = "mianfei_photo")
    private String mianfeiPhoto;


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

    @TableField(value = "mianfei_video")
    private String mianfeiVideo;


    /**
     * 免费电影类型
     */

    @TableField(value = "mianfei_types")
    private Integer mianfeiTypes;


    /**
     * 免费电影热度
     */

    @TableField(value = "mianfei_clicknum")
    private Integer mianfeiClicknum;


    /**
     * 免费电影介绍
     */

    @TableField(value = "mianfei_content")
    private String mianfeiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "mianfei_delete")
    private Integer mianfeiDelete;


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
	 * 设置：免费电影名称
	 */
    public String getMianfeiName() {
        return mianfeiName;
    }


    /**
	 * 获取：免费电影名称
	 */

    public void setMianfeiName(String mianfeiName) {
        this.mianfeiName = mianfeiName;
    }
    /**
	 * 设置：免费电影编号
	 */
    public String getMianfeiUuidNumber() {
        return mianfeiUuidNumber;
    }


    /**
	 * 获取：免费电影编号
	 */

    public void setMianfeiUuidNumber(String mianfeiUuidNumber) {
        this.mianfeiUuidNumber = mianfeiUuidNumber;
    }
    /**
	 * 设置：免费电影照片
	 */
    public String getMianfeiPhoto() {
        return mianfeiPhoto;
    }


    /**
	 * 获取：免费电影照片
	 */

    public void setMianfeiPhoto(String mianfeiPhoto) {
        this.mianfeiPhoto = mianfeiPhoto;
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
    public String getMianfeiVideo() {
        return mianfeiVideo;
    }


    /**
	 * 获取：电影
	 */

    public void setMianfeiVideo(String mianfeiVideo) {
        this.mianfeiVideo = mianfeiVideo;
    }
    /**
	 * 设置：免费电影类型
	 */
    public Integer getMianfeiTypes() {
        return mianfeiTypes;
    }


    /**
	 * 获取：免费电影类型
	 */

    public void setMianfeiTypes(Integer mianfeiTypes) {
        this.mianfeiTypes = mianfeiTypes;
    }
    /**
	 * 设置：免费电影热度
	 */
    public Integer getMianfeiClicknum() {
        return mianfeiClicknum;
    }


    /**
	 * 获取：免费电影热度
	 */

    public void setMianfeiClicknum(Integer mianfeiClicknum) {
        this.mianfeiClicknum = mianfeiClicknum;
    }
    /**
	 * 设置：免费电影介绍
	 */
    public String getMianfeiContent() {
        return mianfeiContent;
    }


    /**
	 * 获取：免费电影介绍
	 */

    public void setMianfeiContent(String mianfeiContent) {
        this.mianfeiContent = mianfeiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getMianfeiDelete() {
        return mianfeiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setMianfeiDelete(Integer mianfeiDelete) {
        this.mianfeiDelete = mianfeiDelete;
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
