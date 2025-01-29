package com.DepartmentAPI.DepartmentAPI.ExceptionHandler;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class APIResponse<T> {
    private T data;
    private APIError apiError;
    @JsonFormat(pattern = "hh:mm:ss dd-MM-yyyy")
    private LocalDateTime localDateTime;

    public APIResponse(T data) {
        this();
        this.data = data;
    }

    public APIResponse(APIError apiError) {
        this();
        this.apiError = apiError;

    }

    public APIResponse() {
        this.localDateTime=LocalDateTime.now();
    }
}
