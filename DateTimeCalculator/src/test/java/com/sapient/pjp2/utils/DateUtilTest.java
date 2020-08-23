package com.sapient.pjp2.utils;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.Assert.*;

public class DateUtilTest {

    private static String PATTERN;
    private static String DATE;
    private static LocalDate localDate;
    private static DateTimeFormatter formatter;

    @BeforeClass
    public static void beforeClass() throws Exception {
        PATTERN = "dd-MM-yyyy";
        DATE = "22-08-2020";
        formatter = DateTimeFormatter.ofPattern(PATTERN).withLocale(Locale.getDefault());
        localDate = LocalDate.parse(DATE, formatter);
    }

    @Test
    public void testParseString() {
        assertEquals(localDate, DateUtil.parseString(DATE, PATTERN));
    }

    @Test
    public void testParseDate() {
        assertEquals(DATE, DateUtil.parseDate(localDate));
    }

    @Test
    public void testParseDateThrowsNullException() {
        assertThrows(NullPointerException.class, () -> DateUtil.parseDate(null));
    }

    @Test
    public void testDateFormatterThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> DateUtil.getDateFormat("     "));
    }
}