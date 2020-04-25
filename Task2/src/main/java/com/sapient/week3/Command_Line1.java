package com.sapient.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Command_Line1 {
    private List<Integer> numbers;
    private Integer sum;
    private Double avg;
    private Integer biggest;
    private Integer smallest;

    public void setData() {
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

    public void calData() {
        if (numbers == null || numbers.size() == 0) {
            System.out.println("No numbers to calculate data.");
            return;
        }
        this.sum = 0;
        this.avg = 0.0;
        this.biggest = Integer.MIN_VALUE;
        this.smallest = Integer.MAX_VALUE;
        for (int n : numbers) {
            this.sum += n;
            this.biggest = n > biggest ? n : this.biggest;
            this.smallest = n < smallest ? n : this.smallest;
        }
        this.avg = (double) this.sum / this.numbers.size();
    }

    public void displayData() {
        if (numbers == null || numbers.size() == 0) {
            System.out.println("No numbers to display data.");
            return;
        }
        System.out.print("Numbers: ");
        System.out.println(this.numbers);
        System.out.println(String.format("Sum: %d", this.sum));
        System.out.println(String.format("Avg: %f", this.avg));
        System.out.println(String.format("Biggest: %d", this.biggest));
        System.out.println(String.format("Smallest: %d", this.smallest));
    }
}
