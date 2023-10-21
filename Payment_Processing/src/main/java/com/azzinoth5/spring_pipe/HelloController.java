package com.azzinoth5.spring_pipe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String hello() {
        return "Hello APP";
    }
}
