package com.github.merkurevsergei.icheckitworks.reactive.generator;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        checkClassic();
//        checkReactive();
    }

    private static void checkClassic() {
        ReactiveGenerator reactiveGenerator = new ReactiveGenerator();
        long startTime = System.nanoTime();

        reactiveGenerator.randomGetAndPrintS(2_000_000_000, "1");
        reactiveGenerator.randomGetAndPrintS(2_000_000_000, "2");
        reactiveGenerator.randomGetAndPrintS(2_000_000_000, "3");
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("Classic time: " + totalTime / 1_000_000);
    }

    private static void checkReactive() {
        long startTime = System.nanoTime();
        ReactiveGenerator reactiveGenerator = new ReactiveGenerator();

        Mono<Void> mono1 = Mono.fromRunnable(() -> reactiveGenerator.randomGetAndPrintS(2_000_000_000, "1"))
                .subscribeOn(Schedulers.boundedElastic()).then();
        Mono<Void> mono2 = Mono.fromRunnable(() -> reactiveGenerator.randomGetAndPrintS(2_000_000_000, "2"))
                .subscribeOn(Schedulers.boundedElastic()).then();
        Mono<Void> mono3 = Mono.fromRunnable(() -> reactiveGenerator.randomGetAndPrintS(2_000_000_000, "3"))
                .subscribeOn(Schedulers.boundedElastic()).then();
        Mono.zip(mono1, mono2, mono3)
                .doOnTerminate(() -> {
                    long endTime = System.nanoTime();
                    long totalTime = endTime - startTime;
                    System.out.println("Reactive time: " + totalTime / 1_000_000);
                })
                .subscribe();
        // Предотвращение завершения программы слишком рано
        try {
            TimeUnit.SECONDS.sleep(180); // Дайте достаточно времени для завершения асинхронных задач
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
