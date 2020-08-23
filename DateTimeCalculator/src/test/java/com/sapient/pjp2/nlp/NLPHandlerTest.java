package com.sapient.pjp2.nlp;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class NLPHandlerTest {

    private final String PATTERN = "dd-MM-yyyy";
    private final String DATE = "22-08-2020";
    private final LocalDate localDate = LocalDate.parse(DATE, DateTimeFormatter.ofPattern(PATTERN).withLocale(Locale.getDefault()));

    @Test
    public void testParser1() {
        String expression = "10 days from now";
        assertEquals("01-09-2020", NLPHandler.parser(localDate, expression));
    }

    @Test
    public void testParser2() {
        String expression = "3 months earlier";
        assertEquals("22-05-2020", NLPHandler.parser(localDate, expression));
    }

    @Test
    public void testParser3() {
        String expression = "tomorrow";
        assertEquals("23-08-2020", NLPHandler.parser(localDate, expression));
    }

    @Test
    public void testParserNotUnderstood() {
        assertEquals("Expression currently not understood: ttl24$5!", NLPHandler.parser(localDate, "ttl24$5!"));
    }

    @Test
    public void testParserIllegalPatternException() {
        assertThrows(IllegalArgumentException.class, () -> NLPHandler.parser(localDate, "   "));
    }
}