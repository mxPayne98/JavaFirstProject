package com.sapient.pjp2.operations;

import java.time.LocalDate;
import java.time.Period;

public class SubtractOperation extends Operation {
    private String result;
    private final LocalDate a;
    private final LocalDate b;

    private static final String resexp = "Difference is %d years, %d months, %d weeks and %d days";

    public SubtractOperation(LocalDate a, LocalDate b) {
        this.a = a;
        this.b = b;
        this.result = null;
    }

    @Override
    public Operation operate() {
        LocalDate from, to;
        if (a.compareTo(b) <= 0) {
            to = b;
            from = a;
        } else {
            to = a;
            from = b;
        }
        Period p = Period.between(from, to);
        this.result = String.format(resexp, p.getYears(), p.getMonths(), p.getDays() / 7, p.getDays() % 7);
        return this;
    }

    @Override
    public String getResult() {
        return this.result;
    }

    @Override
    public String getName() {
        return "SUBTRACT 2 DATES";
    }
}
