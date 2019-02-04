package com.kirylshreyter.calculator.factories;

import com.kirylshreyter.calculator.common.Constants;
import com.kirylshreyter.calculator.datamodel.impl.IOperand;

/**
 * Factory to provide unified interface to get proper {@link IOperand}
 */
public class OperandFactory {
    /**
     * Get a proper {@link IOperand}
     *
     * @param type {@link String} type to determine initial value of {@link IOperand}
     * @return proper {@link IOperand}
     */
    public IOperand getOperand(String type) {
        switch (type) {
            case Constants.DOT:
                return new IOperand(Constants.DOT);
            case Constants.ONE:
                return new IOperand(Constants.ONE);
            case Constants.TWO:
                return new IOperand(Constants.TWO);
            case Constants.THREE:
                return new IOperand(Constants.THREE);
            case Constants.FOUR:
                return new IOperand(Constants.FOUR);
            case Constants.FIVE:
                return new IOperand(Constants.FIVE);
            case Constants.SIX:
                return new IOperand(Constants.SIX);
            case Constants.SEVEN:
                return new IOperand(Constants.SEVEN);
            case Constants.EIGHT:
                return new IOperand(Constants.EIGHT);
            case Constants.NINE:
                return new IOperand(Constants.NINE);
            case Constants.ZERO:
                return new IOperand(Constants.ZERO);
            default:
                return null;
        }
    }
}
