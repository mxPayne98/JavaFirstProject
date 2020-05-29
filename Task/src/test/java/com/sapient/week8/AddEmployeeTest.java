package com.sapient.week8;

import com.sapient.week8.employee.AddEmployee;
import com.sapient.week8.employee.EmployeeDAOImpl;
import com.sapient.week8.employee.model.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AddEmployeeTest {

    public static final int EMP_ID = 1001;
    public static final String EMP_NAME = "ABC";
    public static final String EMP_CITY = "DEF";

    @Mock
    EmployeeDAOImpl dao;

    AddEmployee bo;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bo = new AddEmployee();
        bo.setDao(dao);
    }

    @After
    public void tearDown() {
        bo = null;
    }

    @Test
    public void addEmployee_Success() throws Exception {
        Employee employee = new Employee(EMP_ID, EMP_NAME, EMP_CITY);
        when(dao.createEmployee(any(Employee.class))).thenReturn(1);
        bo.addEmployee(employee);
        verify(dao, atMost(1)).createEmployee(employee);
    }

    @Test(expected = Exception.class)
    public void addEmployee_Failure() throws Exception {
        Employee employee = new Employee(EMP_ID, EMP_NAME, EMP_CITY);
        when(dao.createEmployee(any(Employee.class))).thenReturn(0);
        bo.addEmployee(employee);
        verify(dao, atMost(1)).createEmployee(employee);
    }

    @Test(expected = Exception.class)
    public void addEmployee_Throws_Exception() throws Exception {
        Employee employee = new Employee(EMP_ID, EMP_NAME, EMP_CITY);
        when(dao.createEmployee(any(Employee.class))).thenThrow(Exception.class);
        bo.addEmployee(employee);
    }

    @Test
    public void getEmployee_Success() throws Exception {
        Employee employee = new Employee(EMP_ID, EMP_NAME, EMP_CITY);
        when(dao.readEmployee(anyInt())).thenReturn(employee);
        Employee e = bo.getEmployee(EMP_ID);
        assertEquals(e, employee);
        verify(dao).readEmployee(anyInt());
    }

    @Test
    public void getEmployee_Failure() throws Exception {
        when(dao.readEmployee(anyInt())).thenReturn(null);
        Employee e = bo.getEmployee(EMP_ID);
        assertNull(e);
        verify(dao).readEmployee(anyInt());
    }

    @Test(expected = Exception.class)
    public void getEmployee_Throws_Exception() throws Exception {
        when(dao.readEmployee(anyInt())).thenThrow(Exception.class);
        Employee e = bo.getEmployee(EMP_ID);
    }

}