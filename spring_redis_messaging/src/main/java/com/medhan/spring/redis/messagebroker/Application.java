package com.medhan.spring.redis.messagebroker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

/**
 * Created by mhan on 4/7/16.
 */
@SpringBootApplication
public class Application {

    private static  final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("3ijja"));

        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Hotspot hotspot){
        return new MessageListenerAdapter(hotspot, "receiveMessage");
    }

    @Bean
    Hotspot hotspot(CountDownLatch latch){
        return new Hotspot(latch);
    }

    @Bean
    CountDownLatch latch(){
        return new CountDownLatch(1);
    }

    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory){
        return new StringRedisTemplate(connectionFactory);
    }

    public static void main(String[] args) throws InterruptedException{
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
        CountDownLatch latch = ctx.getBean(CountDownLatch.class);

        LOGGER.info("I ma sending you the  message houhaaaaaa3...");
        template.convertAndSend("3ijja", "Hello from eagle to the swan ! do you copy ??!");

        latch.await();
        System.exit(0);
    }
}
