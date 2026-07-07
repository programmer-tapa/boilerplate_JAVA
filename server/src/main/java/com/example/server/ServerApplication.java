package com.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.server", "com.example.domain", "org.forge.mainstay"})
public class ServerApplication {

    public static void main(String[] args) {
        System.out.println("Starting Server Application...");
        SpringApplication.run(ServerApplication.class, args);
    }
}
