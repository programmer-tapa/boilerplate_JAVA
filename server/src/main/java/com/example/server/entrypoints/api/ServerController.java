package com.example.server.entrypoints.api;

import com.example.domain.SharedService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    private final SharedService sharedService;

    public ServerController(SharedService sharedService) {
        this.sharedService = sharedService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "API says: " + sharedService.getSharedMessage();
    }
}
