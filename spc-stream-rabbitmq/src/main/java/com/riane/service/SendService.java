package com.riane.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface SendService {

    /**
     * 调用该方法，会向testInput这个通道投放消息
     * 注解@Output: 创建一个声明的(testInput)消息通道，若该注解不提供value值，则默认是方法名为参数值
     * 输入和输出通道为@Input和@Output方法：
     *
     * @return
     */
    @Output("testInput")
    SubscribableChannel sendOrder();
}
