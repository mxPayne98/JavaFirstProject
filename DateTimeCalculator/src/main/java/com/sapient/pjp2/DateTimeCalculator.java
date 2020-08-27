package com.sapient.pjp2;

import com.sapient.pjp2.operations.Operation;
import com.sapient.pjp2.operations.OperationFactory;
import com.sapient.pjp2.session.CalculatorSession;
import com.sapient.pjp2.session.DateTimeOperation;
import com.sapient.pjp2.session.HibernateCalculatorSession;
import com.sapient.pjp2.session.OperationTransaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DateTimeCalculator implements Calculator {

    private final CalculatorSession calculatorSession;
    private final OperationFactory operationFactory;

    public DateTimeCalculator() {
        this.calculatorSession = new HibernateCalculatorSession();
        this.operationFactory = new OperationFactory();
    }

    @Override
    public String addDate(LocalDate d1, LocalDate d2) {
        return performOperation(OperationFactory.ADD, List.of(d1, d2));
    }

    @Override
    public String subtractDate(LocalDate d1, LocalDate d2) {
        return performOperation(OperationFactory.SUBTRACT, List.of(d1, d2));
    }

    @Override
    public String addNDays(LocalDate d, Integer n) {
        return performOperation(OperationFactory.ADD_N_DAYS, List.of(d, n));
    }

    @Override
    public String subtractNDays(LocalDate d, Integer n) {
        return addNDays(d, -n);
    }

    @Override
    public String addNWeeks(LocalDate d, Integer n) {
        return performOperation(OperationFactory.ADD_N_WEEKS, List.of(d, n));
    }

    @Override
    public String subtractNWeeks(LocalDate d, Integer n) {
        return addNWeeks(d, -n);
    }

    @Override
    public String addNMonths(LocalDate d, Integer n) {
        return performOperation(OperationFactory.ADD_N_MONTHS, List.of(d, n));
    }

    @Override
    public String subtractNMonths(LocalDate d, Integer n) {
        return addNMonths(d, -n);
    }


    @Override
    public String dayOfTheWeek(LocalDate d) {
        return performOperation(OperationFactory.DAY_OF_WEEK, List.of(d));
    }

    @Override
    public String weekNumber(LocalDate d) {
        return performOperation(OperationFactory.WEEK_NUMBER, List.of(d));
    }

    @Override
    public String naturalProcessor(String expression) {
        return naturalProcessor(null, expression);
    }

    @Override
    public String naturalProcessor(LocalDate d, String expression) {
        if (d == null) d = LocalDate.now();
        return performOperation(OperationFactory.NLP, List.of(d, expression));
    }

    @Override
    public String viewHistory(boolean limitRecent) {
        List<String> historyelements = new ArrayList<>();
        if (limitRecent) {
            for (DateTimeOperation so : this.calculatorSession.getRecentHistory()) {
                historyelements.add(so.toString());
            }
        } else {
            for (DateTimeOperation so : this.calculatorSession.getHistory()) {
                historyelements.add(so.toString());
            }
        }
        return String.join("\n", historyelements);
    }

    private String performOperation(Integer operationOption, List<Object> inputs) {
        Operation operation = this.operationFactory.getOperation(operationOption, inputs);
        String result = operation.operate().getResult();
        OperationTransaction ot = new OperationTransaction(operation.getName(), inputs, result);
        this.calculatorSession.save(ot);
        return result;
    }
}
