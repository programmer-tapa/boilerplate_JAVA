package com.example.server.middlewares;

import com.example.server.helpers.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RouteErrorHandlerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(RouteErrorHandlerAdvice.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex, HttpServletRequest request) {
        String routePath = request.getRequestURI();
        String errorMessage = "Error at route - " + routePath + " : " + ex.getMessage();
        logger.error(errorMessage);
        logger.error("Traceback:", ex);

        // Send a generic message for internal server error
        String genericMessage = "An unexpected error occurred on the server.";
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status("error")
                .message(genericMessage)
                .errorCode("500")
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
