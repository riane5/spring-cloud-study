package com.riane.spczuul.configuration;

import com.riane.spczuul.filter.MyRestTemplateFilter;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FilterConfiguration {

    @Bean
    public MyRestTemplateFilter myRestTemplateFilter(RestTemplate restTemplate) {
        return new MyRestTemplateFilter(restTemplate);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    /**
     * 自定义路由规则:通过正则表达式来定义服务与路由的映射规则
     * 会将所有的以<clientName微服务名>-<版本号>的微服务映射路径为/版本号/微服务名
     *
     * @return
     */
    public PatternServiceRouteMapper serviceRouteMapper() {
        /**
         * 第一个参事是检查微服务名称是否符合规范的正则表达式
         * 第二个参数是定义根据微服务名来生成的路由表达式规则
         */
        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "$<version>/$<name>");
    }
}
