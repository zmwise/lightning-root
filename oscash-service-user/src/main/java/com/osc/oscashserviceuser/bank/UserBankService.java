package com.osc.oscashserviceuser.bank;

import java.util.List;

import com.osc.oscashentity.user.bank.TUserBank;



public interface UserBankService {
	/**
	 * 返回所有用户
	 * @return
	 */
	List<TUserBank> selectAll();
	
}
