package com.github.merkurevsergei.icheckitworks.reactive.generator;

import lombok.SneakyThrows;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AsyncFileReader {
    @SneakyThrows
    public static void readFile(String filePath) {
        URI uri = ClassLoader.getSystemResource(filePath).toURI();
        Path path = Paths.get(uri);
        Files.readAllBytes(path);
    }

    public static void main(String[] args) {
        List<String> filePaths = List.of("data/file1", "data/file2", "data/file3");

        long startTime = System.currentTimeMillis();

        Mono<Void> mono1 = Mono.fromRunnable(() -> readFile(filePaths.get(0))).subscribeOn(Schedulers.boundedElastic()).then();
        Mono<Void> mono2 = Mono.fromRunnable(() -> readFile(filePaths.get(1))).subscribeOn(Schedulers.boundedElastic()).then();
        Mono<Void> mono3 = Mono.fromRunnable(() -> readFile(filePaths.get(2))).subscribeOn(Schedulers.boundedElastic()).then();
        Mono.zip(mono1, mono2, mono3)
                .doOnTerminate(() -> {
                    long endTime = System.currentTimeMillis();
                    System.out.println("async read finished " + (endTime - startTime) + " ms");
                })
                .subscribe();

        // Для демонстрации добавим задержку, чтобы асинхронные операции могли завершиться
        try {
            Thread.sleep(5000); // Увеличьте, если файлы большие
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}
