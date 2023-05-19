package com.gx.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GxSessionClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(GxSessionClientApplication.class, args);
        System.out.println("welcome to grpc Client");
    }
}
