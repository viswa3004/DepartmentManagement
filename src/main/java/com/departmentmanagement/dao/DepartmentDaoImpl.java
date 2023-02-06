package com.departmentmanagement.dao;

import com.departmentmanagement.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {


    private static final String INSERT_DEPT_QUERY = "INSERT INTO DEPARTMENT(id, deptname, depttype) values (?,?,?)";
    private static final String UPDATE_DEPT_BY_ID_QUERY = "UPDATE DEPARTMENT SET deptname=? WHERE ID=?";
    private static final String GET_DEPT_BY_ID_QUERY = "SELECT * FROM DEPARTMENT WHERE ID=?";
    private static final String DELETE_DEPT_BY_ID = "DELETE FROM DEPARTMENT WHERE ID=?";
    private static final String GET_DEPTS_QUERY = "SELECT * FROM DEPARTMENT";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Department saveDepartment(Department department) {
        jdbcTemplate.update(INSERT_DEPT_QUERY, department.getId(), department.getDeptName(), department.getDeptType());
        return department;
    }

    @Override
    public Department updateDepartment(Department department) {
        jdbcTemplate.update(UPDATE_DEPT_BY_ID_QUERY, department.getDeptName(), department.getId());
        return department;
    }

    @Override
    public Department getById(int id) {
        return jdbcTemplate.queryForObject(GET_DEPT_BY_ID_QUERY, (rs, rowNum) -> {
            return new Department(rs.getInt("ID"), rs.getString("deptname"), rs.getString("depttype"));
        },id);

    }

    @Override
    public String deleteById(int id) {
        jdbcTemplate.update(DELETE_DEPT_BY_ID, id);
        return "Department got deleted with id: " + id;
    }

    @Override
    public List<Department> allDepartments() {
        return jdbcTemplate.query(GET_DEPTS_QUERY, (rs, rowNum) -> {
            return new Department(rs.getInt("id"), rs.getString("deptname"), rs.getString("depttype"));
        });
    }
}
