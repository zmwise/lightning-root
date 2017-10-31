package com.osc.oscashdao.entity.user.bank;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user_bank")
public class TUserBank implements Serializable {
    /**
     * 联系信息ID，主键
     */
    @Id
    @Column(name = "bank_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String bankId;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 银行卡类型
     */
    @Column(name = "bank_card_type")
    private String bankCardType;

    /**
     * 持卡人姓名
     */
    @Column(name = "card_holder_name")
    private String cardHolderName;

    /**
     * 身份证号
     */
    @Column(name = "id_card_no")
    private String idCardNo;

    /**
     * 银行卡号
     */
    @Column(name = "bank_card_no")
    private String bankCardNo;

    /**
     * 预留手机号
     */
    @Column(name = "reserved_phone_number")
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
    @Column(name = "bank_state")
    private Integer bankState;

    @Column(name = "created_date")
    private String createdDate;

    /**
     * 银行名称
     */
    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_code")
    private String bankCode;

    @Column(name = "card_type")
    private String cardType;

    private static final long serialVersionUID = 1L;

    /**
     * 获取联系信息ID，主键
     *
     * @return bank_id - 联系信息ID，主键
     */
    public String getBankId() {
        return bankId;
    }

    /**
     * 设置联系信息ID，主键
     *
     * @param bankId 联系信息ID，主键
     */
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    /**
     * 获取用户编号
     *
     * @return user_id - 用户编号
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户编号
     *
     * @param userId 用户编号
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取银行卡类型
     *
     * @return bank_card_type - 银行卡类型
     */
    public String getBankCardType() {
        return bankCardType;
    }

    /**
     * 设置银行卡类型
     *
     * @param bankCardType 银行卡类型
     */
    public void setBankCardType(String bankCardType) {
        this.bankCardType = bankCardType;
    }

    /**
     * 获取持卡人姓名
     *
     * @return card_holder_name - 持卡人姓名
     */
    public String getCardHolderName() {
        return cardHolderName;
    }

    /**
     * 设置持卡人姓名
     *
     * @param cardHolderName 持卡人姓名
     */
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    /**
     * 获取身份证号
     *
     * @return id_card_no - 身份证号
     */
    public String getIdCardNo() {
        return idCardNo;
    }

    /**
     * 设置身份证号
     *
     * @param idCardNo 身份证号
     */
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    /**
     * 获取银行卡号
     *
     * @return bank_card_no - 银行卡号
     */
    public String getBankCardNo() {
        return bankCardNo;
    }

    /**
     * 设置银行卡号
     *
     * @param bankCardNo 银行卡号
     */
    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    /**
     * 获取预留手机号
     *
     * @return reserved_phone_number - 预留手机号
     */
    public String getReservedPhoneNumber() {
        return reservedPhoneNumber;
    }

    /**
     * 设置预留手机号
     *
     * @param reservedPhoneNumber 预留手机号
     */
    public void setReservedPhoneNumber(String reservedPhoneNumber) {
        this.reservedPhoneNumber = reservedPhoneNumber;
    }

    /**
     * 获取性别（M男 F女）
     *
     * @return gender - 性别（M男 F女）
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别（M男 F女）
     *
     * @param gender 性别（M男 F女）
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取银行卡状态 0 未验证  1 已验证
     *
     * @return bank_state - 银行卡状态 0 未验证  1 已验证
     */
    public Integer getBankState() {
        return bankState;
    }

    /**
     * 设置银行卡状态 0 未验证  1 已验证
     *
     * @param bankState 银行卡状态 0 未验证  1 已验证
     */
    public void setBankState(Integer bankState) {
        this.bankState = bankState;
    }

    /**
     * @return created_date
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 获取银行名称
     *
     * @return bank_name - 银行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置银行名称
     *
     * @param bankName 银行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * @return bank_code
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * @param bankCode
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    /**
     * @return card_type
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * @param cardType
     */
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}