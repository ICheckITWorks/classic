package com.github.standardsolutions.communication.rest.pagecollector.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@FeignClient(name = "hhPageClient", url = "https://api.hh.ru")
public interface HhPageClient extends PageClient<VacanciesDto> {

    @Override
    @GetMapping("/vacancies")
    VacanciesDto getData(@SpringQueryMap Map<String, String> queryMap);
}