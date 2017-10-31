package com.osc.oscashapp.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.osc.oscashapp.properties.memcached.MemcachedProperties;
import com.osc.oscashapp.service.user.bank.UserBankService;
import com.osc.oscashdao.entity.user.bank.TUserBank;

@RestController
public class UserBankController {
	
	protected static Logger LOGGER = LoggerFactory.getLogger(UserBankController.class);
	
	@Autowired
	private UserBankService userBankService;
	@Autowired
	private MemcachedProperties memcached;
	
	@GetMapping("/bank")
    public String getUserBank(String bankId) {
		List<TUserBank> userBanks = userBankService.getAll();
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
