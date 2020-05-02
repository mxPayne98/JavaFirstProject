package com.sapient.week4;

import java.util.Scanner;

public class Num_Process_Runner {
    public static void main(String[] args) {
        System.out.println("Choices: (Add: 0), (Subtract: 1), (Multiply: 2), (Divide: 3)");
        System.out.println("Enter 2 numbers followed by Choice: ");
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int choice = sc.nextInt();
            int[] answers = new int[4];
            Num_Process add = (int n1, int n2) -> n1 + n2;
            answers[0] = add.call(a, b);

            Num_Process subtract = (int n1, int n2) -> n1 - n2;
            answers[1] = subtract.call(a, b);

            Num_Process multiply = (int n1, int n2) -> n1 * n2;
            answers[2] = multiply.call(a, b);

            Num_Process divide = (int n1, int n2) -> n1 / n2;
            answers[3] = divide.call(a, b);

            try {
                System.out.println(answers[choice]);
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }

            answers = null;
            add = subtract = multiply = divide = null;
        }

    }
}
