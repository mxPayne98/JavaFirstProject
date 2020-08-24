package com.sapient.pjp2.model;

import java.time.LocalDate;

public class Transaction {
    private String transactionID;
    private String clientID;
    private String securityID;
    private int type;
    private LocalDate date;
    private long marketValue;
    boolean priority;
    private Integer processingFee;

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getSecurityID() {
        return securityID;
    }

    public void setSecurityID(String securityID) {
        this.securityID = securityID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(long marketValue) {
        this.marketValue = marketValue;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public Integer getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(Integer processingFee) {
        this.processingFee = processingFee;
    }

    public String getCode() {
        return this.clientID +
                "#" +
                this.securityID +
                "#" +
                this.getDate().getDayOfMonth() +
                this.getDate().getMonthValue() +
                this.getDate().getYear();
    }
}
