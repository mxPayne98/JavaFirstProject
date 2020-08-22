package com.sapient.pjp2.session;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SessionObject implements Serializable {
    private OperationTransaction transaction;
    private String timeStamp;

    public String getTimeStamp() {
        return timeStamp;
    }

    public SessionObject() {

    }

    public SessionObject(OperationTransaction transaction) {
        this.transaction = transaction;
        this.timeStamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public void setTransaction(OperationTransaction transaction) {
        this.transaction = transaction;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public OperationTransaction getTransaction() {
        return transaction;
    }

    @Override
    public String toString() {
        return "{transaction=" + transaction + ", timeStamp=" + timeStamp + "}";
    }
}
