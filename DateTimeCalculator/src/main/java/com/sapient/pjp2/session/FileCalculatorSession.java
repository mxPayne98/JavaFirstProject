package com.sapient.pjp2.session;

import com.sapient.pjp2.io.JSONReaderWriter;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FileCalculatorSession implements CalculatorSession {
    private Queue<DateTimeOperation> history;
    private static final int CAPACITY = 100;
    private final JSONReaderWriter jsonReaderWriter;

    public FileCalculatorSession() {
        this.history = new LinkedList<>();
        this.jsonReaderWriter = new JSONReaderWriter("./history_dumps.json");
    }

    /**
     * Only maintains last n (=CAPACITY) records in memory.
     * Writes operations to JSON file.
     *
     * @param transaction The operation executed.
     */
    public void save(OperationTransaction transaction) {
        if (this.history.size() == CAPACITY) {
            this.history.remove();
        }
        DateTimeOperation dateTimeOperation = new DateTimeOperation(transaction);
        this.history.add(dateTimeOperation);
        this.jsonReaderWriter.write(dateTimeOperation);
    }

    public void clear() {
        this.history = new LinkedList<>();
    }

    public List<DateTimeOperation> getHistory() {
        return this.jsonReaderWriter.read();
    }

    public List<DateTimeOperation> getRecentHistory() {
        return List.copyOf(this.history);
    }
}
