package com.DepartmentAPI.DepartmentAPI.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;


public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String message) {
        super(message);
    }
}
