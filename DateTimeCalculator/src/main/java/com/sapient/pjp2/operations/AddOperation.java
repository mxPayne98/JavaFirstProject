package com.sapient.pjp2.operations;

import com.sapient.pjp2.utils.DateUtil;

import java.time.LocalDate;

public class AddOperation extends Operation {

    private String result;
    private LocalDate a;
    private LocalDate b;

    public AddOperation(LocalDate a, LocalDate b) {
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
        LocalDate temp = from
                .plusYears(to.getYear())
                .plusMonths(to.getMonthValue())
                .plusDays(to.getDayOfMonth());
        this.result = DateUtil.parseDate(temp);
        return this;
    }

    @Override
    public String getResult() {
        return this.result;
    }

    @Override
    public String getName() {
        return "ADDING 2 DATES";
    }
}
