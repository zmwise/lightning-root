package com.osc.oscashapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OscashAppApplicationTests {
	
	private static final Logger LOGGER = LogManager.getLogger(OscashAppApplicationTests.class);
	
	@Test
	public void contextLoads() {
		
		//userBankMapper.selectAll();
		LOGGER.trace("I am trace log.");  
		LOGGER.info("I am Info log");
        LOGGER.debug("I am debug log.");  
        LOGGER.warn("I am warn log.");  
        LOGGER.error("I am error log.");
        LOGGER.fatal("I am fatal log.");
        Integer aa = new Integer(10);
        Integer bb = new Integer(10);
		if(aa==bb){
			System.out.println(aa==bb);
		}
	}

}
