package com.example.worker;

import com.example.domain.SharedService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class WorkerTask {

    private final SharedService sharedService;

    public WorkerTask(SharedService sharedService) {
        this.sharedService = sharedService;
    }

    @Scheduled(fixedRate = 5000)
    public void executeTask() {
        System.out.println("Worker executing at " + LocalDateTime.now() + ". " + sharedService.getSharedMessage());
    }
}
