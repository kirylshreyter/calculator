package com.kirylshreyter.calculator.datamodel;

/**
 * Common interface to implement for basic object of calculator.
 */
public interface ILogic {
    /**
     * Returns value of {@link ILogic}
     *
     * @return {@link String}
     */
    String value();

    /**
     * Determines if current object is {@link IOperator}
     *
     * @return {@link Boolean}
     */
    Boolean isOperator();

    /**
     * Determines if current object is {@link IOperand}
     *
     * @return {@link Boolean}
     */
    Boolean isOperand();

    /**
     * Determines if current object is {@link ISeparator}
     *
     * @return {@link Boolean}
     */
    Boolean isSeparator();

    /**
     * Determines if current object is a dot
     *
     * @return {@link Boolean}
     */
    Boolean isDot();
}
