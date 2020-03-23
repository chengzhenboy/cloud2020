package com.atzhenhome.myrule;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义策略
 * 
 * @author:Chengzhen
 * @date:2020/3/23
 * @ver:1.0
 **/
// 因为为了自己所写的规则不被使用rubbon共享，所以不能放到ComponentScan能够扫描到的目录下面
@Configuration
public class MySelfRule
{
    @Bean
    public IRule myRule()
    {
        // 定义为随机
        return new RandomRule();
        // return new RoundRobinRule(); // 轮询策略,默认
        // return new RetryRule(); //重试策略
        // return new BestAvailableRule();//最低并发策略
        // return new AvailabilityFilteringRule();//可用过滤策略
        // return new ResponseTimeWeightedRule(); //响应时间加权重策略
        // return new ZoneAvoidanceRule();//区域权重策略
    }
}
