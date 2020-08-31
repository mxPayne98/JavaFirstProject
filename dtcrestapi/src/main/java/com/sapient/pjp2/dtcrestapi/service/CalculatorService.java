package com.sapient.pjp2.dtcrestapi.service;

import com.sapient.pjp2.Calculator;
import com.sapient.pjp2.DateTimeCalculator;
import com.sapient.pjp2.session.DateTimeOperation;
import com.sapient.pjp2.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static com.sapient.pjp2.utils.DateUtil.*;

@Service
public class CalculatorService {
    private class Input {
        LocalDate[] dates;
        Integer n;

        Input(LocalDate[] dates, Integer n) {
            this.dates = dates;
            this.n = n;
        }
    }

    /*
    "Choose operation: "
            "1. add dates "
            "2. subtract dates"
            "3. add n days to a specific date"
            "4. subtract n days to a specific date"
            "5. add n weeks to a specific date"
            "6. subtract n weeks to a specific date"
            "7. add n months to a specific date"
            "8. subtract n months to a specific date"
            "9. day of the week of a specific date"
            "10. week number of a specific date"
            "11. natural language command"
            "12. view history"
            */
    private final Calculator calculator;
    public final Map<Integer, BiFunction<LocalDate[], Integer, String>> operations;
    private final String pattern = PATTERN2;

    public CalculatorService() {
        this.calculator = new DateTimeCalculator();
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

    public String execute(int option, String[] inputs) {
        try {
            if (option >= 1 && option <= 12) {
                String result;
                if (option == 12) {
                    result = this.calculator.viewHistory(true);
                } else if (option == 11) {
                    result = this.calculator.naturalProcessor(inputs[0]);
                } else {
                    Input ips = parse(option, inputs);
                    result = this.operations.get(option).apply(ips.dates, ips.n);
                }
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Input parse(int option, String[] inputs) {
        LocalDate[] dates = null;
        int n = -1;
        if (option == 1 || option == 2) {
            dates = parseDates(inputs);
        } else if (option == 3 || option == 4 || option == 5 || option == 6 ||
                option == 7 || option == 8) {
            dates = parseDates(new String[]{inputs[0]});
            n = Integer.parseInt(inputs[1]);
        } else if (option == 9 || option == 10) {
            dates = parseDates(new String[]{inputs[0]});
        }
        return new Input(dates, n);
    }

    private LocalDate[] parseDates(String[] dates) {
        List<LocalDate> dateList = Arrays.stream(dates)
                .map(x -> DateUtil.parseString(x, pattern))
                .collect(Collectors.toList());
        LocalDate[] localDates = new LocalDate[dateList.size()];
        return dateList.toArray(localDates);
    }

    public Calculator getCalculator() {
        return this.calculator;
    }
}
