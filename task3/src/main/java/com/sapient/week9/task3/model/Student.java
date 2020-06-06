package com.sapient.week9.task3.model;

public class Student {
    Long id;
    String name;
    Result result;

    protected Student() {

    }

    public Student(Long id, String name, Result result) {
        this.id = id;
        this.name = name;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
