package com.example.domain;

import org.springframework.stereotype.Service;

@Service
public class SharedService {
    
    public String getSharedMessage() {
        return "Hello from the Shared Module!";
    }
}
