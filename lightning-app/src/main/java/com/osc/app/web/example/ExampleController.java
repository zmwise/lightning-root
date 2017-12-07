package com.osc.app.web.example;

import com.alibaba.fastjson.JSON;
import com.osc.app.properties.memcached.MemcachedProperties;
import com.osc.app.syslog.SystemControllerLog;
import com.osc.common.exception.ServiceException;
import com.osc.common.result.Result;
import com.osc.common.result.ResultFactory;
import com.osc.common.utils.dozer.BeanUtil;
import com.osc.data.entity.user.User;
import com.osc.pojo.vo.login.LoginVo;
import com.osc.serviceuser.user.IUserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 * @description: 示例控制器
 * @author: lizhiming
 * @since: 2017/11/27
 */
@Api(value = "示例控制器",description = "【DEMO模块】DEMO演示")
@RestController
@RequestMapping("/example")
public class ExampleController {

    private static Logger LOGGER = LoggerFactory.getLogger(ExampleController.class);

    @Autowired
    BeanUtil beanUtil;
    @Autowired
    private IUserService userService;
    @Autowired
    private MemcachedProperties memcached;

    /**
     * 对象复制示例
     * @return
     */
    @GetMapping("/copy")
    @ApiOperation(value = "【DEMO模块】对象复制示例")
    @SystemControllerLog(description = "对象复制示例")
    public String copy(){
        EmployeeA employeeA = new EmployeeA();
        employeeA.setLastName("jiyeon");
        employeeA.setFirstName("seo");
        employeeA.setBirthday(new Date());

        EmployeeB employee = beanUtil.map(employeeA, EmployeeB.class);

        LOGGER.info("EmployeeB>>"+ JSON.toJSONString(employee));
        return JSON.toJSONString(employee);
    }

    /**
     * 业务异常处理示例
     * @return
     */
    @GetMapping("/exception")
    @ApiOperation(value = "【DEMO模块】业务异常处理示例")
    @SystemControllerLog(description = "业务异常处理示例")
    public String exception(){
        throw new ServiceException(1001,"用户已注册");
    }

    /**
     * 常用异常处理示例
     * @return
     */
    @GetMapping("/excep")
    @ApiOperation(value = "【DEMO模块】常用异常处理示例")
    @SystemControllerLog(description = "常用异常处理示例")
    public String excep(){
        throw new NullPointerException();
    }

    /**
     * 登录API接口示例
     * @param loginVo
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "【DEMO模块】用户登录",notes = "用户登录API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true,
                    dataType = "string", paramType = "query", defaultValue = "admin"),
            @ApiImplicitParam(name = "password", value = "密码", required = true,
                    dataType = "string", paramType = "query", defaultValue = "123456")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 400, message = "请求参数异常"),
            @ApiResponse(code = 401, message = "未登录或未授权"),
            @ApiResponse(code = 404, message = "未找到"),
            @ApiResponse(code = 500, message = "服务器异常")}
    )
    public Result login(@RequestBody LoginVo loginVo){

        LOGGER.info("【用户登录】用户名>>"+loginVo.getUsername()+"   密码>>"+loginVo.getPassword());

        return ResultFactory.successResult();
    }

    /**
     * 系统日志示例
     * @param user
     * @return
     */
    @PostMapping("/saveUser")
    @ApiOperation(value = "【DEMO模块】系统日志示例")
    @SystemControllerLog(description = "新增用户")
    @ResponseBody
    public Result saveUser(@RequestBody User user) {

        LOGGER.info("【新增用户】用户名>>"+user.getUname()+"   密码>>"+user.getPasswd());

        userService.saveUser(user);

        LOGGER.info("新增用户成功!");

        return ResultFactory.successResult();
    }

    /**
     * 属性参数获取示例
     * @return
     */
    @GetMapping("/getAllUser")
    @ApiOperation(value = "【DEMO模块】属性参数获取示例")
    public Result getAllUser() {

        LOGGER.info("memcached keyprefix="+memcached.getKeyprefix());
        LOGGER.info("memcached servers="+memcached.getServers());

        LOGGER.trace("获取所有用户 I am trace log.");
        LOGGER.debug("获取所有用户 I am debug log.");
        LOGGER.warn("获取所有用户 I am warn log.");
        LOGGER.error("获取所有用户 I am error log.");

        List<User> users = userService.getAllUser();

        return ResultFactory.successData(users);

    }
}
