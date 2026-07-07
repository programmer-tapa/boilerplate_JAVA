package com.example.domain.core.calculator.features.divideTwoNumbers.contracts;

import org.springframework.stereotype.Component;

import com.example.domain.core.calculator.features.divideTwoNumbers.interfaces.INTERFACE_HELPER_DivideTwoNumbers;

@Component
public class CONTRACT_HELPER_DivideTwoNumbers implements INTERFACE_HELPER_DivideTwoNumbers {

    @Override
    public void logDivision(double a, double b, double result) {
        System.out.println("Logging division: " + a + " / " + b + " = " + result);
        // Here you could use jdbcTemplate to save to DB if needed
    }
}
