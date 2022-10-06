package com.avinty.hr.service;

import com.avinty.hr.entity.Department;

import java.util.List;

public interface DepartmentService {

    void deleteDepartment(Integer id);


    List<String> searchDepartment(String name);

    List<Department> getAllDepartment();
}
