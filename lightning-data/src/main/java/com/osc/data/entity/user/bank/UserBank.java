package com.osc.data.entity.user.bank;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author lizhiming
 * @since 2017-11-21
 */
@TableName("t_user_bank")
public class UserBank extends Model<UserBank> {

    private static final long serialVersionUID = 1L;

    /**
     * 联系信息ID，主键
     */
    @TableId("bank_id")
	private String bankId;
    /**
     * 用户编号
     */
	@TableField("user_id")
	private String userId;
    /**
     * 银行卡类型
     */
	@TableField("bank_card_type")
	private String bankCardType;
    /**
     * 持卡人姓名
     */
	@TableField("card_holder_name")
	private String cardHolderName;
    /**
     * 身份证号
     */
	@TableField("id_card_no")
	private String idCardNo;
    /**
     * 银行卡号
     */
	@TableField("bank_card_no")
	private String bankCardNo;
    /**
     * 预留手机号
     */
	@TableField("reserved_phone_number")
	private String reservedPhoneNumber;
    /**
     * 性别（M男 F女）
     */
	private String gender;
    /**
     * 生日
     */
	private Date birthday;
    /**
     * 银行卡状态 0 未验证  1 已验证
     */
	@TableField("bank_state")
	private Integer bankState;
	@TableField("created_date")
	private String createdDate;
    /**
     * 银行名称
     */
	@TableField("bank_name")
	private String bankName;
	@TableField("bank_code")
	private String bankCode;
	@TableField("card_type")
	private String cardType;


	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBankCardType() {
		return bankCardType;
	}

	public void setBankCardType(String bankCardType) {
		this.bankCardType = bankCardType;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	public String getReservedPhoneNumber() {
		return reservedPhoneNumber;
	}

	public void setReservedPhoneNumber(String reservedPhoneNumber) {
		this.reservedPhoneNumber = reservedPhoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getBankState() {
		return bankState;
	}

	public void setBankState(Integer bankState) {
		this.bankState = bankState;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	@Override
	protected Serializable pkVal() {
		return this.bankId;
	}

	@Override
	public String toString() {
		return "UserBank{" +
			", bankId=" + bankId +
			", userId=" + userId +
			", bankCardType=" + bankCardType +
			", cardHolderName=" + cardHolderName +
			", idCardNo=" + idCardNo +
			", bankCardNo=" + bankCardNo +
			", reservedPhoneNumber=" + reservedPhoneNumber +
			", gender=" + gender +
			", birthday=" + birthday +
			", bankState=" + bankState +
			", createdDate=" + createdDate +
			", bankName=" + bankName +
			", bankCode=" + bankCode +
			", cardType=" + cardType +
			"}";
	}
}
