package com.sapient.pjp2.io;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.sapient.pjp2.model.IncomeEntry;
import com.sapient.pjp2.model.ReportObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIOCSV implements FileIO {

    @Override
    public List<IncomeEntry> read(String path) {
        File file = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(file));
             CSVReader csvReader = new CSVReader(br)) {
            List<IncomeEntry> entries = new ArrayList<>();
            String[] line = csvReader.readNext(); //col titles ignored
            while ((line = csvReader.readNext()) != null) {
                IncomeEntry t = new IncomeEntry();
                t.setCity(line[0]);
                t.setCountry(line[1]);
                t.setGender(line[2]);
                t.setCurrency(line[3]);
                t.setAverageIncome(Double.parseDouble(line[4]));
                entries.add(t);
            }
            return entries;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public File write(List<ReportObject> entries, String path) {
        File file = new File(path);
        try {
            file.createNewFile();
            CSVWriter writer = new CSVWriter(
                    new FileWriter(file),
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.NO_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END
            );
            entries.sort((a, b) -> {
                if (!a.getcName().equals(b.getcName())) {
                    return a.getcName().compareTo(b.getcName());
                } else if (!a.getGender().equals(b.getGender())) {
                    return a.getGender().compareTo(b.getGender());
                } else {
                    return Double.compare(a.getAvgIncome(), b.getAvgIncome());
                }
            });
            generateCSV(entries, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private void generateCSV(List<ReportObject> entries, CSVWriter writer) {
        String[] array = new String[3];
        array[0] = "City/Country";
        array[1] = "Gender";
        array[2] = "Average Income(in USD)";
        writer.writeNext(array);
        for (var e : entries) {
            array = new String[3];
            array[0] = e.getcName();
            array[1] = e.getGender();
            array[2] = String.valueOf(e.getAvgIncome());
            writer.writeNext(array);
        }
    }
}
