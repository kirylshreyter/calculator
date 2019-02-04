package com.kirylshreyter.calculator.datamodel.impl;

import com.kirylshreyter.calculator.datamodel.IDisplayResult;

/**
 * Main implementation of {@link IDisplayResult} interface.
 */
public class DisplayResult implements IDisplayResult {
    private String value;

    public DisplayResult(String value) {
        this.value = value;
    }

    @Override
    public void value(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return this.value;
    }
}
