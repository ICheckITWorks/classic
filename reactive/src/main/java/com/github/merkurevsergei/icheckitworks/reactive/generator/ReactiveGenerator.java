package com.github.merkurevsergei.icheckitworks.reactive.generator;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactiveGenerator {

    public List<Integer> generateInteger() {
        return List.of(2);
    }
}
