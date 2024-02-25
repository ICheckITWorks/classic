package com.github.merkurevsergei.icheckitworks.reactive.generator;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SyncFileReader {
    public static byte[] readFile(String filePath) throws Exception {
        URI uri = ClassLoader.getSystemResource(filePath).toURI();
        Path path = Paths.get(uri);
        return Files.readAllBytes(path);
    }

    public static void main(String[] args) {
        List<String> filePaths = List.of("data/file1", "data/file2", "data/file3");

        long startTime = System.currentTimeMillis();

        filePaths.forEach(filePath -> {
            try {
                readFile(filePath);
                // Здесь может быть обработка содержимого
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        long endTime = System.currentTimeMillis();
        System.out.println("sync read finished " + (endTime - startTime) + " ms");
    }
}
