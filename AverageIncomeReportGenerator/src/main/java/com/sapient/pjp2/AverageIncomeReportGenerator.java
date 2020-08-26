package com.sapient.pjp2;

import com.sapient.pjp2.io.FileIO;
import com.sapient.pjp2.io.FileIOCSV;
import com.sapient.pjp2.model.IncomeEntry;
import com.sapient.pjp2.model.ReportObject;
import com.sapient.pjp2.processing.IncomeProcessor;

import java.io.File;
import java.util.List;

public class AverageIncomeReportGenerator extends IncomeProcessor implements ReportGenerator {

    private final FileIO fio;
    private final String inputPath;
    private final String outputPath;

    public AverageIncomeReportGenerator(String inputPath, String outputPath) {
        this.fio = new FileIOCSV();
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }


    @Override
    public File generateIncomeReport() {
        List<IncomeEntry> entries = this.fio.read(this.inputPath);
        List<ReportObject> reportEntries = process(entries);
        return fio.write(reportEntries, this.outputPath);
    }
}
