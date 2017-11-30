package com.osc.oscashapp.web.example;

import com.alibaba.fastjson.JSON;
import com.osc.oscashapp.syslog.SystemControllerLog;
import com.osc.oscashcommon.utils.dozer.BeanUtil;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @description: 示例控制器
 * @author: lizhiming
 * @since: 2017/11/27
 */
@RestController
@RequestMapping("/example")
public class ExampleController {

    private static Logger LOGGER = LoggerFactory.getLogger(ExampleController.class);

    @Autowired
    BeanUtil beanUtil;

    @RequestMapping("/test")
    @SystemControllerLog(description = "test")
    public EmployeeB test(){
        EmployeeA employeeA = new EmployeeA();
        employeeA.setLastName("jiyeon");
        employeeA.setFirstName("seo");
        employeeA.setBirthday(new Date());

        EmployeeB employee = beanUtil.map(employeeA, EmployeeB.class);

        LOGGER.info("EmployeeB>>"+ JSON.toJSONString(employee));
        return employee;
    }
}
