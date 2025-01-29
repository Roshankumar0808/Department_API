package com.DepartmentAPI.DepartmentAPI.Service;

import com.DepartmentAPI.DepartmentAPI.DTO.DepartmentDTO;
import com.DepartmentAPI.DepartmentAPI.Entity.DepartmentEntity;
import com.DepartmentAPI.DepartmentAPI.Exception.ResourceNotFound;
import com.DepartmentAPI.DepartmentAPI.Repositry.DepartmentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentRepo departmentRepo;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepo departmentRepo, ModelMapper modelMapper) {
        this.departmentRepo = departmentRepo;
        this.modelMapper = modelMapper;
    }


    public void isExist(Long DepartmentId){
         boolean departmentEntity=departmentRepo.existsById(DepartmentId);
         if(!departmentEntity){
             throw new ResourceNotFound("Given Department Id: "+DepartmentId+" does not exist");
         }
    }

    public List<DepartmentDTO> getAllDept() {
     List< DepartmentEntity> departmentEntities =departmentRepo.findAll();
     return departmentEntities.stream().map(departmentEntity -> modelMapper.map(departmentEntity,DepartmentDTO.class)).collect(Collectors.toList());
    }

    public DepartmentDTO createDept(DepartmentDTO depcreate){
        DepartmentEntity departmentEntity=modelMapper.map(depcreate, DepartmentEntity.class);
        DepartmentEntity depsave=departmentRepo.save(departmentEntity);
        return modelMapper.map(depsave, DepartmentDTO.class);
    }

    public DepartmentDTO updateDept(DepartmentDTO depcreate,Long DepartmentId){
        isExist(DepartmentId);
        DepartmentEntity departmentEntity=modelMapper.map(depcreate, DepartmentEntity.class);
        departmentEntity.setId(DepartmentId);
        DepartmentEntity depsave=departmentRepo.save(departmentEntity);
        return modelMapper.map(depsave, DepartmentDTO.class);
    }

    public Boolean deleteDept(Long DepartmentId){
        isExist(DepartmentId);
        departmentRepo.deleteById(DepartmentId);
        return true;

    }
}
