package com.avinty.hr.controller;


import com.avinty.hr.entity.Department;
import com.avinty.hr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
//@CrossOrigin(origins = "http://localhost:5000")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @DeleteMapping("/department/{id}")
    public HttpStatus deleteDepartment(@PathVariable Integer id){
        this.departmentService.deleteDepartment(id);
        return HttpStatus.OK;
    }


    @GetMapping("/department")
    public ResponseEntity<List<String>> searchDepartment(@RequestParam("name") String name){
        return ResponseEntity.ok().body((departmentService.searchDepartment(name)));
    }
    @GetMapping("/dep-emp")
    public ResponseEntity<List<Department>> getAllEmployee(){
        return ResponseEntity.ok().body(departmentService.getAllDepartment());
    }

}