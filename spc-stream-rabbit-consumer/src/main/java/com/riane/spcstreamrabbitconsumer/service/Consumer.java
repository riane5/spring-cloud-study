package com.riane.spcstreamrabbitconsumer.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Consumer {

    @Input("testInput")
    SubscribableChannel myInput();
}
