package com.osc.app;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

//@SpringBootApplication(exclude = MybatisAutoConfiguration.class)
//@EnableAutoConfiguration
//@EnableConfigurationProperties({MemcachedProperties.class})
/**
 * @Description: OscashAppApplication
 * @Author: lizhiming
 * @Since: 2017/11/10
 */
@SpringBootApplication
@MapperScan("com.osc.data.dao")
@ComponentScan(basePackages={"com.osc.serviceuser","com.osc.serviceredis","com.osc.servicerabbitmq","com.osc.app"})
//@EnableScheduling //开启定时任务
//@ServletComponentScan
public class AppApplication {

	private static final Logger LOGGER = LogManager.getLogger(AppApplication.class);

	public static void main(String[] args) {
		LOGGER.info("【闪电花APP】程序启动中，请稍后...");
		SpringApplication.run(AppApplication.class, args);




	}
}
