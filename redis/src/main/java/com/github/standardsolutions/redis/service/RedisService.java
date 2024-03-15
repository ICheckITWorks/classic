package com.github.standardsolutions.redis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisService {

    private final StringRedisTemplate redisTemplate;

    public void set() {
        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
        valueOps.set("Hi", "Redis");

    }

    @Cacheable(value = "set2")
    public String get() {
        return "set2_to_key";
    }
}
