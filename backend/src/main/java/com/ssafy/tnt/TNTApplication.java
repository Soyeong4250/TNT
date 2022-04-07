package com.ssafy.tnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TNTApplication {

    public static void main(String[] args) {
        SpringApplication.run(TNTApplication.class, args);
    }

}
