package com.osc.oscashapp.config.aop;

import com.alibaba.fastjson.JSON;
import com.osc.oscashapp.syslog.SystemControllerLog;
import com.osc.oscashapp.syslog.SystemServiceLog;
import com.osc.oscashdao.entity.user.User;
import com.osc.oscashserviceuser.user.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @description: AOP统一处理WEB请求日志
 * @author: lizhiming
 * @since: 2017/11/27
 */
@Aspect
@Component
public class WebLogAspect {

    private static final Logger LOGGER = LogManager.getLogger(WebLogAspect.class);

    @Autowired
    private IUserService userService;

    //Controller层切点
    @Pointcut("@annotation(com.osc.oscashapp.syslog.SystemControllerLog)")
    public void controllerAspect(){
    }

    //Service层切点
    @Pointcut("@annotation(com.osc.oscashapp.syslog.SystemControllerLog)")
    public void serviceAspect(){
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     * @param point
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint point) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        long beginTime = System.currentTimeMillis();

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod(); //获取被拦截的方法
        String methodName = method.getName(); //获取被拦截的方法名

        //获取请求ip
        String ip = request.getRemoteAddr();

        //获取用户请求方法的参数并序列化为JSON格式字符串
        String params = "";
        if (point.getArgs() != null && point.getArgs().length > 0) {
            for (int i = 0; i < point.getArgs().length; i++) {
                params += JSON.toJSONString(point.getArgs()[i]) + ";";
            }
        }
        System.out.println("异常方法:" + (point.getTarget().getClass().getName() + "." + point.getSignature().getName() + "()"));
        System.out.println("请求人: + user.getName()");
        System.out.println("请求IP:" + ip);
        System.out.println("请求参数:" + params);
        try {
            System.out.println("方法描述:" + getControllerMethodDescription(point));
        } catch (Exception ex){
            LOGGER.info("【WEB请求日志】获取请求方法描述异常：" + ex.getMessage());
        }
        List<User> users = userService.getAllUser();
        System.out.println("users:" + JSON.toJSONString(users));
        long costMs = System.currentTimeMillis() - beginTime;
        LOGGER.info("【WEB请求日志】切入点请求方法名称：{}  耗时：{}ms", methodName, costMs);
        LOGGER.info("【WEB请求日志】请求方法参数：" + JSON.toJSONString(params));
    }

    /**
     * 异常通知 用于拦截service层记录异常日志
     * @param point
     */
    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint point, Throwable e) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        long beginTime = System.currentTimeMillis();

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod(); //获取被拦截的方法
        String methodName = method.getName(); //获取被拦截的方法名

        //获取请求ip
        String ip = request.getRemoteAddr();

        //获取用户请求方法的参数并序列化为JSON格式字符串
        String params = "";
        if (point.getArgs() != null && point.getArgs().length > 0) {
            for (int i = 0; i < point.getArgs().length; i++) {
                params += JSON.toJSONString(point.getArgs()[i]) + ";";
            }
        }
        System.out.println("异常代码:" + e.getClass().getName());
        System.out.println("异常信息:" + e.getMessage());
        System.out.println("异常方法:" + (point.getTarget().getClass().getName() + "." + point.getSignature().getName() + "()"));
        System.out.println("请求人: + user.getName()");
        System.out.println("请求IP:" + ip);
        System.out.println("请求参数:" + params);
        try {
            System.out.println("方法描述:" + getServiceMthodDescription(point));
        } catch (Exception ex){
            LOGGER.info("【WEB请求日志】获取请求方法描述异常：" + ex.getMessage());
        }

        long costMs = System.currentTimeMillis() - beginTime;
        LOGGER.info("【WEB请求日志】切入点请求方法名称：{}  耗时：{}ms", methodName, costMs);
        LOGGER.info("【WEB请求日志】请求方法参数：" + JSON.toJSONString(params));
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemControllerLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

    /**
     * 获取注解中对方法的描述信息 用于service层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getServiceMthodDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemServiceLog.class).description();
                    break;
                }
            }
        }
        return description;
    }
}
