package com.osc.oscashdao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.osc.oscashdao.dao")
public class OscashDaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OscashDaoApplication.class, args);
	}
}
