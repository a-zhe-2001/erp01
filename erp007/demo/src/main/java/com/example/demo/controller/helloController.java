package com.example.demo.controller;

import com.baomidou.mybatisplus.annotation.TableName;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class helloController {
    @GetMapping
    public String hello(){
        return "hello Controller";
    }

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> list(){
        return userService.listAll();

//        return userService.listAll();
    }


}
