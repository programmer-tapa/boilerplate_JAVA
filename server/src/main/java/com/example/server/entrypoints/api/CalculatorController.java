package com.example.server.entrypoints.api;

import com.example.domain.core.calculator.features.addTwoNumbers.schemas.INPUT_AddTwoNumbers;
import com.example.domain.core.calculator.features.addTwoNumbers.schemas.OUTPUT_AddTwoNumbers;
import com.example.domain.core.calculator.features.addTwoNumbers.spring.BEAN_AddTwoNumbers;
import com.example.domain.core.calculator.features.divideTwoNumbers.schemas.INPUT_DivideTwoNumbers;
import com.example.domain.core.calculator.features.divideTwoNumbers.schemas.OUTPUT_DivideTwoNumbers;
import com.example.domain.core.calculator.features.divideTwoNumbers.spring.BEAN_DivideTwoNumbers;
import com.example.domain.origin.schemas.ServiceOutput;
import com.example.domain.origin.schemas.User;
import com.example.server.helpers.ApiResponse;
import com.example.server.helpers.ControllerServiceExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final ControllerServiceExecutor executor;
    private final BEAN_AddTwoNumbers beanAddTwoNumbers;
    private final BEAN_DivideTwoNumbers beanDivideTwoNumbers;

    public CalculatorController(
            ControllerServiceExecutor executor,
            BEAN_AddTwoNumbers beanAddTwoNumbers,
            BEAN_DivideTwoNumbers beanDivideTwoNumbers) {
        this.executor = executor;
        this.beanAddTwoNumbers = beanAddTwoNumbers;
        this.beanDivideTwoNumbers = beanDivideTwoNumbers;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<OUTPUT_AddTwoNumbers>> add(@RequestBody INPUT_AddTwoNumbers input) {
        User user = new User("user-123", "cosmos@example.com", "USER");
        ResponseEntity<ServiceOutput<OUTPUT_AddTwoNumbers>> serviceResult = executor.execute(
                beanAddTwoNumbers.getService()::run,
                input,
                user);
        return handleServiceOutput(serviceResult, "Addition failed");
    }

    @PostMapping("/divide")
    public ResponseEntity<ApiResponse<OUTPUT_DivideTwoNumbers>> divide(@RequestBody INPUT_DivideTwoNumbers input) {
        User user = new User("user-123", "cosmos@example.com", "USER");
        ResponseEntity<ServiceOutput<OUTPUT_DivideTwoNumbers>> serviceResult = executor.execute(
                beanDivideTwoNumbers.getService()::run,
                input,
                user);
        return handleServiceOutput(serviceResult, "Division failed");
    }

    private <O> ResponseEntity<ApiResponse<O>> handleServiceOutput(
            ResponseEntity<ServiceOutput<O>> serviceResult,
            String defaultErrorMsg) {

        ServiceOutput<O> output = serviceResult.getBody();
        HttpStatus httpStatus = (HttpStatus) serviceResult.getStatusCode();

        if (output == null || httpStatus.isError()) {
            String message = defaultErrorMsg;
            String errorCode = String.valueOf(httpStatus.value());

            if (output != null && output.errorMessage() != null) {
                message = output.errorMessage();
            }

            if (httpStatus == HttpStatus.INTERNAL_SERVER_ERROR) {
                message = "An unexpected error occurred on the server.";
            }

            ApiResponse<O> errorResponse = ApiResponse.<O>builder()
                    .status("error")
                    .message(message)
                    .errorCode(errorCode)
                    .build();
            return new ResponseEntity<>(errorResponse, httpStatus);
        }

        ApiResponse<O> successResponse = ApiResponse.<O>builder()
                .status("success")
                .data(output.data())
                .build();
        return new ResponseEntity<>(successResponse, httpStatus);
    }
}
