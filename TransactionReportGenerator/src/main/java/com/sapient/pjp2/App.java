package com.sapient.pjp2;

import com.sapient.pjp2.io.TransactionIO;
import com.sapient.pjp2.io.TransactionIOCSV;
import com.sapient.pjp2.model.Transaction;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class App {
    public static void main(String[] args) {
        TransactionIO tio = new TransactionIOCSV();
        List<Transaction> transactions = tio.read(Path.of("transactions.csv").toFile());
        ReportGenerator generator = new TransactionReportGenerator(transactions, tio);
        File report = generator.generateTransactionReport();
    }
}
