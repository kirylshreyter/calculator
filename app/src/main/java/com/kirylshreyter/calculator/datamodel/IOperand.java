package com.kirylshreyter.calculator.datamodel;

/**
 * Main interface to implement the {@link IOperand}.
 */
public interface IOperand extends ILogic {

    /**
     * Switch the sign of {@link IOperand}
     */
    void switchSign();
}
