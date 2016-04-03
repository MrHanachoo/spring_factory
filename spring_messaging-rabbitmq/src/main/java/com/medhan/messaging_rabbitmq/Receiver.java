package com.medhan.messaging_rabbitmq;

import java.util.concurrent.CountDownLatch;

/**
 * Created by mhan on 4/1/16.
 */
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message){
        System.out.println("Received <"+ message+ ">");
        latch.countDown();
    }

    public CountDownLatch getLatch(){
        return latch;
    }
}
