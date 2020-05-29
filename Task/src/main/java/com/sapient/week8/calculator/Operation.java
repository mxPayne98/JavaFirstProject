package com.sapient.week8.calculator;

public class Operation {

    public static Arithmetic<Number> getOperation(String operator) throws Exception {
        Arithmetic<Number> operation;
        switch (operator) {
            case "+":
                operation = new Addition<>();
                break;
            case "-":
                operation = new Subtraction<>();
                break;
            case "*":
                operation = new Multiplication<>();
                break;
            case "/":
                operation = new Division<>();
                break;
            default:
                throw new Exception("Invalid operation.");
        }

        return operation;
    }
}
