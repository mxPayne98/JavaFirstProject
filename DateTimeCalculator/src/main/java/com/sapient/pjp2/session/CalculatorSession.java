package com.sapient.pjp2.session;

import java.util.List;

public interface CalculatorSession {
    public void save(OperationTransaction transaction);

    public void clear();

    public List<DateTimeOperation> getHistory();

    public List<DateTimeOperation> getRecentHistory();

    public DateTimeOperation lastOperation();
}
