package com.example.domain.core.calculator.features.divideTwoNumbers.spring;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.domain.core.calculator.features.divideTwoNumbers.interfaces.INTERFACE_HELPER_DivideTwoNumbers;
import com.example.domain.core.calculator.features.divideTwoNumbers.schemas.INPUT_DivideTwoNumbers;
import com.example.domain.core.calculator.features.divideTwoNumbers.schemas.OUTPUT_DivideTwoNumbers;
import com.example.domain.core.calculator.features.divideTwoNumbers.services.SERVICE_DivideTwoNumbers;
import com.example.domain.origin.interfaces.INTERFACE_UsecaseAuthorizationService;
import com.example.domain.origin.spring.BEAN_Abstract;

@Service
public class BEAN_DivideTwoNumbers
        extends BEAN_Abstract<INPUT_DivideTwoNumbers, OUTPUT_DivideTwoNumbers, SERVICE_DivideTwoNumbers> {

    private final Map<String, INTERFACE_HELPER_DivideTwoNumbers> helpers;

    public BEAN_DivideTwoNumbers(
            INTERFACE_UsecaseAuthorizationService authorizationService,
            Map<String, INTERFACE_HELPER_DivideTwoNumbers> helpers) {
        super(authorizationService);
        this.helpers = helpers;
    }

    @Override
    protected SERVICE_DivideTwoNumbers createService() {
        return new SERVICE_DivideTwoNumbers(dependencies, helpers);
    }
}
