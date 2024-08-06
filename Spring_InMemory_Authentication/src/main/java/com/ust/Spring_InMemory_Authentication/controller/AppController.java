package com.ust.Spring_InMemory_Authentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {

    @GetMapping("/user")
    public String user(){return  "Hey user...";}



    @GetMapping("/admin")
    public String admin(){return  "Hey admin...";}
}
