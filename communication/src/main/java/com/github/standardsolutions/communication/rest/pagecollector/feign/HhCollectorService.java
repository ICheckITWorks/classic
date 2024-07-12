package com.github.standardsolutions.communication.rest.pagecollector.feign;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class HhCollectorService {

    private final HhPageClient hhPageClient;

    public List<Map<String, Object>> getVacancies() {
        int page_count = 20;
        int per_page = 100;
        VacanciesDto data = hhPageClient.getData(Map.of("text", "java",
                                                        "per_page", String.valueOf(per_page),
                                                        "page", "0"));
        List<Map<String, Object>> items = data.items();
        List<Map<String, Object>> result = new ArrayList<>(items);
        page_count = Math.min(page_count, data.pages());
        for (int i = 1; i < page_count; i++) {
            data = hhPageClient.getData(Map.of("text", "java",
                                               "per_page", "100",
                                               "page", String.valueOf(i)));
            result.addAll(data.items());
        }
        return result;
    }
}
