package com.sapient.week8.employee;

import com.sapient.week8.employee.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private List<Employee> employees;

    public EmployeeDAOImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public int createEmployee(Employee employee) throws Exception {
        this.employees.add(employee);
        return this.employees.size();
    }

    @Override
    public Employee readEmployee(int id) throws Exception {
        Employee e = this.employees
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst().orElse(null);
        return e;
    }
}
