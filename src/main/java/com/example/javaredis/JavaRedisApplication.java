package com.example.javaredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class JavaRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaRedisApplication.class, args);
    }

}
