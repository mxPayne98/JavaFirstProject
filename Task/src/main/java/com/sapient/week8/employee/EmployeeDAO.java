package com.sapient.week8.employee;

import com.sapient.week8.employee.model.Employee;

public interface EmployeeDAO {
    public int createEmployee(Employee employee) throws Exception;

    public Employee readEmployee(int id) throws Exception;
}
