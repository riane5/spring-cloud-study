package com.riane.spcstreamrabbitmqnew.reviever;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

import java.io.UnsupportedEncodingException;

@EnableBinding(Sink.class)
public class SinkReciever {


    @StreamListener(Sink.INPUT)
    public void recieve(byte[] payload) {
        try {
            System.out.println(new String(payload, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
