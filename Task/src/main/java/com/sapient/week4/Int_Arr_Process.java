package com.sapient.week4;

import java.util.Arrays;
import java.util.Scanner;

public class Int_Arr_Process {
    private int[] arr;

    public Int_Arr_Process() {
        this(10);
    }

    public Int_Arr_Process(int size) {
        this.arr = new int[size];
    }

    public Int_Arr_Process(Int_Arr_Process that) {
        this.arr = that.arr;
    }

    public Int_Arr_Process(int[] that) {
        this.arr = that;
    }

    public void sort() {
        Arrays.sort(arr);
    }

    public void read() {
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < this.arr.length; i++) {
                this.arr[i] = sc.nextInt();
            }
        }
    }

    public void displayHorizontal() {
        for (int value : this.arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public void displayVertical() {
        for (int value : this.arr) {
            System.out.println(value + " ");
        }
    }

    public int sum() {
        return Arrays.stream(this.arr).reduce(0, Integer::sum);
    }

    public int biggest() {
        if (this.arr == null || this.arr.length == 0) {
            throw new RuntimeException("Invalid array.");
        }
        return Arrays.stream(this.arr).max().getAsInt();
    }

    public int smallest() {
        if (this.arr == null || this.arr.length == 0) {
            throw new RuntimeException("Invalid array.");
        }
        return Arrays.stream(this.arr).min().getAsInt();
    }

    public int secondBiggest() {
        if (this.arr == null || this.arr.length < 2) {
            throw new RuntimeException("Must have at least 2 elements");
        }
        int max = Integer.MIN_VALUE;
        int second_max = Integer.MIN_VALUE;
        for (int a : arr) {
            if (a > max) {
                second_max = max;
                max = a;
            } else if (a > second_max) {
                second_max = a;
            }
        }

        return second_max;
    }

}
