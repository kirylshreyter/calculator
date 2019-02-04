package com.kirylshreyter.calculator.datamodel;

/**
 * Main interface to implement the {@link IOperator}.
 */
public interface IOperator extends ILogic {
    /**
     * Priority of {@link IOperator}
     *
     * @return {@link Integer}
     */
    Integer priority();

    /**
     * Perform an operation on two operands
     *
     * @param lhs {@link String} first operand
     * @param rhs {@link String} second operand
     * @return {@link String} result of performing action
     */
    String perform(String lhs, String rhs);
}
