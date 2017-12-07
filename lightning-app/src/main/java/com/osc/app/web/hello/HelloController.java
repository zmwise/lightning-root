package com.osc.app.web.hello;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: HelloController
 * @author: lizhiming
 * @since: 2017/11/10
 */
@Api(value = "HELLO控制器",description = "【HELLO模块】HELLO演示")
@RestController
public class HelloController {
	
	@GetMapping("/error")
    public String index() {
        return "Hello World Error";
    }
	
}
