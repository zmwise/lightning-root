package com.osc.oscashdao.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.osc.oscashdao.entity.user.bank.TUserBank;
import com.osc.oscashdao.mapper.user.bank.TUserBankMapper;

@RestController
public class UserBankController {
	
	protected static Logger LOGGER = LoggerFactory.getLogger(UserBankController.class);
	
	@Autowired
	private TUserBankMapper userBankMapper;
	
	@GetMapping("/bank")
    public String getUserBank(String bankId) {
		List<TUserBank> banks = userBankMapper.selectAll();
		System.out.println(JSONObject.toJSON(banks).toString());
        return JSONObject.toJSON(banks).toString();
    }
}
