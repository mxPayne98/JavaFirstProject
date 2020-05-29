package com.sapient.week8;

import com.sapient.week8.calculator.Calculator;
import com.sapient.week8.calculator.CalculatorImpl;

public class App {
    public static void main(String[] args) {
        Calculator c = new CalculatorImpl();
        String exp = "( ( 10 + ( ( 2 * 3 ) / 4 ) ) - 2 )";
        try {
            c.calculate(exp);
            System.out.println(c.getLastResult());
            c.calculate(2, 3, "*");
            System.out.println(c.getLastResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
