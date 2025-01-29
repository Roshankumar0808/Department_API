package com.DepartmentAPI.DepartmentAPI.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private Long id;
    @NotBlank(message = "Title is required")
    @Size(min=2, max=15,message = "Title length should be between 2-15")
    private String title;
    @NotBlank(message = "Desc is required")
    private String desc;
    @NotNull
    @Positive
    @Digits(integer = 5,fraction = 2)
    @DecimalMax("99999.99")
    @DecimalMin("99.99")
    private Double salary;
    @NotBlank(message = "Email can not be blank")
    @Email
    private String email;
    @JsonProperty("isActive")
    private Boolean isActive;
}
