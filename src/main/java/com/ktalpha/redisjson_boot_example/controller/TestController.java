package com.ktalpha.redisjson_boot_example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping(value = "/home")
    public String home(){

        return "index.html";
    }
}