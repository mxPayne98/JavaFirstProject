package com.sapient.pjp2.processing;

import com.sapient.pjp2.model.IncomeEntry;
import com.sapient.pjp2.model.ReportObject;

import java.util.List;
import java.util.Map;

public abstract class Processor {
    public static final Map<String, Double> conversionRate = Map.ofEntries(
            Map.entry("INR", 66.0),
            Map.entry("GBP", 0.67),
            Map.entry("SGD", 1.5),
            Map.entry("HKD", 8.0),
            Map.entry("USD", 1.0)
    );

    protected abstract List<ReportObject> process(List<IncomeEntry> entries);
}
