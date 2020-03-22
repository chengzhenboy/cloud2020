package com.atzhenhome.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author:Chengzhen
 * @date:2020/3/21
 * @ver:1.0
 **/
@Configuration
public class ApplicationContextConfig
{
    @Bean
    @LoadBalanced // 注解开启RestTemplate负载均衡功能
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
