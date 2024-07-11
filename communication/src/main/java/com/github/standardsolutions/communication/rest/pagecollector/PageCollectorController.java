package com.github.standardsolutions.communication.rest.pagecollector;

import com.github.standardsolutions.communication.rest.pagecollector.feign.HhCollectorService;
import com.github.standardsolutions.communication.rest.pagecollector.feign.VacanciesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/page-collector")
@RequiredArgsConstructor
public class PageCollectorController {

    private final HhCollectorService hhCollectorService;

    @GetMapping(value = "/open-feign")
    public VacanciesDto getVacancies() {
        return hhCollectorService.getVacancies();
    }

}
