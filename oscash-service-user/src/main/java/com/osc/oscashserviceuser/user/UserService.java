package com.osc.oscashserviceuser.user;

import com.osc.oscashentity.user.TUser;

import java.util.List;

/**
 * @description: UserService
 * @author: lizhiming
 * @since: 2017/11/10
 */
public interface UserService {
	/**
	 * 保存用户
	 * @return
	 */
	int saveUser(TUser user);
	/**
	 * 获取所有用户
	 * @return
	 */
	List<TUser> getAllUser();
}
