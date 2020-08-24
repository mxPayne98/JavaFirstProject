package com.sapient.pjp2.processing;

import com.sapient.pjp2.model.Transaction;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TransactionProcessor extends Processor {

    private final Queue<Transaction> transactions;
    private final HashMap<String, Queue<Transaction>> buymap;
    private final HashMap<String, Queue<Transaction>> sellmap;

    protected TransactionProcessor(List<Transaction> transactions) {
        this.transactions = new LinkedList<>(transactions);
        this.buymap = new HashMap<>();
        this.sellmap = new HashMap<>();
    }

    @Override
    protected void process() {
        while (!this.transactions.isEmpty()) {
            Transaction t = this.transactions.poll();
            if (t.getType() == DEPOSIT || t.getType() == WITHDRAW) {
                setFee(t);
            } else if (t.getType() == BUY) {
                if (checkCounter(t, this.sellmap)) continue;
                Queue<Transaction> temp = this.buymap.getOrDefault(t.getCode(), new LinkedList<>());
                temp.add(t);
                if (!this.buymap.containsKey(t.getCode())) {
                    this.buymap.put(t.getCode(), temp);
                }
            } else if (t.getType() == SELL) {
                if (checkCounter(t, this.buymap)) continue;
                Queue<Transaction> temp = this.sellmap.getOrDefault(t.getCode(), new LinkedList<>());
                temp.add(t);
                if (!this.sellmap.containsKey(t.getCode())) {
                    this.sellmap.put(t.getCode(), temp);
                }
            }
        }
        processRemaining(this.buymap);
        processRemaining(this.sellmap);
    }

    private void processRemaining(HashMap<String, Queue<Transaction>> map) {
        for (String code : map.keySet()) {
            map.get(code).forEach(this::setFee);
        }
    }

    private boolean checkCounter(Transaction t, HashMap<String, Queue<Transaction>> map) {
        if (map.containsKey(t.getCode())) {
            Transaction counter = map.get(t.getCode()).poll();
            if (map.get(t.getCode()).isEmpty()) {
                map.remove(t.getCode());
            }
            t.setProcessingFee(10);
            counter.setProcessingFee(10);
            return true;
        }
        return false;
    }

    private void setFee(Transaction t) {
        if (t.isPriority()) {
            t.setProcessingFee(500);
        } else {
            if (t.getType() == DEPOSIT || t.getType() == BUY) {
                t.setProcessingFee(50);
            } else {
                t.setProcessingFee(100);
            }
        }
    }

}
