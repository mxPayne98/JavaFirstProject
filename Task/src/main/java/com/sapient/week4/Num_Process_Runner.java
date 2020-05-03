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
            Num_Process[] answers = new Num_Process[4];

            answers[0] = (int n1, int n2) -> n1 + n2;
            answers[1] = (int n1, int n2) -> n1 - n2;
            answers[2] = (int n1, int n2) -> n1 * n2;
            answers[3] = (int n1, int n2) -> n1 / n2;

            try {
                System.out.println(answers[choice].call(a,b));
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }

            answers = null;
        }

    }
}
