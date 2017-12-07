package com.osc.app.exception;

import com.osc.common.constant.status.Status;
import com.osc.common.exception.ServiceException;
import com.osc.common.result.Result;
import com.osc.common.result.ResultFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 全局异常处理
 * @author: lizhiming
 * @since: 2017/11/25
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {

        LOGGER.info("【全局异常处理】请求URL>>"+request.getRequestURL().toString());
        LOGGER.info("【全局异常处理】HTTP状态>>"+response.getStatus());

        if (e instanceof IllegalArgumentException){
            LOGGER.error("【特殊异常处理】(400)请求参数异常 —— 异常消息>>" + e.getMessage());
            return ResultFactory.result(Status.BAD_REQUEST,Status.BAD_REQUEST_MSG);
        }else if (e instanceof UnauthenticatedException) {
            LOGGER.error("【特殊异常处理】(401)未登录或登录已超时 —— 异常消息>>" + e.getMessage());
            return ResultFactory.result(Status.UNAUTHORIZED, Status.UNAUTHORIZED_MSG);
        }else if (e instanceof ServiceException){
            LOGGER.error("【业务异常处理】业务异常 —— 异常码>>" + ((ServiceException) e).getCode() + "  异常消息>>" + e.getMessage());
            if(((ServiceException) e).getCode() == 0){
                return ResultFactory.result(Status.BAD_REQUEST,e.getMessage());
            }else{
                return ResultFactory.result(((ServiceException) e).getCode(),e.getMessage());
            }
        }
        LOGGER.error("【全局异常处理】异常消息>>"+e.getMessage(),e);
        return ResultFactory.result(Status.INTERNAL_SERVER_ERROR,Status.INTERNAL_SERVER_ERROR_MSG);
    }
}
