package com.kirylshreyter.calculator.datamodel.impl;

import com.kirylshreyter.calculator.common.Constants;
import com.kirylshreyter.calculator.datamodel.IOperand;

import java.util.LinkedList;
import java.util.List;

/**
 * Main implementation of {@link com.kirylshreyter.calculator.datamodel.IOperand}
 */
public class IOperand implements com.kirylshreyter.calculator.datamodel.IOperand {
    private List<String> memory = new LinkedList<>();

    public IOperand(String initialValue) {
        memory.add(initialValue);
    }

    @Override
    public String value() {
        StringBuilder builder = new StringBuilder();
        for (String element : memory) {
            builder.append(element);
        }
        return builder.toString();
    }

    @Override
    public Boolean isOperator() {
        return false;
    }

    @Override
    public Boolean isOperand() {
        return true;
    }

    @Override
    public Boolean isSeparator() {
        return false;
    }

    @Override
    public Boolean isDot() {
        return this.value().equals(Constants.DOT);
    }

    @Override
    public void switchSign() {
        if (memory.get(0).equals(Constants.SUBTRACTOR)) {
            memory.remove(0);
            return;
        }
        memory.add(0, Constants.SUBTRACTOR);
    }
}
