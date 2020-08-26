package com.sapient.pjp2.model;

import java.util.Optional;

public class IncomeEntry {
    public enum GENDER {
        MALE,
        FEMALE
    }

    private String city;
    private String country;
    private GENDER gender;
    private String currency;
    private double averageIncome;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Optional<String> getCountry() {
        return Optional.ofNullable(country);
    }

    public void setCountry(String country) {
        if (country.isBlank()) this.country = null;
        else this.country = country;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender.equals("M") ? GENDER.MALE : GENDER.FEMALE;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAverageIncome() {
        return averageIncome;
    }

    public void setAverageIncome(double averageIncome) {
        this.averageIncome = averageIncome;
    }
}
