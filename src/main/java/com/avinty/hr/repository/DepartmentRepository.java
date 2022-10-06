package com.avinty.hr.repository;

import com.avinty.hr.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query(value = "select name From departments where lower(name) like lower(concat('%', ?1,'%'))", nativeQuery=true)
    List<String> searchDepartment(String name);

}