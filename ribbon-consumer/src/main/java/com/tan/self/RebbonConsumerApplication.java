package com.tan.self;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Author: Mr.tan
 * Date: 2017/9/9
 */
@EnableDiscoveryClient  // 获得服务发现能力
@SpringBootApplication
@EnableCircuitBreaker //配置断路器
@EnableFeignClients // feign注解:feign默认集成了ribbon，以注解的形式调用服务
@EnableHystrixDashboard
public class RebbonConsumerApplication {

    @Bean
    @LoadBalanced         // 开启负载均衡
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RebbonConsumerApplication.class, args);
    }
}
