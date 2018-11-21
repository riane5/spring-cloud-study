package com.riane;

import com.riane.service.SendService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * 注解@EnableBinding：开启绑定的功能
 * 并且@EnableBinding 注释可以将一个或多个接口类作为参数，这些接口类包含表示可绑定组件（通常是消息通道）的方法
 * Spring Cloud Stream提供了开箱即用的三个预定义接口:
 * 1、Source(Source可用于具有单个出站通道的应用程序)，
 * 2、Sink：Sink可用于具有单个入站通道的应用程序。
 * 3、Processor：Processor可用于具有入站通道和出站通道的应用程序
 */
@SpringBootApplication
@EnableBinding(SendService.class)
public class SpcStreamRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpcStreamRabbitmqApplication.class, args);
    }
}
