package com.DepartmentAPI.DepartmentAPI.Repositry;

import com.DepartmentAPI.DepartmentAPI.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<DepartmentEntity,Long> {

}
