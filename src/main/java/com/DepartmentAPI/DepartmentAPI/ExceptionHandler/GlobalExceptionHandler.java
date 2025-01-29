package com.DepartmentAPI.DepartmentAPI.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<?>>getNosuchExp(MethodArgumentNotValidException methodArgumentNotValidException){
        List<String> error=methodArgumentNotValidException.getBindingResult().getAllErrors().stream().map(errorLOOP->errorLOOP.getDefaultMessage()).collect(Collectors.toList());
        APIError apiError= APIError.builder().status(HttpStatus.BAD_REQUEST).message("Input Validation Failed").suberror(error).build();
        return buildAPIresponse(apiError);
    }

    private ResponseEntity<APIResponse<?>> buildAPIresponse(APIError apiError) {
        return new ResponseEntity<>(new APIResponse<>(apiError),apiError.getStatus());

    }

}
