package com.riane.spcstreamrabbitconsumer.consumer;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class MyConsumer {

    @StreamListener("testInput")
    public void recieve(byte[] message) {
        try {
            String messages = new String(message, "utf-8");
            System.out.println("recieve message from testInput " + messages);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
