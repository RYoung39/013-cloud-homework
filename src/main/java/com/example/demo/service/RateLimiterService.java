package com.example.demo.service;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Service;

@Service
public class RateLimiterService {
    RateLimiter rateLimiter=RateLimiter.create(98.0);

    public boolean tryAcquire(){
        return rateLimiter.tryAcquire();
    }
}
