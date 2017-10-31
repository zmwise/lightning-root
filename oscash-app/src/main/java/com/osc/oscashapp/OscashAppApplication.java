package com.osc.oscashapp;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = MybatisAutoConfiguration.class)
//@EnableAutoConfiguration
//@ServletComponentScan
//@EnableConfigurationProperties({MemcachedProperties.class})
@SpringBootApplication
@MapperScan("com.osc.oscashapp.mapper")
public class OscashAppApplication {
	
	private static final Logger LOGGER = LogManager.getLogger(OscashAppApplication.class);
	
	public static void main(String[] args) {
		LOGGER.info("【一秒现金APP启动】程序启动中，请稍后...");
		SpringApplication.run(Application.class, args);
		
		
		
		
	}
}
