package com.sapient.week1;

public class App {
    public static void main(String[] args) {
        CheckEven checkEven = new CheckEven();
        System.out.println("Checking for even numbers");
        System.out.println("Is 22 even > " + checkEven.check(22));
        System.out.println("Is 23 even > " + checkEven.check(23));
        System.out.println("Is 24 even > " + checkEven.check(24));
        System.out.println("Is 25 even > " + checkEven.check(25));
    }
}
