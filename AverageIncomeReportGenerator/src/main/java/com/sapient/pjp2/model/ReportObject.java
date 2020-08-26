package com.sapient.pjp2.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReportObject {
    private String cName;
    private String gender;
    private double avgIncome;

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getAvgIncome() {
        return avgIncome;
    }

    public void setAvgIncome(double avgIncome) {
        this.avgIncome = new BigDecimal(avgIncome).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
