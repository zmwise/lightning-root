package com.osc.app.web.user;

import com.alibaba.fastjson.JSON;
import com.osc.app.properties.memcached.MemcachedProperties;
import com.osc.data.entity.user.User;
import com.osc.serviceuser.user.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 用户控制器
 * @author: lizhiming
 * @since: 2017/11/10
 */
@Api(value = "用户控制器",description = "【用户模块】用户相关API")
@RestController
@RequestMapping("/user")
public class UserController {
	
	protected static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;
	@Autowired
	private MemcachedProperties memcached;

	@ApiOperation(value = "保存用户",notes = "保存用户")
	@ApiImplicitParam(name = "User",value = "用户对象")
	@PostMapping("/saveUser")
	@ResponseBody
	public String saveUser(User user) {

		System.out.println(JSON.toJSONString(user));
		userService.saveUser(user);

		LOGGER.info("保存用户成功!");

		return "保存用户成功";
	}

	@ApiOperation(value = "获取所有用户",notes = "获取所有用户")
	@GetMapping("/getAllUser")
	public String getAllUser() {

		List<User> users = userService.getAllUser();

		System.out.println(JSON.toJSONString(users));
		LOGGER.info("memcached keyprefix="+memcached.getKeyprefix());
		LOGGER.info("memcached servers="+memcached.getServers());
		LOGGER.trace("获取所有用户 I am trace log.");
		LOGGER.debug("获取所有用户 I am debug log.");
		LOGGER.warn("获取所有用户 I am warn log.");
		LOGGER.error("获取所有用户 I am error log.");

		return JSON.toJSONString(users);

	}
}
