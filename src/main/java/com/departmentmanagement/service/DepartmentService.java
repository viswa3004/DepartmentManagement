package com.departmentmanagement.service;

import com.departmentmanagement.dao.DepartmentDao;
import com.departmentmanagement.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {


    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public List<Department> getDepartments() {

        List<Department> departments = departmentDao.allDepartments();
        List<Department> deptStream = departments
                .stream()
                .filter(c -> c.getDeptName().length()>6 && c.getDeptType().contains("HR"))
                .collect(Collectors.toList());
        return deptStream;
    }

    public Department create(Department departments) {
        return departmentDao.saveDepartment(departments);
    }

    public Department findById(Integer id) {
        return departmentDao.getById(id);
    }

    public Department update(Integer id, Department departments) {
        departments.setId(id);
        return departmentDao.updateDepartment(departments);
    }

    public void delete(Integer id) {
        departmentDao.deleteById(id);
    }
}
