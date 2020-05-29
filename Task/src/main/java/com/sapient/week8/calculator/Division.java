package com.sapient.week8.calculator;

public class Division<T extends Number> extends Arithmetic<T> {
    @Override
    public double calculate(T a, T b) throws ArithmeticException {
        return a.doubleValue() / b.doubleValue();
    }
}
