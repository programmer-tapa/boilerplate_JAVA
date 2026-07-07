package com.example.domain.core.calculator.features.divideTwoNumbers.services;

import java.util.Map;

import com.example.domain.core.calculator.features.divideTwoNumbers.interfaces.INTERFACE_HELPER_DivideTwoNumbers;
import com.example.domain.core.calculator.features.divideTwoNumbers.schemas.INPUT_DivideTwoNumbers;
import com.example.domain.core.calculator.features.divideTwoNumbers.schemas.OUTPUT_DivideTwoNumbers;
import com.example.domain.core.calculator.features.divideTwoNumbers.usecases.USECASE_DivideTwoNumbers;
import com.example.domain.origin.entities.SERVICE_Abstract;
import com.example.domain.origin.entities.USECASE_Abstract;
import com.example.domain.origin.schemas.ServiceDependency;

public class SERVICE_DivideTwoNumbers extends SERVICE_Abstract<INPUT_DivideTwoNumbers, OUTPUT_DivideTwoNumbers> {

    private static final String SERVICE_NAME = "Calculator.DivideTwoNumbers";
    private final Map<String, INTERFACE_HELPER_DivideTwoNumbers> helpers;

    public SERVICE_DivideTwoNumbers(ServiceDependency dependencies,
            Map<String, INTERFACE_HELPER_DivideTwoNumbers> helpers) {
        super(dependencies);
        this.helpers = helpers;
    }

    @Override
    protected String detectServiceName() {
        return SERVICE_NAME;
    }

    @Override
    protected USECASE_Abstract<INPUT_DivideTwoNumbers, OUTPUT_DivideTwoNumbers> build(INPUT_DivideTwoNumbers input) {
        String helperKey = "CONTRACT_HELPER_DivideTwoNumbers";
        INTERFACE_HELPER_DivideTwoNumbers usecaseHelper = helpers.get(helperKey);

        if (usecaseHelper == null) {
            throw new RuntimeException("Helper not found: " + helperKey);
        }

        return new USECASE_DivideTwoNumbers(usecaseHelper);
    }
}
