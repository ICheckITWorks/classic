package com.github.standardsolutions.communication.rest.pagecollector;

import com.github.standardsolutions.communication.rest.pagecollector.feign.HhCollectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/page-collector")
@RequiredArgsConstructor
public class PageCollectorController {

    private final HhCollectorService hhCollectorService;

    @GetMapping(value = "/open-feign")
    public List<Map<String, Object>> getVacancies() {
        return hhCollectorService.getVacancies();
    }

}
