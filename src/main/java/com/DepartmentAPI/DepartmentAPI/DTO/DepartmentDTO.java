package com.DepartmentAPI.DepartmentAPI.DTO;

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
    private String title;
    private String desc;
    private Double salary;
    private String email;
    private Boolean isActive;
}
