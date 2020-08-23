package com.sapient.pjp2.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public interface DateUtil {
    String PATTERN1 = "MM-dd-yyyy";
    String PATTERN2 = "dd-MM-yyyy";
    String PATTERN3 = "dd/MM/yyyy";
    String PATTERN4 = "dd, MMMM, yyyy";
    String PATTERN5 = "dd-MM-yy";

    static LocalDate parseString(String source, String pattern) {
        DateTimeFormatter formatter = getDateFormat(pattern);
        return LocalDate.parse(source, formatter);
    }

    static String parseDate(LocalDate date) {
        if (date == null) {
            throw new NullPointerException("Invalid date.");
        }
        return date.format(getDateFormat(PATTERN2));
    }

    static DateTimeFormatter getDateFormat(String pattern) {
        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Invalid pattern.");
        }

        return DateTimeFormatter.ofPattern(pattern).withLocale(Locale.getDefault());
    }

}
