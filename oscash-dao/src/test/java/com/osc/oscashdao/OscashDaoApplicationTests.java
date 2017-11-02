package com.osc.oscashdao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.osc.oscashdao.mapper.user.bank.TUserBankMapper;
import com.osc.oscashentity.user.bank.TUserBank;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OscashDaoApplicationTests {

	@Autowired
    private TUserBankMapper userBankMapper;

	@Test
	public void contextLoads() {
		List<TUserBank> banks = userBankMapper.selectAll();
		System.out.println(banks.size());
	}

}
