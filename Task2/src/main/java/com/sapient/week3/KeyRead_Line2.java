package com.sapient.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KeyRead_Line2 {
    private List<Integer> numbers;
    private boolean sorted;

    public KeyRead_Line2() {
        this.numbers = null;
        this.sorted = false;
    }

    public void read() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter n: ");
        try {
            int n = Integer.parseInt(br.readLine());
            this.numbers = new ArrayList<>();
            System.out.println("Enter n numbers: ");
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(br.readLine());
                numbers.add(num);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void display() {
        if (numbers == null || numbers.size() == 0) {
            System.out.println("No numbers to display data.");
            return;
        }
        System.out.print("Numbers: ");
        System.out.println(this.numbers);
    }

    public void sort() {
        if (numbers == null || numbers.size() == 0) {
            System.out.println("No numbers to sort data.");
            return;
        }
        Collections.sort(this.numbers);
        this.sorted = true;
    }

    public int find(int data) {
        if (numbers == null || numbers.size() == 0) {
            System.out.println("No numbers to find data.");
            return -1;
        }

        if (this.sorted) {
            return binarySearch(data);
        } else {
            return linearSearch(data);
        }

    }

    private int linearSearch(int data) {
        for (int i = 0; i < this.numbers.size(); i++) {
            if (this.numbers.get(i) == data)
                return i;
        }
        return -1;
    }

    private int binarySearch(int data) {
        int l = 0, r = this.numbers.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int num = this.numbers.get(mid);
            if (num == data) return mid;
            else if (num > data) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
}
