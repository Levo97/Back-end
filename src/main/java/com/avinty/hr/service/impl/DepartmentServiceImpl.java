package com.avinty.hr.service.impl;

import com.avinty.hr.entity.Department;
import com.avinty.hr.repository.DepartmentRepository;
import com.avinty.hr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List<Department> searchDepartment(String name) {
        return departmentRepository.searchDepartment(name);
    }

    @Override
    public List<Department> getAllDepartment() {
        return (List<Department>) this.departmentRepository.findAll();
    }


}
