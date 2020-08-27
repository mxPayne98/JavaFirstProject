package com.sapient.pjp2.session;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "operation_transaction")
public class OperationTransaction implements Serializable {
    private int id;
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

    @Column(name = "operation", nullable = false)
    public String getOperation() {
        return operation;
    }

    @Column(name = "inputs", nullable = false)
    @Convert(converter = InputListConverter.class)
    public List<Object> getInputs() {
        return inputs;
    }

    @Column(name = "output", nullable = false)
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
        return "{" + "operation='" + operation + '\'' +
                ", input(s)=" + inputs +
                ", output='" + output + "}";
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
}
