package com.medhan.spring.redis.messagebroker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * Created by mhan on 4/7/16.
 */
public class Hotspot {

    private static final Logger LOGGER =LoggerFactory.getLogger(Hotspot.class);

    private CountDownLatch latch;

    @Autowired
    public Hotspot(CountDownLatch latch){
        this.latch = latch;
    }

    public void receiveMessage(String message){
        LOGGER.info("Receiving <== "+ message);
    latch.countDown();
    }
}
