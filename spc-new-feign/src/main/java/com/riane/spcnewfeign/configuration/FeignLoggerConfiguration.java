package com.riane.spcnewfeign.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignLoggerConfiguration {

    /**
     * feign客户端默认的日志级别是NONE，改级别不会记录任何日志过程，所以我们需要全局设置日志级别。
     *
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }


}
