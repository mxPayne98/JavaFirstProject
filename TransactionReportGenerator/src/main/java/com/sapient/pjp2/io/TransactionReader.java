package com.sapient.pjp2.io;

import com.sapient.pjp2.model.Transaction;

import java.io.File;
import java.util.List;

public interface TransactionReader {
    public List<Transaction> read(File file);
}
