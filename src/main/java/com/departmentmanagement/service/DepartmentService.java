package com.departmentmanagement.service;

import com.departmentmanagement.dao.DepartmentDao;
import com.departmentmanagement.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {


    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public List<Department> getDepartments() {

        List<Department> departments = departmentDao.allDepartments();
        //Long emp=employees.stream().filter(x->x.getEmpSal()==1000000).count();
        return departments;
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
