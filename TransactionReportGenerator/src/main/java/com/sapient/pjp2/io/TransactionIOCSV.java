package com.sapient.pjp2.io;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.sapient.pjp2.model.Transaction;
import com.sapient.pjp2.processing.Processor;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TransactionIOCSV implements TransactionIO {

    private static final String DATE_PATTERN = "MM/dd/yyyy";

    @Override
    public List<Transaction> read(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file));
             CSVReader csvReader = new CSVReader(br)) {
            List<Transaction> transactions = new ArrayList<>();
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                Transaction t = new Transaction();
                t.setTransactionID(line[0]);
                t.setClientID(line[1]);
                t.setSecurityID(line[2]);
                t.setDate(LocalDate.parse(line[3], DateTimeFormatter.ofPattern(DATE_PATTERN)));
                t.setType(calculateType(line[4]));
                t.setMarketValue(Long.parseLong(line[5]));
                t.setPriority(line[6].equals("Y"));
                transactions.add(t);
            }
            return transactions;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int calculateType(String s) {
        switch (s.toLowerCase()) {
            case "buy":
                return Processor.BUY;
            case "sell":
                return Processor.SELL;
            case "withdraw":
                return Processor.WITHDRAW;
            case "deposit":
                return Processor.DEPOSIT;
        }

        return -1;
    }

    @Override
    public File write(List<Transaction> transactions) {
        File file = new File("\"transaction_report.csv\"");
        try {
            file.createNewFile();
            CSVWriter writer = new CSVWriter(new FileWriter(file));
            transactions.sort((a, b) -> {
                if (!a.getClientID().equals(b.getClientID())) {
                    return a.getClientID().compareTo(b.getClientID());
                } else if (a.getType() != b.getType()) {
                    return Integer.compare(a.getType(), b.getType());
                } else if (!a.getDate().format(DateTimeFormatter.ofPattern(DATE_PATTERN))
                        .equals(b.getDate().format(DateTimeFormatter.ofPattern(DATE_PATTERN)))) {
                    return a.getDate().format(DateTimeFormatter.ofPattern(DATE_PATTERN))
                            .compareTo(b.getDate().format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
                } else if (a.isPriority() != b.isPriority()) {
                    return Boolean.compare(a.isPriority(), b.isPriority());
                } else {
                    return Integer.compare(a.getProcessingFee(), b.getProcessingFee());
                }
            });
            for (Transaction t : transactions) {
                String[] array = new String[5];
                array[0] = t.getClientID();
                array[1] = String.valueOf(t.getType());
                array[2] = t.getDate().format(DateTimeFormatter.ofPattern(DATE_PATTERN));
                array[3] = t.isPriority() ? "Y" : "N";
                array[4] = String.valueOf(t.getProcessingFee());
                writer.writeNext(array);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
