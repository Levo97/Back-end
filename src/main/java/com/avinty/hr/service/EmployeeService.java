package com.avinty.hr.service;

import com.avinty.hr.entity.Employee;

import java.util.List;
public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployee();

}
