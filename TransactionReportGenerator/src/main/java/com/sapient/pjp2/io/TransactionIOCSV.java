package com.sapient.pjp2.io;

import com.sapient.pjp2.model.Transaction;

import java.io.File;
import java.util.List;

public class TransactionIOCSV implements TransactionIO {
    @Override
    public List<Transaction> read(File file) {
        return null;
    }

    @Override
    public File write(List<Transaction> transactions) {
        return null;
    }
}
