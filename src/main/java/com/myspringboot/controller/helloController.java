package com.myspringboot.controller;

import com.myspringboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class helloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
        if (user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World";
    }


    @RequestMapping("/success")
    public  String success(Map<String,Object> map){
        map.put("name","你好");
        map.put("users", Arrays.asList("张三","李四","王五"));
        return "success";
    }

    @RequestMapping({"/","/login.html"})
    public String login(){
        return  "login";
    }
}
