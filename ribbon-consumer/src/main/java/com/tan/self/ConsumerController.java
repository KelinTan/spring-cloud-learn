package com.tan.self;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Author: Mr.tan
 * Date: 2017/9/9
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private FeignService feignService;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloConsumer(){
        return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
    }

    @RequestMapping(value = "/ribbon-consumer-test", method = RequestMethod.GET)
    public String helloNoHystrixConsumer(){
        return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
    }

    @RequestMapping(value = "/feign", method = RequestMethod.GET)
    public String feignConsumer(){
        return feignService.sayHiFromClientOne();
    }


    public String helloFallback() {
        return "hello world fallback";
    }
}
