package com.sapient.week8.employee.model;

import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private String city;

    public Employee(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() &&
                Objects.equals(getName(), employee.getName()) &&
                Objects.equals(getCity(), employee.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCity());
    }
}
