package com.sapient.pjp2;

import java.io.File;

public interface ReportGenerator {
    public void readTransactions(File file);

    public void generateReport();
}
