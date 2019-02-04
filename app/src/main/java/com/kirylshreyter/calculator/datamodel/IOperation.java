package com.kirylshreyter.calculator.datamodel;

/**
 * Main interface to implement for {@link IOperation}
 *
 * @param <Input>  input type for {@link IOperation}
 * @param <Output> output type for {@link IOperation}
 */
public interface IOperation<Input, Output> {
    /**
     * Perform an operation on two operands
     *
     * @param lhs {@link Input} first operand
     * @param rhs {@link Input} second operand
     * @return {@link Output} result of performing action
     */
    Output perform(Input lhs, Input rhs);
}
