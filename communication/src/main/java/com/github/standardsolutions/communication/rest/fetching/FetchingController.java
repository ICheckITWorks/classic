package com.github.standardsolutions.communication.rest.fetching;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.standardsolutions.request.FetchRequest;

@RestController
@RequestMapping(value = "/fetching")
@RequiredArgsConstructor
public class FetchingController {

    private final FlightsRepository flightsRepository;

    @PostMapping
    public Page<FlightsEntity> getVacancies(@RequestBody FetchRequest request) {
        return flightsRepository.findAll(request.toSpecification(), request.toPageable());
    }
}
