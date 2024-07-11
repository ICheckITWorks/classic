package com.github.standardsolutions.communication.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.github.standardsolutions.communication.rest.pagecollector.feign")
public class OpenFeignConfig {
}
