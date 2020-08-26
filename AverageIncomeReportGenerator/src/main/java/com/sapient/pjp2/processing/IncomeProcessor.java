package com.sapient.pjp2.processing;

import com.sapient.pjp2.model.IncomeEntry;
import com.sapient.pjp2.model.ReportObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IncomeProcessor extends Processor {

    private class Pair {
        List<Double> maleIncomes;
        List<Double> femaleIncomes;

        public Pair() {
            this.maleIncomes = new ArrayList<>();
            this.femaleIncomes = new ArrayList<>();
        }
    }

    private final Map<String, Pair> incomeMap;

    protected IncomeProcessor() {
        this.incomeMap = new HashMap<>();
    }

    @Override
    protected List<ReportObject> process(List<IncomeEntry> entries) {
        populateMap(entries);
        List<ReportObject> reportObjects = new ArrayList<>();
        for (String key : this.incomeMap.keySet()) {
            Pair pair = this.incomeMap.get(key);
            ReportObject male = makeReportObject(key, "M", pair.maleIncomes);
            ReportObject female = makeReportObject(key, "F", pair.femaleIncomes);
            if (male != null) reportObjects.add(male);
            if (female != null) reportObjects.add(female);
        }
        return reportObjects;
    }

    private ReportObject makeReportObject(String cName, String gender, List<Double> incomeList) {
        Double average = calculateAverage(incomeList);
        if (average != null) {
            ReportObject reportObject = new ReportObject();
            reportObject.setcName(cName);
            reportObject.setGender(gender);
            reportObject.setAvgIncome(average);
            return reportObject;
        }
        return null;
    }

    private Double calculateAverage(List<Double> list) {
        if (list.isEmpty()) return null;
        return list.stream().mapToDouble(x -> x).average().getAsDouble();
    }

    private void populateMap(List<IncomeEntry> entries) {
        for (IncomeEntry entry : entries) {
            String key = entry.getCountry().orElse(entry.getCity());
            Pair pair = incomeMap.get(key);
            if (pair == null) {
                pair = new Pair();
                incomeMap.put(key, pair);
            }
            addIncome(entry, pair);
        }
    }

    private void addIncome(IncomeEntry entry, Pair pair) {
        double convertedIncome = getConvertedIncome(entry);
        if (entry.getGender() == IncomeEntry.GENDER.MALE) {
            pair.maleIncomes.add(convertedIncome);
        } else {
            pair.femaleIncomes.add(convertedIncome);
        }
    }

    private double getConvertedIncome(IncomeEntry entry) {
        return entry.getAverageIncome() / conversionRate.get(entry.getCurrency());
    }

}
