package com.sapient.week4;

import java.util.Scanner;

public class Matrix {
    int[][] matrix;

    public Matrix() {
        this(3);
    }

    public Matrix(int size) {
        this.matrix = new int[size][size];
    }

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix(Matrix that) {
        this.matrix = that.matrix;
    }

    public void read() {
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[0].length; j++) {
                    this.matrix[i][j] = sc.nextInt();
                }
            }
        }
    }

    public void display() {
        for (int[] rows : this.matrix) {
            for (int col : rows) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public void add(Matrix that) {
        if (that == null) {
            throw new NullPointerException("Matrix is null");
        }
        if (this.matrix.length != that.matrix.length || this.matrix[0].length != that.matrix[0].length) {
            throw new RuntimeException("Invalid addition.");
        }

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                this.matrix[i][j] += that.matrix[i][j];
            }
        }
    }

    public Matrix multiply(Matrix that) {
        if (that == null) {
            throw new NullPointerException("Matrix is null");
        }
        if (this.matrix[0].length != that.matrix.length) {
            throw new RuntimeException("Invalid multiplication.");
        }
        return this.multiply(that.matrix);
    }

    public Matrix multiply(int[][] that) {
        if (that == null) {
            throw new NullPointerException("Matrix is null");
        }
        if (this.matrix[0].length != that.length) {
            throw new RuntimeException("Invalid multiplication.");
        }
        Matrix res = new Matrix(this.matrix.length);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix.length; j++) {
                for (int k = 0; k < this.matrix.length; k++)
                    res.matrix[i][j] += this.matrix[i][k] * that[k][j];
            }
        }
        return res;
    }
}