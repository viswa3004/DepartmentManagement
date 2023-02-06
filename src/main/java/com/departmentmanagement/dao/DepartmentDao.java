package com.departmentmanagement.dao;

import com.departmentmanagement.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentDao {
    Department saveDepartment (Department user);
    Department updateDepartment (Department user);
    Department getById(int id);
    String deleteById(int id);
    List<Department> allDepartments();
}
