package com.sapient.pjp2.session;

import java.io.Serializable;
import java.util.List;

public class OperationTransaction implements Serializable {
    private String operation;
    private List<Object> inputs;
    private String output;

    public OperationTransaction() {

    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setInputs(List<Object> inputs) {
        this.inputs = inputs;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getOperation() {
        return operation;
    }

    public List<Object> getInputs() {
        return inputs;
    }

    public String getOutput() {
        return output;
    }

    public OperationTransaction(String operation, List<Object> inputs, String output) {
        this.operation = operation;
        this.inputs = inputs;
        this.output = output;
    }

    @Override
    public String toString() {
        return "{" +
                "operation='" + operation + '\'' +
                ", inputs=" + inputs +
                ", output='" + output + '\'' +
                '}';
    }

}
