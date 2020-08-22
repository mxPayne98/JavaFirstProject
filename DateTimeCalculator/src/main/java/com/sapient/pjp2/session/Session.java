package com.sapient.pjp2.session;

import com.sapient.pjp2.io.JSONReaderWriter;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Session {
    private Queue<SessionObject> history;
    private static final int CAPACITY = 100;
    private final JSONReaderWriter jsonReaderWriter;

    public Session() {
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
        SessionObject sessionObject = new SessionObject(transaction);
        this.history.add(sessionObject);
        this.jsonReaderWriter.write(sessionObject);
    }

    public void clear() {
        this.history = new LinkedList<>();
    }

    public List<SessionObject> getHistory() {
//        return List.copyOf(this.history);
        return this.jsonReaderWriter.read();
    }
}
