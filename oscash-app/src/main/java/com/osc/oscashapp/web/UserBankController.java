package com.osc.oscashapp.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.osc.oscashapp.properties.memcached.MemcachedProperties;
import com.osc.oscashdao.entity.user.bank.TUserBank;
import com.osc.oscashdao.mapper.user.bank.TUserBankMapper;
import com.osc.oscashserviceuser.bank.IUserBankService;

@RestController
public class UserBankController {
	
	protected static Logger LOGGER = LoggerFactory.getLogger(UserBankController.class);
	
	@Autowired
	private IUserBankService userBankService;
	@Autowired
	private TUserBankMapper userBankMapper;
	@Autowired
	private MemcachedProperties memcached;
	
	@GetMapping("/bank")
    public String getUserBank(String bankId) {
		List<TUserBank> userBanks = userBankService.selectAll();
		System.out.println(JSONObject.toJSON(userBanks).toString());
		LOGGER.info("memcached keyprefix="+memcached.getKeyprefix());
		LOGGER.info("memcached servers="+memcached.getServers());
		LOGGER.trace("I am trace log.");  
		LOGGER.debug("I am debug log.");  
        LOGGER.warn("I am warn log.");  
        LOGGER.error("I am error log.");
        return JSONObject.toJSON(userBanks).toString();
    }
}
