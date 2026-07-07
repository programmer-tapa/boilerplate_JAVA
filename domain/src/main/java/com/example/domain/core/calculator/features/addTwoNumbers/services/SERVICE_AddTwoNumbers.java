package com.example.domain.core.calculator.features.addTwoNumbers.services;

import java.util.Map;

import com.example.domain.core.calculator.features.addTwoNumbers.interfaces.INTERFACE_HELPER_AddTwoNumbers;
import com.example.domain.core.calculator.features.addTwoNumbers.schemas.INPUT_AddTwoNumbers;
import com.example.domain.core.calculator.features.addTwoNumbers.schemas.OUTPUT_AddTwoNumbers;
import com.example.domain.core.calculator.features.addTwoNumbers.usecases.USECASE_AddTwoNumbers;
import com.example.domain.origin.entities.SERVICE_Abstract;
import com.example.domain.origin.entities.USECASE_Abstract;
import com.example.domain.origin.schemas.ServiceDependency;

public class SERVICE_AddTwoNumbers extends SERVICE_Abstract<INPUT_AddTwoNumbers, OUTPUT_AddTwoNumbers> {

    private static final String SERVICE_NAME = "Calculator.AddTwoNumbers";
    private final Map<String, INTERFACE_HELPER_AddTwoNumbers> helpers;

    public SERVICE_AddTwoNumbers(ServiceDependency dependencies, Map<String, INTERFACE_HELPER_AddTwoNumbers> helpers) {
        super(dependencies);
        this.helpers = helpers;
    }

    @Override
    protected String detectServiceName() {
        return SERVICE_NAME;
    }

    @Override
    protected USECASE_Abstract<INPUT_AddTwoNumbers, OUTPUT_AddTwoNumbers> build(INPUT_AddTwoNumbers input) {
        String helperKey = "CONTRACT_HELPER_AddTwoNumbers";
        INTERFACE_HELPER_AddTwoNumbers usecaseHelper = helpers.get(helperKey);

        if (usecaseHelper == null) {
            throw new RuntimeException("Helper not found: " + helperKey);
        }

        return new USECASE_AddTwoNumbers(usecaseHelper);
    }

}
