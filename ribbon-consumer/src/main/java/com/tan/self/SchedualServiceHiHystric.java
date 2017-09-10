package com.tan.self;

import org.springframework.stereotype.Component;

/**
 * feign断路回调,需要实现feignService
 *
 * Author: Mr.tan
 * Date: 2017/9/9
 */
@Component
public class SchedualServiceHiHystric implements FeignService {

    @Override
    public String sayHiFromClientOne() {
        return "sorry ";
    }
}
