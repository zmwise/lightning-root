package com.osc.oscashapp.web.example;

import com.alibaba.fastjson.JSON;
import com.osc.oscashcommon.utils.dozer.BeanMapper;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    static Mapper mapper = new DozerBeanMapper();

    @RequestMapping("/test")
    public EmployeeB test(){
        EmployeeA employeeA = new EmployeeA();
        employeeA.setLastName("jiyeon");
        employeeA.setFirstName("seo");
        employeeA.setBirthday(new Date());

        EmployeeB employee = BeanMapper.map(employeeA, EmployeeB.class);

        LOGGER.info("EmployeeB>>"+ JSON.toJSONString(employee));
        return employee;
    }
}
