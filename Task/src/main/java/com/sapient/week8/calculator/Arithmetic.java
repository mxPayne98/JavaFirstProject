package com.sapient.week8.calculator;

public abstract class Arithmetic<T extends Number> {
    public abstract double calculate(T a, T b) throws ArithmeticException;
}
