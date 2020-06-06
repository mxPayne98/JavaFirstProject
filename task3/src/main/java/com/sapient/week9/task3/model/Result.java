package com.sapient.week9.task3.model;

import java.util.HashMap;

public class Result {
    HashMap<String, Double> marks;

    protected Result() {

    }

    public HashMap<String, Double> getMarks() {
        return marks;
    }

    public void setMarks(HashMap<String, Double> marks) {
        this.marks = marks;
    }
}
