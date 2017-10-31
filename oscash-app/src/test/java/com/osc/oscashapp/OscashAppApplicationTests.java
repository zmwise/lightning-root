package com.osc.oscashapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.osc.oscashdao.mapper.user.bank.TUserBankMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OscashAppApplicationTests {
	
	private static final Logger LOGGER = LogManager.getLogger(OscashAppApplicationTests.class);
	
	@Autowired
    private TUserBankMapper userBankMapper;

	@Test
	public void contextLoads() {
		
		//userBankMapper.selectAll();
		LOGGER.trace("I am trace log.");  
		LOGGER.info("I am Info log");
        LOGGER.debug("I am debug log.");  
        LOGGER.warn("I am warn log.");  
        LOGGER.error("I am error log.");
        LOGGER.fatal("I am fatal log.");
	}

}
