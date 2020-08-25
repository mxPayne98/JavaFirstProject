package com.sapient.pjp2.processing;

public abstract class Processor {
    public static final int BUY = 1;
    public static final int SELL = 1;
    public static final int DEPOSIT = 1;
    public static final int WITHDRAW = 1;

    protected abstract void process();
}
