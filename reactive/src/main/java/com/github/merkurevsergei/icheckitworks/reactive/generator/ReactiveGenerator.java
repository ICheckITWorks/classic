package com.github.merkurevsergei.icheckitworks.reactive.generator;

import java.util.Random;

public class ReactiveGenerator {

    private final Random random = new Random();

    public void randomGetAndPrintS(Integer count, String s) {
        System.out.println(s);
        for (int i = 0; i < count; i++) {
            random.nextInt();
        }
        System.out.println(s + " complete");
    }
}
