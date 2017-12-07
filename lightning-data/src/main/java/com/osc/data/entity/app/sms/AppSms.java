package com.osc.data.entity.app.sms;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * APP短信表(抓取)
 * </p>
 *
 * @author lizhiming
 * @since 2017-12-05
 */
@TableName("t_app_sms")
public class AppSms extends Model<AppSms> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 用户ID
     */
	private String userId;
    /**
     * 收件电话
     */
	private String consigneeTelephone;
    /**
     * 收件日期
     */
	private String consigneeDate;
    /**
     * 收件内容
     */
	private String context;
    /**
     * 类型(1:收件，2:发件)
     */
	private Integer type;
    /**
     * 创建时间
     */
	private Date createTime;
	private Date updateTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getConsigneeTelephone() {
		return consigneeTelephone;
	}

	public void setConsigneeTelephone(String consigneeTelephone) {
		this.consigneeTelephone = consigneeTelephone;
	}

	public String getConsigneeDate() {
		return consigneeDate;
	}

	public void setConsigneeDate(String consigneeDate) {
		this.consigneeDate = consigneeDate;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "AppSms{" +
			", id=" + id +
			", userId=" + userId +
			", consigneeTelephone=" + consigneeTelephone +
			", consigneeDate=" + consigneeDate +
			", context=" + context +
			", type=" + type +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			"}";
	}
}
