package com.sapient.pjp2.operations;

import com.sapient.pjp2.nlp.NLPHandler;

import java.time.LocalDate;

public class NLPOperation extends Operation {
    private String result;
    private final LocalDate date;
    private final String expression;

    public NLPOperation(LocalDate d, String expression) {
        this.expression = expression;
        this.date = d;
    }

    @Override
    public Operation operate() {
        this.result = NLPHandler.parser(date, expression);
        return this;
    }

    @Override
    public String getResult() {
        return this.result;
    }

    @Override
    public String getName() {
        return "Natural Language Expression";
    }
}
