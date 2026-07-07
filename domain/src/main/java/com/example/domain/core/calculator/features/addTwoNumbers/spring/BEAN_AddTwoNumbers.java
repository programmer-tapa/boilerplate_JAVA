package com.example.domain.core.calculator.features.addTwoNumbers.spring;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.domain.core.calculator.features.addTwoNumbers.interfaces.INTERFACE_HELPER_AddTwoNumbers;
import com.example.domain.core.calculator.features.addTwoNumbers.schemas.INPUT_AddTwoNumbers;
import com.example.domain.core.calculator.features.addTwoNumbers.schemas.OUTPUT_AddTwoNumbers;
import com.example.domain.core.calculator.features.addTwoNumbers.services.SERVICE_AddTwoNumbers;
import com.example.domain.origin.interfaces.INTERFACE_UsecaseAuthorizationService;
import com.example.domain.origin.spring.BEAN_Abstract;

/**
 * Spring bean for AddTwoNumbers service, provides a ready-to-use instance with
 * dependencies injected.
 */
@Service
public class BEAN_AddTwoNumbers
        extends BEAN_Abstract<INPUT_AddTwoNumbers, OUTPUT_AddTwoNumbers, SERVICE_AddTwoNumbers> {

    private final Map<String, INTERFACE_HELPER_AddTwoNumbers> helpers;

    public BEAN_AddTwoNumbers(
            INTERFACE_UsecaseAuthorizationService authorizationService,
            Map<String, INTERFACE_HELPER_AddTwoNumbers> helpers) {
        super(authorizationService);
        this.helpers = helpers;
    }

    @Override
    protected SERVICE_AddTwoNumbers createService() {
        return new SERVICE_AddTwoNumbers(dependencies, helpers);
    }
}
