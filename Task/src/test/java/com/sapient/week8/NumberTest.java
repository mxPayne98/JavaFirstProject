package com.sapient.week8;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumberTest {

    private Number number;

    @Before
    public void setUp() {
        this.number = new Number();
    }

    @After
    public void tearDown() {
        this.number = null;
    }

    @Test
    public void checkPrime_Positive() {
        assertTrue(this.number.checkPrime(13));
    }

    @Test
    public void checkPrime_Negative() {
        assertFalse(this.number.checkPrime(222));
    }

    @Test
    public void checkArmstrong_Positive() {
        assertTrue(this.number.checkArmstrong(153));
    }

    @Test
    public void checkArmstrong_Negative() {
        assertFalse(this.number.checkArmstrong(213));
    }

    @Test
    public void checkPalindrome_Positive() {
        assertTrue(this.number.checkPalindrome(121));
    }

    @Test
    public void checkPalindrome_Negative() {
        assertFalse(this.number.checkPalindrome(2121));
    }
}