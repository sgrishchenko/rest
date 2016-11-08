package com.example.simple;

import com.example.model.ModelApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Object[]{ModelApplication.class, SimpleApplication.class}, args);
    }
}
