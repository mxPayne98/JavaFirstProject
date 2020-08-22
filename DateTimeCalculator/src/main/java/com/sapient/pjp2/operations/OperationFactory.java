package com.sapient.pjp2.operations;

import java.time.LocalDate;
import java.util.List;

public class OperationFactory {
    public static final int ADD = 1;
    public static final int SUBTRACT = 2;
    public static final int ADD_N_DAYS = 3;
    public static final int ADD_N_WEEKS = 5;
    public static final int ADD_N_MONTHS = 7;
    public static final int DAY_OF_WEEK = 9;
    public static final int WEEK_NUMBER = 10;
    public static final int NLP = 11;

    public Operation getOperation(int option, List<Object> inputs) {
        if (option == ADD) {
            LocalDate a = (LocalDate) inputs.get(0);
            LocalDate b = (LocalDate) inputs.get(1);
            return new AddOperation(a, b);
        } else if (option == SUBTRACT) {
            LocalDate a = (LocalDate) inputs.get(0);
            LocalDate b = (LocalDate) inputs.get(1);
            return new SubtractOperation(a, b);
        } else if (option == ADD_N_DAYS) {
            LocalDate d = (LocalDate) inputs.get(0);
            Integer n = (Integer) inputs.get(1);
            return new NDaysOperation(d, n);
        } else if (option == ADD_N_WEEKS) {
            LocalDate d = (LocalDate) inputs.get(0);
            Integer n = (Integer) inputs.get(1);
            return new NWeeksOperation(d, n);
        } else if (option == ADD_N_MONTHS) {
            LocalDate d = (LocalDate) inputs.get(0);
            Integer n = (Integer) inputs.get(1);
            return new NMonthsOperation(d, n);
        } else if (option == DAY_OF_WEEK) {
            LocalDate d = (LocalDate) inputs.get(0);
            return new DofWOperation(d);
        } else if (option == WEEK_NUMBER) {
            LocalDate d = (LocalDate) inputs.get(0);
            return new WeekNOperation(d);
        } else if (option == NLP) {
            LocalDate d = (LocalDate) inputs.get(0);
            String expression = (String) inputs.get(1);
            return new NLPOperation(d, expression);
        }
        return null;
    }
}
