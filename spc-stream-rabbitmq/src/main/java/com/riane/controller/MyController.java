package com.riane.controller;

import com.riane.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private SendService sendService;

    @GetMapping("/send")
    public String sendRequest() {
        Message<byte[]> message = MessageBuilder.withPayload("hello".getBytes()).build();
        boolean send = sendService.sendOrder().send(message);
        if (send) {
            return "success";
        } else {
            return "failed";
        }
    }
}
