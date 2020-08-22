package com.sapient.pjp2.operations;

import com.sapient.pjp2.utils.DateUtil;

import java.time.LocalDate;

public class NDaysOperation extends Operation {
    private String result;
    private final LocalDate date;
    private final int increment;

    public NDaysOperation(LocalDate date, Integer n) {
        this.date = date;
        this.increment = n;
    }

    @Override
    public Operation operate() {
        LocalDate temp;
        if (this.increment > 0) {
            temp = date.plusDays(this.increment);
        } else {
            temp = date.minusDays(this.increment);
        }
        this.result = DateUtil.parseDate(temp);
        return this;
    }

    @Override
    public String getResult() {
        return this.result;
    }

    @Override
    public String getName() {
        return "ADD/SUBTRACT N DAYS";
    }
}
