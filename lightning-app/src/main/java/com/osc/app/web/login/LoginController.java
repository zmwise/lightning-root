package com.osc.app.web.login;

import com.osc.app.syslog.SystemControllerLog;
import com.osc.common.result.Result;
import com.osc.common.result.ResultFactory;
import com.osc.pojo.vo.login.LoginVo;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 登录控制器
 * @author: lizhiming
 * @since: 2017/11/10
 */
@Api(value = "登录控制器",description = "【登录模块】登录API")
@RestController
public class LoginController {

    private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")
    @SystemControllerLog(description = "用户登录")
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
}
