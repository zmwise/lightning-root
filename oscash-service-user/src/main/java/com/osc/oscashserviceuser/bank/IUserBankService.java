package com.osc.oscashserviceuser.bank;

import java.util.List;

import com.osc.oscashdao.entity.user.bank.TUserBank;



public interface IUserBankService {

	List<TUserBank> selectAll();
	
}
