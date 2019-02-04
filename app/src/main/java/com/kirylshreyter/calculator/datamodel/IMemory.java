package com.kirylshreyter.calculator.datamodel;

import com.kirylshreyter.calculator.exceptions.DivisionByZeroException;
import com.kirylshreyter.calculator.exceptions.MalformedExpressionException;

/**
 * Main Interface to implement embedded calculation logic. Simulate native calculator memory.
 */
public interface IMemory {
    /**
     * Adds an {@link IOperand} to embedded memory.
     *
     * @param operand an {@link IOperand} to add to stack.
     * @return {@link IDisplayResult}
     */
    IDisplayResult add(IOperand operand);

    /**
     * Adds an {@link IOperator} to embedded memory.
     *
     * @param operator an {@link IOperator} to add to stack.
     * @return {@link IDisplayResult}
     */
    IDisplayResult add(IOperator operator);

    /**
     * Returns a human-readable representation of embedded memory.
     *
     * @return {@link IDisplayResult}
     * @throws {@link MalformedExpressionException}, {@link DivisionByZeroException}
     */
    IDisplayResult result() throws MalformedExpressionException, DivisionByZeroException;

    /**
     * Clears the embedded memory.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult clear();

    /**
     * Removes the last element from the embedded memory.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult removeLastElement();

    /**
     * Switch the sign of the last element from the embedded memory.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult switchSign();
}
