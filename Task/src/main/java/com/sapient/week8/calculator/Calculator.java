package com.sapient.week8.calculator;

public interface Calculator {
    public double calculate(String expression) throws Exception;

    public double calculate(Number a, Number b, String o) throws Exception;

    public String getLastResult() throws Exception;
}
