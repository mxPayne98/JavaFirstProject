package com.sapient.pjp2;

public class App {
    public static void main(String[] args) {
//        ReportGenerator generator = new AverageIncomeReportGenerator(args[0], args[1]);
        ReportGenerator generator =
                new AverageIncomeReportGenerator("sample_input.csv", "output.csv");
        generator.generateIncomeReport();
    }
}
