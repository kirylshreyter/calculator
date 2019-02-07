package com.kirylshreyter.calculator.factories;

import com.kirylshreyter.calculator.common.Constants;
import com.kirylshreyter.calculator.common.StringUtils;
import com.kirylshreyter.calculator.datamodel.IOperand;
import com.kirylshreyter.calculator.datamodel.IOperator;
import com.kirylshreyter.calculator.datamodel.impl.Operator;
import com.kirylshreyter.calculator.exceptions.DivisionByZeroException;

/**
 * Factory to provide unified interface to get proper {@link IOperator}
 */
public class OperatorFactory {
    /**
     * Get a proper {@link IOperator}
     *
     * @param type {@link String} type to determine kind of {@link IOperator}
     * @return proper {@link IOperand}
     */
    public IOperator getOperator(String type) {
        switch (type) {
            case Constants.MULTIPLIER:
                return new Operator(3, Constants.MULTIPLIER, (lhs, rhs) -> StringUtils.fmt(Double.parseDouble(lhs) * Double.parseDouble(rhs)));
            case Constants.DIVIDER:
                return new Operator(3, Constants.DIVIDER, (lhs, rhs) -> {
                    Double divider = Double.parseDouble(rhs);
                    if (divider.equals(Double.parseDouble(Constants.ZERO))) {
                        throw new DivisionByZeroException();
                    }
                    return StringUtils.fmt(Double.parseDouble(lhs) / divider);
                });
            case Constants.ADDER:
                return new Operator(2, Constants.ADDER, (lhs, rhs) -> StringUtils.fmt(Double.parseDouble(lhs) + Double.parseDouble(rhs)));
            case Constants.SUBTRACTOR:
                return new Operator(2, Constants.SUBTRACTOR, (lhs, rhs) -> StringUtils.fmt(Double.parseDouble(lhs) - Double.parseDouble(rhs)));
            default:
                return null;
        }
    }
}
