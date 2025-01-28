package com.DepartmentAPI.DepartmentAPI.Controllers;

import com.DepartmentAPI.DepartmentAPI.DTO.DepartmentDTO;
import com.DepartmentAPI.DepartmentAPI.Service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>>getAllDept(){
        return  ResponseEntity.ok(departmentService.getAllDept());
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO>createDept(@RequestBody @Valid DepartmentDTO departmentDTO){
        DepartmentDTO departmentcreate=departmentService.createDept(departmentDTO);
        return  new ResponseEntity<>(departmentcreate, HttpStatus.CREATED);
    }




}
