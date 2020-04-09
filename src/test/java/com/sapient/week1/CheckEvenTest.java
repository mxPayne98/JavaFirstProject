package com.sapient.week1;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class CheckEvenTest {
    private CheckEven checkEven;

    @Before
    public void setup() {
        checkEven = new CheckEven();
    }

    @Test
    public void testCheckOdd() {
        Boolean isOdd = checkEven.check(31);
        assertFalse(isOdd == true);
    }

    @Test
    public void testCheckEven() {
        Boolean isEven = checkEven.check(98);
        assertTrue(isEven == true);
    }

    @Ignore
    @Test
    public void testCheckEven1() {
        Boolean isEven = checkEven.check(87);
        assertTrue(isEven == true);
    }
}