package com.osc.oscashserviceuser.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.osc.oscashdao.mapper.user.bank.TUserBankMapper;
import com.osc.oscashentity.user.bank.TUserBank;

@Service
public class UserBankService implements IUserBankService{
	
	@Autowired
	private TUserBankMapper userBankMapper;

	@Override
	public List<TUserBank> selectAll() {
		PageHelper.startPage(1, 10);
		return userBankMapper.selectAll();
	}

	
}
