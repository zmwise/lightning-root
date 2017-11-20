package com.osc.oscashapp.web.user;

import com.alibaba.fastjson.JSONObject;
import com.osc.oscashapp.properties.memcached.MemcachedProperties;
import com.osc.oscashdao.entity.user.User;
import com.osc.oscashserviceuser.user.IUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: UseController
 * @author: lizhiming
 * @since: 2017/11/10
 */
@RestController
@RequestMapping("/user")
public class UseController {
	
	protected static Logger LOGGER = LoggerFactory.getLogger(UseController.class);
	
	@Autowired
	private IUserService userService;
	@Autowired
	private MemcachedProperties memcached;

	@ApiOperation(value = "保存用户",notes = "保存用户")
	@ApiImplicitParam(name = "TUser",value = "用户对象")
	@PostMapping("/saveUser")
    public String saveUser(User user) {

		userService.saveUser(user);

		LOGGER.info("保存用户成功!");

        return "保存用户成功";
    }

	@ApiOperation(value = "获取所有用户",notes = "获取所有用户")
	@GetMapping("/getAllUser")
	public String getAllUser() {

		List<User> users = userService.getAllUser();

		System.out.println(JSONObject.toJSON(users).toString());
		LOGGER.info("memcached keyprefix="+memcached.getKeyprefix());
		LOGGER.info("memcached servers="+memcached.getServers());
		LOGGER.trace("获取所有用户 I am trace log.");
		LOGGER.debug("获取所有用户 I am debug log.");
		LOGGER.warn("获取所有用户 I am warn log.");
		LOGGER.error("获取所有用户 I am error log.");

		return JSONObject.toJSON(users).toString();

	}
}
