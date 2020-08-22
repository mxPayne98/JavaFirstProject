package com.sapient.pjp2;

import com.sapient.pjp2.console.ConsoleUI;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new DateTimeCalculator();
        ConsoleUI console = new ConsoleUI(calculator);
        console.run();
    }
}
