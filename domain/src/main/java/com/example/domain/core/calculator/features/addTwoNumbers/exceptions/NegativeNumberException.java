package com.example.domain.core.calculator.features.addTwoNumbers.exceptions;

import com.example.domain.origin.exceptions.AppException;
import com.example.domain.origin.schemas.ServiceStatus;

public class NegativeNumberException extends AppException {
    public NegativeNumberException(int number) {
        super(ServiceStatus.VALIDATION_ERROR, "Number cannot be negative: " + number);
    }
}
