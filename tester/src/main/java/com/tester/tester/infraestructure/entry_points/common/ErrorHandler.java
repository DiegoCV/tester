package com.tester.tester.infraestructure.entry_points.common;

import com.tester.tester.domain.model.common.ExamenException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(ExamenException.class)
    public ResponseEntity<ErrorInfo> examenException(HttpServletRequest request, ExamenException e) {
        ErrorInfo errorInfo = new ErrorInfo(e.getMessage());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }
}
