package com.sapient.pjp2.operations;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class DofWOperation extends Operation {
    private String result;
    private final LocalDate d;

    public DofWOperation(LocalDate d) {
        this.d = d;
    }

    @Override
    public Operation operate() {
        this.result = d.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
        return this;
    }

    @Override
    public String getResult() {
        return this.result;
    }

    @Override
    public String getName() {
        return "DAY OF THE WEEK";
    }
}
