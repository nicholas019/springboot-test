package com.marustudy.testproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    @RequestMapping(value = "/hello", method = RequestMethod.GET) // 과거 방식
    @GetMapping("hello")
    public String hello(){
        return "Hello World!! ";
    }
}
