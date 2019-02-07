package com.kirylshreyter.calculator.factories;

import com.kirylshreyter.calculator.common.Constants;
import com.kirylshreyter.calculator.datamodel.IOperand;
import com.kirylshreyter.calculator.datamodel.impl.Operand;

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
                return new Operand(Constants.DOT);
            case Constants.ONE:
                return new Operand(Constants.ONE);
            case Constants.TWO:
                return new Operand(Constants.TWO);
            case Constants.THREE:
                return new Operand(Constants.THREE);
            case Constants.FOUR:
                return new Operand(Constants.FOUR);
            case Constants.FIVE:
                return new Operand(Constants.FIVE);
            case Constants.SIX:
                return new Operand(Constants.SIX);
            case Constants.SEVEN:
                return new Operand(Constants.SEVEN);
            case Constants.EIGHT:
                return new Operand(Constants.EIGHT);
            case Constants.NINE:
                return new Operand(Constants.NINE);
            case Constants.ZERO:
                return new Operand(Constants.ZERO);
            default:
                return null;
        }
    }
}
