package com.sapient.pjp2.session;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "date_time_operation")
public class DateTimeOperation implements Serializable {
    private OperationTransaction transaction;
    private String timeStamp;
    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public DateTimeOperation() {

    }

    public DateTimeOperation(OperationTransaction transaction) {
        this.transaction = transaction;
        this.timeStamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public void setTransaction(OperationTransaction transaction) {
        this.transaction = transaction;
    }

    @Column(name = "time_stamp", nullable = false)
    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operation_transaction_id")
    public OperationTransaction getTransaction() {
        return transaction;
    }

    @Override
    public String toString() {
        return "transaction=" + transaction + ", timeStamp=" + timeStamp;
    }

    public void setId(int id) {
        this.id = id;
    }

}
