package com.example.domain.core.calculator.features.divideTwoNumbers.usecases;

import com.example.domain.core.calculator.features.divideTwoNumbers.exceptions.DivisionByZeroException;
import com.example.domain.core.calculator.features.divideTwoNumbers.interfaces.INTERFACE_HELPER_DivideTwoNumbers;
import com.example.domain.core.calculator.features.divideTwoNumbers.schemas.INPUT_DivideTwoNumbers;
import com.example.domain.core.calculator.features.divideTwoNumbers.schemas.OUTPUT_DivideTwoNumbers;
import com.example.domain.origin.entities.USECASE_Abstract;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class USECASE_DivideTwoNumbers extends USECASE_Abstract<INPUT_DivideTwoNumbers, OUTPUT_DivideTwoNumbers> {

    private final INTERFACE_HELPER_DivideTwoNumbers helper;

    @Override
    public OUTPUT_DivideTwoNumbers execute(INPUT_DivideTwoNumbers input) {
        if (input.b() == 0) {
            throw new DivisionByZeroException();
        }
        double result = input.a() / input.b();
        helper.logDivision(input.a(), input.b(), result);
        return new OUTPUT_DivideTwoNumbers(result);
    }
}
