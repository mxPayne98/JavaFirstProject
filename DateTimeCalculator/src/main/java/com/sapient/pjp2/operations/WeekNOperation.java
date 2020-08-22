package com.sapient.pjp2.operations;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class WeekNOperation extends Operation {
    private String result;
    private final LocalDate d;
    public static final String retexp = "Week number is %d .";

    public WeekNOperation(LocalDate d) {
        this.d = d;
    }

    @Override
    public Operation operate() {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber = this.d.get(weekFields.weekOfWeekBasedYear());
        this.result = String.format(retexp, weekNumber);
        return this;
    }

    @Override
    public String getResult() {
        return this.result;
    }

    @Override
    public String getName() {
        return "WEEK NUMBER";
    }
}
