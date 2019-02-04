package com.kirylshreyter.calculator.datamodel.impl;

import com.kirylshreyter.calculator.datamodel.IOperation;
import com.kirylshreyter.calculator.datamodel.IOperator;

/**
 * Main implementation of {@link IOperator}
 */
public class Operator implements IOperator {
    private String value;
    private Integer priority;
    private IOperation<String, String> operation;

    /**
     * Main constructor for {@link IOperator}
     *
     * @param priority     {@link Integer} priority for {@link IOperator}
     * @param initialValue {@link String} initial value for {@link IOperator}
     * @param operation    {@link IOperation} operation for {@link IOperator}
     */
    public Operator(Integer priority, String initialValue, IOperation<String, String> operation) {
        this.priority = priority;
        this.value = initialValue;
        this.operation = operation;
    }

    @Override
    public Integer priority() {
        return this.priority;
    }

    @Override
    public String perform(String lhs, String rhs) {
        return operation.perform(lhs, rhs);
    }

    @Override
    public String value() {
        return this.value;
    }

    @Override
    public Boolean isOperator() {
        return true;
    }

    @Override
    public Boolean isOperand() {
        return false;
    }

    @Override
    public Boolean isSeparator() {
        return false;
    }

    @Override
    public Boolean isDot() {
        return false;
    }
}
