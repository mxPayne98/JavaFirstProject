package com.sapient.pjp2.console;

import com.sapient.pjp2.Calculator;
import com.sapient.pjp2.utils.DateUtil;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import static com.sapient.pjp2.utils.DateUtil.*;

public class ConsoleUI {
    private class Input {
        LocalDate[] dates;
        Integer n;

        Input(LocalDate[] dates, Integer n) {
            this.dates = dates;
            this.n = n;
        }
    }

    private final Calculator calculator;
    public final Map<Integer, BiFunction<LocalDate[], Integer, String>> operations;
    private final BufferedReader br;
    private final PrintWriter out;

    public ConsoleUI(Calculator calculator) {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.out = new PrintWriter(new BufferedOutputStream(System.out), true);
        this.calculator = calculator;
        this.operations = Map.ofEntries(
                Map.entry(1, (dates, n) -> this.calculator.addDate(dates[0], dates[1])),
                Map.entry(2, (dates, n) -> this.calculator.subtractDate(dates[0], dates[1])),
                Map.entry(3, (dates, n) -> this.calculator.addNDays(dates[0], n)),
                Map.entry(4, (dates, n) -> this.calculator.subtractNDays(dates[0], n)),
                Map.entry(5, (dates, n) -> this.calculator.addNWeeks(dates[0], n)),
                Map.entry(6, (dates, n) -> this.calculator.subtractNWeeks(dates[0], n)),
                Map.entry(7, (dates, n) -> this.calculator.addNMonths(dates[0], n)),
                Map.entry(8, (dates, n) -> this.calculator.subtractNMonths(dates[0], n)),
                Map.entry(9, (dates, n) -> this.calculator.dayOfTheWeek(dates[0])),
                Map.entry(10, (dates, n) -> this.calculator.weekNumber(dates[0]))
        );
    }

    private String setDateFormat() throws IOException {
        List<String> availablePatterns = List.of(PATTERN1, PATTERN2, PATTERN3, PATTERN4, PATTERN5);
        out.println("Choose date format from following options: ");
        for (int i = 1; i < availablePatterns.size(); i++) {
            out.println(i + ". " + availablePatterns.get(i - 1));
        }
        int option = Integer.parseInt(br.readLine());
        return availablePatterns.get(option - 1);
    }

    private void menu() {
        out.println("Choose operation: ");
        out.println("1. add dates ");
        out.println("2. subtract dates");
        out.println("3. add n days to a specific date");
        out.println("4. subtract n days to a specific date");
        out.println("5. add n weeks to a specific date");
        out.println("6. subtract n weeks to a specific date");
        out.println("7. add n months to a specific date");
        out.println("8. subtract n months to a specific date");
        out.println("9. day of the week of a specific date");
        out.println("10. week number of a specific date");
        out.println("11. natural language command");
        out.println("12. view history");
        out.println("0. exit");
    }

    public void run() {
        try {
            String pattern = setDateFormat();
            int option;
            do {
                menu();
                option = Integer.parseInt(br.readLine());
                if (option >= 1 && option <= 12) {
                    String result;
                    if (option == 12) {
                        result = this.calculator.viewHistory();
                    } else if (option == 11) {
                        result = executeNLP();
                    } else {
                        result = execute(option, operations.get(option), pattern);
                    }
                    out.println("Result:\n" + result);
                }
            } while (option > 0 && option <= 12);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String executeNLP() throws IOException {
        LocalDate d = LocalDate.now();
        String expression = takeNLPInput();
        return this.calculator.naturalProcessor(d, expression);
    }

    private String execute(int option, BiFunction<LocalDate[], Integer, String> function, String pattern) throws Exception {
        Input inputs = takeInput(option, pattern);
        return function.apply(inputs.dates, inputs.n);
    }

    private String takeNLPInput() throws IOException {
        out.println("Natural Language Expression");
        String expression = br.readLine();
        return expression;
    }

    private Input takeInput(int option, String pattern) throws Exception {
        LocalDate[] dates = null;
        int n = -1;
        if (option == 1) {
            out.println("Add dates");
            dates = takeInput2Dates(pattern);
        } else if (option == 2) {
            out.println("Subtract dates");
            dates = takeInput2Dates(pattern);
        } else if (option == 3) {
            out.println("Add n days");
            dates = takeInput1Date(pattern);
            n = takeInputN("days");
        } else if (option == 4) {
            out.println("Subtract n days");
            dates = takeInput1Date(pattern);
            n = takeInputN("days");
        } else if (option == 5) {
            out.println("Add n weeks");
            dates = takeInput1Date(pattern);
            n = takeInputN("weeks");
        } else if (option == 6) {
            out.println("Subtract n weeks");
            dates = takeInput1Date(pattern);
            n = takeInputN("weeks");
        } else if (option == 7) {
            out.println("Add n months");
            dates = takeInput1Date(pattern);
            n = takeInputN("months");
        } else if (option == 8) {
            out.println("Subtract n months");
            dates = takeInput1Date(pattern);
            n = takeInputN("months");
        } else if (option == 9) {
            out.println("Day of the week");
            dates = takeInput1Date(pattern);
        } else if (option == 10) {
            out.println("Week number");
            dates = takeInput1Date(pattern);
        }

        return new Input(dates, n);
    }

    private LocalDate[] takeInput1Date(String pattern) throws IOException {
        out.println("Enter the date in format: " + pattern);
        LocalDate d = DateUtil.parseString(br.readLine(), pattern);
        return new LocalDate[]{d};
    }

    private LocalDate[] takeInput2Dates(String pattern) throws IOException {
        out.println("Enter the first date in format: " + pattern);
        LocalDate d1 = DateUtil.parseString(br.readLine(), pattern);
        out.println("Enter the second date in format: " + pattern);
        LocalDate d2 = DateUtil.parseString(br.readLine(), pattern);
        return new LocalDate[]{d1, d2};
    }

    private int takeInputN(String arg) throws IOException {
        out.println("Enter the number of " + arg + " n: ");
        return Integer.parseInt(br.readLine());
    }
}
