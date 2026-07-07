package com.example.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.worker", "com.example.domain"})
@EnableScheduling
public class WorkerApplication {

    public static void main(String[] args) {
        System.out.println("Starting Worker Application...");
        SpringApplication.run(WorkerApplication.class, args);
    }
}
