package com.github.standardsolutions.redis.controller;

import com.github.standardsolutions.redis.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
@RequiredArgsConstructor
public class RedisController {

    private final RedisService service;

    @PostMapping
    public void set() {
        service.set();
    }

    @GetMapping
    public String get() {
        return service.get();
    }
}

