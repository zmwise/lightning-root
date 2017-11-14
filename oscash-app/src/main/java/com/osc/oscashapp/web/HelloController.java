package com.osc.oscashapp.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: HelloController
 * @author: lizhiming
 * @since: 2017/11/10
 */
@RestController
public class HelloController {
	
	@GetMapping("/error")
    public String index() {
        return "Hello World Error";
    }
	
}
