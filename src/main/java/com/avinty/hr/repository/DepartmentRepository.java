package com.avinty.hr.repository;

import com.avinty.hr.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query(value = "select * From departments where name like %?1%", nativeQuery=true)
    List<Department> searchDepartment(String name);

}