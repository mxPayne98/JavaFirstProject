package com.sapient.pjp2.processing;

public abstract class Processor {
    public static final int BUY = 1;
    public static final int SELL = 2;
    public static final int DEPOSIT = 3;
    public static final int WITHDRAW = 4;

    protected abstract void process();
}
