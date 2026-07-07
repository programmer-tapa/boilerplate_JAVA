package com.example.domain.core.calculator.features.addTwoNumbers.usecases;

import lombok.AllArgsConstructor;

import com.example.domain.core.calculator.features.addTwoNumbers.exceptions.NegativeNumberException;
import com.example.domain.core.calculator.features.addTwoNumbers.interfaces.INTERFACE_HELPER_AddTwoNumbers;
import com.example.domain.core.calculator.features.addTwoNumbers.schemas.INPUT_AddTwoNumbers;
import com.example.domain.core.calculator.features.addTwoNumbers.schemas.OUTPUT_AddTwoNumbers;
import com.example.domain.origin.entities.USECASE_Abstract;

@AllArgsConstructor
public class USECASE_AddTwoNumbers extends USECASE_Abstract<INPUT_AddTwoNumbers, OUTPUT_AddTwoNumbers> {

    private final INTERFACE_HELPER_AddTwoNumbers helper;

    @Override
    public OUTPUT_AddTwoNumbers execute(INPUT_AddTwoNumbers input) {
        if (input.a() < 0) {
            throw new NegativeNumberException(input.a());
        }
        if (input.b() < 0) {
            throw new NegativeNumberException(input.b());
        }
        int result = input.a() + input.b();
        helper.printHello();
        return new OUTPUT_AddTwoNumbers(result);
    }

}
