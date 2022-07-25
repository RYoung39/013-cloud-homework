package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MsgService {
    public String getMsg(String msg){
        System.out.println(msg);
        return msg;
    }
}
