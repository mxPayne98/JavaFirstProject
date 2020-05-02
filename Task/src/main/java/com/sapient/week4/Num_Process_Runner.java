package com.sapient.week4;

public class Num_Process_Runner {
    public static void main(String[] args) {
        Num_Process add = (int n1, int n2) -> n1 + n2;
        int sum = add.call(10, 2);
        System.out.println(sum);

        Num_Process subtract = (int n1, int n2) -> n1 - n2;
        int diff = subtract.call(10, 2);
        System.out.println(diff);

        Num_Process multiply = (int n1, int n2) -> n1 * n2;
        int prod = multiply.call(10, 2);
        System.out.println(prod);

        Num_Process divide = (int n1, int n2) -> n1 / n2;
        int q = divide.call(10, 2);
        System.out.println(q);
    }
}
