package com.github.standardsolutions.communication.rest.pagecollector.feign;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class HhCollectorService {

    private final HhPageClient hhPageClient;

    public VacanciesDto getVacancies() {
        return hhPageClient.getData(Map.of("text", "java",
                                           "per_page", "100",
                                           "page", "1"));
    }
}
