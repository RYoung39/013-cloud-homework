package com.example.demo.controller;

import com.example.demo.service.MsgService;
import com.example.demo.service.RateLimiterService;
import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {
    @Autowired
    private MsgService msgService;
    @Autowired
    private RateLimiterService rateLimiterService;

    @Timed(value = "msg_request_duration", description = "Time taken to return msg", histogram = true)
    @GetMapping("/msg")
    public ResponseEntity getMsg(@RequestParam String msg){
        if(rateLimiterService.tryAcquire()){
            System.out.println(ResponseEntity.status(200).body(msgService.getMsg(msg)));
            return ResponseEntity.status(200).body(msgService.getMsg(msg));
        }
        else {
            return ResponseEntity.status(429).body("To many Requests");
        }
    }

}
