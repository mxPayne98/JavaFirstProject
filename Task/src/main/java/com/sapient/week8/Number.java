package com.sapient.week8;

public class Number {

    public boolean checkPrime(int n) {
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public boolean checkArmstrong(int n) {
        int armstrong = 0, num = n, digits = 0;
        while (num != 0) {
            num /= 10;
            digits++;
        }
        num = n;
        while (num != 0) {
            armstrong += Math.pow(num % 10, digits);
            num /= 10;
        }

        return armstrong == n;
    }

    public boolean checkPalindrome(int n) {
        int reversedInteger = 0, num = n;
        while (num != 0) {
            reversedInteger = reversedInteger * 10 + num % 10;
            num /= 10;
        }
        return n == reversedInteger;
    }
}
