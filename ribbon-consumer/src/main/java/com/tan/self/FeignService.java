package com.tan.self;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Author: Mr.tan
 * Date: 2017/9/9
 */

@FeignClient(value = "hello-service",fallback = SchedualServiceHiHystric.class)
public interface FeignService {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String sayHiFromClientOne();
}
