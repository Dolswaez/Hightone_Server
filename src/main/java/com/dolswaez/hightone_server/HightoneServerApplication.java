package com.dolswaez.hightone_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class HightoneServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HightoneServerApplication.class, args);
    }

}
