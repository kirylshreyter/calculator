package com.kirylshreyter.calculator.exceptions;

import com.kirylshreyter.calculator.common.Constants;

/**
 * Exception class which throw when malformed expression was given
 */
public class MalformedExpressionException extends RuntimeException {
    /**
     * Main constructor for {@link MalformedExpressionException}
     */
    public MalformedExpressionException() {
        super(Constants.MALFORMED_EXPRESSION_EXCEPTION_MSG);
    }
}
