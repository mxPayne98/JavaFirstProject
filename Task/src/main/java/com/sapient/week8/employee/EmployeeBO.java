package com.sapient.week8.employee;

import com.sapient.week8.employee.model.Employee;

public interface EmployeeBO {
    public void addEmployee(Employee employee) throws Exception;

    public Employee getEmployee(int id) throws Exception;
}
