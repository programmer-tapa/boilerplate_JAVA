package com.example.domain.core.calculator.features.divideTwoNumbers.exceptions;

import com.example.domain.origin.exceptions.AppException;
import com.example.domain.origin.schemas.ServiceStatus;

public class DivisionByZeroException extends AppException {
    public DivisionByZeroException() {
        super(ServiceStatus.VALIDATION_ERROR, "Division by zero is not allowed");
    }
}
