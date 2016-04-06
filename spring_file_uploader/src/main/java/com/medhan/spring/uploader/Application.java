package com.medhan.spring.uploader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;

/**
 * Created by mhan on 4/6/16.
 */
@SpringBootApplication
public class Application {

    public static String ROOT = "upload-dir";

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(){
        return (String[] args) -> {
            new File(ROOT).mkdir();
        };
    }
}
