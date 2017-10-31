package com.osc.oscashapp.service.user.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.osc.oscashdao.entity.user.bank.TUserBank;
import com.osc.oscashdao.mapper.user.bank.TUserBankMapper;

@Service
public class UserBankServiceImpl implements UserBankService{
	
	@Autowired
	private TUserBankMapper userBankMapper;

	@Override
	public List<TUserBank> getAll() {
		PageHelper.startPage(1, 10);
		return userBankMapper.selectAll();
	}

	
}
