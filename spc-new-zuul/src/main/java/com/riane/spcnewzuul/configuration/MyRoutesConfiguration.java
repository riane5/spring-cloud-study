package com.riane.spcnewzuul.configuration;

import com.netflix.zuul.FilterProcessor;
import com.riane.spcnewzuul.process.MyFilterProcess;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRoutesConfiguration {

    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>.+$)", "${version}/${name}");
    }


    @Bean
    public MyFilterProcess myFilterProcess() {
        MyFilterProcess filterProcess = new MyFilterProcess();
        FilterProcessor.setProcessor(filterProcess);
        return filterProcess;
    }
}
