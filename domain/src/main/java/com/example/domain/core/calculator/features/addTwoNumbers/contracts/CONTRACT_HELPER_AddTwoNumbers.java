package com.example.domain.core.calculator.features.addTwoNumbers.contracts;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import com.example.domain.core.calculator.features.addTwoNumbers.interfaces.INTERFACE_HELPER_AddTwoNumbers;
import com.example.domain.infra.logger.interfaces.LoggerService;

@Component
@RequiredArgsConstructor
public class CONTRACT_HELPER_AddTwoNumbers implements INTERFACE_HELPER_AddTwoNumbers {

    private final LoggerService loggerService;

    @Override
    public void printHello() {
        System.out.println("Hello from CONTRACT_HELPER_AddTwoNumbers!");
        loggerService.info("Executed printHello in CONTRACT_HELPER_AddTwoNumbers");
        loggerService.debug("Debug: printHello method was called.");
        loggerService.warn("Warning: This is just a demo log from printHello.");
        loggerService.error("Info: printHello execution completed.");
        loggerService.critical("some critical message");
    }

}
