package com.app2.app2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App2Controller {
    
    @RequestMapping(path = "/getApp2Name", method = RequestMethod.GET)
    public String app1Name() {
        return "App2Controller";
    }
}
