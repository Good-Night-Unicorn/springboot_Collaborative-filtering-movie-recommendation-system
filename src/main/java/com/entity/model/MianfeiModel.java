package com.entity.model;

import com.entity.MianfeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 免费电影
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MianfeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 免费电影名称
     */
    private String mianfeiName;


    /**
     * 免费电影编号
     */
    private String mianfeiUuidNumber;


    /**
     * 免费电影照片
     */
    private String mianfeiPhoto;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 电影
     */
    private String mianfeiVideo;


    /**
     * 免费电影类型
     */
    private Integer mianfeiTypes;


    /**
     * 免费电影热度
     */
    private Integer mianfeiClicknum;


    /**
     * 免费电影介绍
     */
    private String mianfeiContent;


    /**
     * 逻辑删除
     */
    private Integer mianfeiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
