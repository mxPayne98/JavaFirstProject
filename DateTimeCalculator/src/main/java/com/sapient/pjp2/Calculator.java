package com.sapient.pjp2;

import java.time.LocalDate;

public interface Calculator {

    public String addDate(LocalDate d1, LocalDate d2);

    public String subtractDate(LocalDate d1, LocalDate d2);

    public String addNDays(LocalDate d, Integer n);

    public String subtractNDays(LocalDate d, Integer n);

    public String addNWeeks(LocalDate d, Integer n);

    public String subtractNWeeks(LocalDate d, Integer n);

    public String addNMonths(LocalDate d, Integer n);

    public String subtractNMonths(LocalDate d, Integer n);

    public String dayOfTheWeek(LocalDate d);

    public String weekNumber(LocalDate d);

    public String naturalProcessor(LocalDate d, String expression);

    public String naturalProcessor(String expression);

    public String viewHistory(boolean fromMemory);
}
