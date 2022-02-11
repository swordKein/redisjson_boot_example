package com.ktalpha.redisjson_boot_example.controller;

import com.ktalpha.redisjson_boot_example.service.RedisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @Autowired
    public RedisTestService redisTestService;

    @RequestMapping(value = "/home")
    public String home(){
        try {
            redisTestService.test1();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index.html";
    }
}