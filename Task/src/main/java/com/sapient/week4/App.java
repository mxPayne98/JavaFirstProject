package com.sapient.week4;

public class App {
    public static void main(String[] args) {
        Int_Arr_Process arr_Process = new Int_Arr_Process(5);
        arr_Process.read();
        arr_Process.sort();
        arr_Process.displayHorizontal();
        System.out.println(arr_Process.biggest());
        arr_Process = null;

        Matrix matrix = new Matrix();
        matrix.read();
        matrix.display();
        Matrix matrix2 = new Matrix(matrix);
        matrix.add(matrix2);
        matrix.display();

        matrix = null;
        matrix2 = null;
    }
}
