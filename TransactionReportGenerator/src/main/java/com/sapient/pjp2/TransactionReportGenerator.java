package com.sapient.pjp2;

import com.sapient.pjp2.io.TransactionIO;
import com.sapient.pjp2.model.Transaction;
import com.sapient.pjp2.processing.TransactionProcessor;

import java.io.File;
import java.util.List;

public class TransactionReportGenerator extends TransactionProcessor implements ReportGenerator {

    private final List<Transaction> transactions;
    private final TransactionIO tio;

    public TransactionReportGenerator(List<Transaction> transactions, TransactionIO tio) {
        super(transactions);
        this.transactions = transactions;
        this.tio = tio;
    }

    @Override
    public File generateTransactionReport() {
        super.process();
        return tio.write(this.transactions);
    }
}
