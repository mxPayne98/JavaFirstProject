package com.sapient.pjp2;

import com.sapient.pjp2.utils.DateUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;
    public static final String PATTERN = "dd-MM-yyyy";
    private LocalDate d1;
    private LocalDate d2;

    @Before
    public void setUp() {
        calculator = new DateTimeCalculator();
        d1 = DateUtil.parseString("20-05-2019", PATTERN);
        d2 = DateUtil.parseString("01-09-2020", PATTERN);
    }

    @After
    public void tearDown() {
        calculator = null;
        d1 = null;
        d2 = null;
    }

    @Test
    public void addDate() {
        assertEquals("21-02-4040", calculator.addDate(d1, d2));
    }

    @Test
    public void subtractDate() {
        assertEquals("Difference is 1 years, 3 months, 1 weeks and 5 days", calculator.subtractDate(d1, d2));
    }

    @Test
    public void subtractDateSameDates() {
        assertEquals("Difference is 0 years, 0 months, 0 weeks and 0 days", calculator.subtractDate(d1, d1));
    }

    @Test
    public void subtractDateAbsoluteDifference() {
        String result1 = calculator.subtractDate(d1, d2);
        String result2 = calculator.subtractDate(d2, d1);
        assertTrue(result1.equals(result2));
    }

    @Test
    public void addNDays() {
        assertEquals("19-05-2020", calculator.addNDays(d1, 365));
    }

    @Test
    public void addNDays1() {
        assertEquals("01-09-2021", calculator.addNDays(d2, 365));
    }

    @Test
    public void addNDaysSubtarct() {
        assertEquals("22-08-2020", calculator.addNDays(d2, -10));
    }

    @Test
    public void subtractNDays() {
        assertEquals("22-08-2020", calculator.subtractNDays(d2, 10));
    }

    @Test
    public void subtractNDaysAdd() {
        assertEquals("11-09-2020", calculator.subtractNDays(d2, -10));
    }

    @Test
    public void addNWeeks() {
        assertEquals("15-09-2020", calculator.addNWeeks(d2, 2));
    }

    @Test
    public void subtractNWeeks() {
        assertEquals("25-08-2020", calculator.subtractNWeeks(d2, 1));
    }

    @Test
    public void addSubtractNEqual() {
        String result1 = calculator.subtractNWeeks(d2, 1);
        String result2 = calculator.addNWeeks(d2, -1);
        assertTrue(result1.equals(result2));
    }

    @Test
    public void addNMonths() {
        assertEquals("20-08-2019", calculator.addNMonths(d1, 3));
    }

    @Test
    public void subtractNMonths() {
        assertEquals("20-02-2019", calculator.subtractNMonths(d1, 3));
    }

    @Test
    public void dayOfTheWeek() {
        assertEquals("Monday", calculator.dayOfTheWeek(d1));
        assertEquals("Tuesday", calculator.dayOfTheWeek(d2));
    }

    @Test
    public void weekNumber() {
        assertEquals("Week number is 21 .", calculator.weekNumber(d1));
        assertEquals("Week number is 36 .", calculator.weekNumber(d2));
    }

    @Test
    public void naturalProcessor() {
        assertEquals(DateUtil.parseDate(LocalDate.now().plusDays(1)),
                calculator.naturalProcessor("tomorrow"));
    }

    @Test
    public void testViewHistoryFromMemory() {
        calculator.addDate(d1, d2);
        calculator.subtractDate(d1, d2);
        calculator.naturalProcessor("12 weeks from now");
        String history = calculator.viewHistory(true);
        int lines = history.split("\n").length;
        assertEquals(3, lines);
    }
}