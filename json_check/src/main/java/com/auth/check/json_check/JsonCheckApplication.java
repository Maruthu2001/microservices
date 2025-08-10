package com.auth.check.json_check;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class JsonCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonCheckApplication.class, args);
    }

}
