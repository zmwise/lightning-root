package com.osc.oscashserviceuser.user;

import com.github.pagehelper.PageHelper;
import com.osc.oscashdao.mapper.user.TUserMapper;
import com.osc.oscashentity.user.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @description: 用户Service实现类
 * @author: lizhiming
 * @since: 2017/11/10
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private TUserMapper userMapper;

	@Override
	public int saveUser(TUser user) {
		return userMapper.insert(user);
	}

	@Override
	public List<TUser> getAllUser() {
		PageHelper.startPage(1, 10);
		return userMapper.selectAll();
	}


}
