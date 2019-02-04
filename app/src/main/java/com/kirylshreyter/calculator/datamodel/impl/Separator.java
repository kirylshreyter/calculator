package com.kirylshreyter.calculator.datamodel.impl;

import com.kirylshreyter.calculator.common.Constants;
import com.kirylshreyter.calculator.datamodel.ISeparator;

/**
 * Main implementation of {@link ISeparator}
 */
public class Separator implements ISeparator {
    @Override
    public Boolean isSeparator() {
        return true;
    }

    @Override
    public String value() {
        return Constants.EMPTY_STRING;
    }

    @Override
    public Boolean isOperator() {
        return false;
    }

    @Override
    public Boolean isOperand() {
        return false;
    }

    @Override
    public Boolean isDot() {
        return false;
    }
}
