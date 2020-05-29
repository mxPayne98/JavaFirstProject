package com.sapient.week8.employee;

import com.sapient.week8.employee.model.Employee;

public class AddEmployee implements EmployeeBO {

    private EmployeeDAO dao;

    public void setDao(EmployeeDAO dao) {
        this.dao = dao;
    }

    @Override
    public void addEmployee(Employee employee) throws Exception {
        if (employee == null || employee.getName() == null || employee.getCity() == null) {
            throw new Exception("Invalid Employee.");
        }

        int emp_id = dao.createEmployee(employee);

        if (emp_id == 0) throw new Exception("Error creating employee.");
    }

    @Override
    public Employee getEmployee(int id) throws Exception {
        Employee e = dao.readEmployee(id);
        return e;
    }
}
