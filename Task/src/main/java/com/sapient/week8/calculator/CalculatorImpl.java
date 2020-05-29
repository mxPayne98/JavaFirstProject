package com.sapient.week8.calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorImpl implements Calculator {

    private List<String> history;

    public CalculatorImpl() {
        this.history = new ArrayList<>();
    }

    @Override
    public String getLastResult() throws Exception {
        return this.history.get(this.history.size() - 1);
    }

    @Override
    public double calculate(Number a, Number b, String operator) throws Exception {
        Arithmetic<Number> operation = Operation.getOperation(operator);
        double result = operation.calculate(a, b);
        this.history.add(a + " " + operator + " " + b + " = " + result);
        return result;
    }

    @Override
    public double calculate(String expression) throws Exception {
        Node root = ExpressionTree.constructTree(expression);
        double result = this.calculate(root);
        this.history.add(expression + " = " + result);
        return result;
    }


    private double calculate(Node root) throws Exception {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return Double.parseDouble(root.val);
        }

        String operator = root.val;
        double left = calculate(root.left);
        double right = calculate(root.right);
        Arithmetic<Number> operation = Operation.getOperation(operator);
        return operation.calculate(left, right);
    }

}
