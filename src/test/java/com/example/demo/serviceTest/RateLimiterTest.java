package com.example.demo.serviceTest;

import com.example.demo.service.RateLimiterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RateLimiterTest {
    @Autowired
    RateLimiterService rateLimiterService;

    @Test
    public void test(){
        for(int i=0;i<10;i++){
            System.out.println(rateLimiterService.tryAcquire());
        }
    }

}
