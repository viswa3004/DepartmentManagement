package com.departmentmanagement.controller;

import com.departmentmanagement.entity.Department;
import com.departmentmanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/depts")
    public List<Department> employeeList(){

        return departmentService.getDepartments();
    }

    @PostMapping("/saveDept")
    public Department create(@RequestBody Department employee) {
        return departmentService.create(employee);
    }

    @GetMapping("getID/{id}")
    public Department findById(@PathVariable Integer id) {
        return departmentService.findById(id);
    }

    @PutMapping("update/{id}")
    public Department update(@PathVariable Integer id, @RequestBody Department employee) {
        employee.setId(id);
        return departmentService.update(id,employee);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        departmentService.delete(id);
    }
}
