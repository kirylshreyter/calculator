package com.kirylshreyter.calculator.exceptions;

import com.kirylshreyter.calculator.common.Constants;

/**
 * Exception class which throw when tried to divide by zero.
 */
public class DivisionByZeroException extends RuntimeException {
    /**
     * Main constructor for {@link DivisionByZeroException}
     */
    public DivisionByZeroException() {
        super(Constants.DIVISION_BY_ZERO_EXCEPTION_MSG);
    }
}
