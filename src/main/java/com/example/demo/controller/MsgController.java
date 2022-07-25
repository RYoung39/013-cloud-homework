package com.example.demo.controller;

import com.example.demo.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {
    @Autowired
    private MsgService msgService;

    @GetMapping("/msg")
    public String getMsg(@RequestParam String msg){
        return msgService.getMsg(msg);
    }
}
