package com.github.standardsolutions.communication.rest.pagecollector.feign;

import org.springframework.cloud.openfeign.SpringQueryMap;

import java.util.List;
import java.util.Map;

public interface PageClient<P> {
    P getData(@SpringQueryMap Map<String, String> queryMap);
}
