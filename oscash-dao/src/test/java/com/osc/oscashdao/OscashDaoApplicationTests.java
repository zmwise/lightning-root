package com.osc.oscashdao;

import com.osc.oscashdao.mapper.user.TUserMapper;
import com.osc.oscashentity.user.TUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OscashDaoApplicationTests {

	@Autowired
    private TUserMapper userMapper;

	@Test
	public void contextLoads() {
		List<TUser> users = userMapper.selectAll();
		System.out.println(users.size());
	}

}
