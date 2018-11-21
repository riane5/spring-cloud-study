package com.riane.spceurekacaller.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.riane.spceurekacaller.rule.MyRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@RibbonClients
//@RibbonClient
public class MyRibbonConfig {

    @Bean
    public IRule rule() {
        //return new RandomRule();
        return new MyRule();
    }

}
