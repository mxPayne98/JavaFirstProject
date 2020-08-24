package com.sapient.pjp2.processing;

public abstract class Processor {
    int BUY = 1;
    int SELL = 1;
    int DEPOSIT = 1;
    int WITHDRAW = 1;

    protected abstract void process();
}
