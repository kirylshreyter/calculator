package com.kirylshreyter.calculator.datamodel.impl;

import android.util.Log;

import com.kirylshreyter.calculator.common.Constants;
import com.kirylshreyter.calculator.common.LoggerTags;
import com.kirylshreyter.calculator.datamodel.ICalculator;
import com.kirylshreyter.calculator.datamodel.IDisplayResult;
import com.kirylshreyter.calculator.datamodel.IMemory;
import com.kirylshreyter.calculator.exceptions.DivisionByZeroException;
import com.kirylshreyter.calculator.exceptions.MalformedExpressionException;
import com.kirylshreyter.calculator.factories.OperandFactory;
import com.kirylshreyter.calculator.factories.OperatorFactory;

/**
 * Main implementation of {@link ICalculator} interface.
 * <p>
 * Every method call was logged for further probably debug.
 */
public class Calculator implements ICalculator {
    private OperandFactory operandFactory = new OperandFactory();
    private OperatorFactory operatorFactory = new OperatorFactory();
    private IMemory memory = new Memory();

    @Override
    public IDisplayResult one() {
        Log.d(LoggerTags.METHOD_INVOCATION.name(), Constants.INVOKE_ONE_METHOD);
        return memory.add(operandFactory.getOperand(Constants.ONE));
    }

    @Override
    public IDisplayResult two() {
        Log.d(LoggerTags.METHOD_INVOCATION.name(), Constants.INVOKE_TWO_METHOD);
        return memory.add(operandFactory.getOperand(Constants.TWO));
    }

    @Override
    public IDisplayResult three() {
        Log.d(LoggerTags.METHOD_INVOCATION.name(), Constants.INVOKE_THREE_METHOD);
        return memory.add(operandFactory.getOperand(Constants.THREE));
    }

    @Override
    public IDisplayResult four() {
        Log.d(LoggerTags.METHOD_INVOCATION.name(), Constants.INVOKE_FOUR_METHOD);
        return memory.add(operandFactory.getOperand(Constants.FOUR));
    }

    @Override
    public IDisplayResult five() {
        Log.d(LoggerTags.METHOD_INVOCATION.name(), Constants.INVOKE_FIVE_METHOD);
        return memory.add(operandFactory.getOperand(Constants.FIVE));
    }

    @Override
    public IDisplayResult six() {
        Log.d(LoggerTags.METHOD_INVOCATION.name(), Constants.INVOKE_SIX_METHOD);
        return memory.add(operandFactory.getOperand(Constants.SIX));
    }

    @Override
    public IDisplayResult seven() {
        Log.d(LoggerTags.METHOD_INVOCATION.name(), Constants.INVOKE_SEVEN_METHOD);
        return memory.add(operandFactory.getOperand(Constants.SEVEN));
    }

    @Override
    public IDisplayResult eight() {
        Log.d(LoggerTags.METHOD_INVOCATION.name(), Constants.INVOKE_EIGHT_METHOD);
        return memory.add(operandFactory.getOperand(Constants.EIGHT));
    }

    @Override
    public IDisplayResult nine() {
        Log.d(LoggerTags.METHOD_INVOCATION.name(), Constants.INVOKE_NINE_METHOD);
        return memory.add(operandFactory.getOperand(Constants.NINE));
    }

    @Override
    public IDisplayResult zero() {
        Log.d(LoggerTags.METHOD_INVOCATION.name(), Constants.INVOKE_ZERO_METHOD);
        return memory.add(operandFactory.getOperand(Constants.ZERO));
    }

    @Override
    public IDisplayResult dot() {
        Log.d(LoggerTags.METHOD_INVOCATION.name(), Constants.INVOKE_DOT_METHOD);
        return memory.add(operandFactory.getOperand(Constants.DOT));
    }

    @Override
    public IDisplayResult add() {
        Log.d(LoggerTags.METHOD_INVOCATION.name(), Constants.INVOKE_ADD_METHOD);
        return memory.add(operatorFactory.getOperator(Constants.ADDER));
    }

    @Override
    public IDisplayResult subtract() {
        Log.d(LoggerTags.METHOD_INVOCATION.name(), Constants.INVOKE_SUBTRACT_METHOD);
        return memory.add(operatorFactory.getOperator(Constants.SUBTRACTOR));
    }

    @Override
    public IDisplayResult div() {
        Log.d(LoggerTags.METHOD_INVOCATION.name(), Constants.INVOKE_DIV_METHOD);
        return memory.add(operatorFactory.getOperator(Constants.DIVIDER));
    }

    @Override
    public IDisplayResult multiply() {
        Log.d(LoggerTags.METHOD_INVOCATION.name(), Constants.INVOKE_MULTIPLY_METHOD);
        return memory.add(operatorFactory.getOperator(Constants.MULTIPLIER));
    }

    @Override
    public IDisplayResult result() throws MalformedExpressionException, DivisionByZeroException {
        Log.d(LoggerTags.METHOD_INVOCATION.name(), Constants.INVOKE_RESULT_METHOD);
        return memory.result();
    }

    @Override
    public IDisplayResult reset() {
        Log.d(LoggerTags.METHOD_INVOCATION.name(), Constants.INVOKE_RESET_METHOD);
        return memory.clear();
    }

    @Override
    public IDisplayResult removeLastElement() {
        Log.d(LoggerTags.METHOD_INVOCATION.name(), Constants.INVOKE_REMOVE_LAST_ELEMENT_METHOD);
        return memory.removeLastElement();
    }

    @Override
    public IDisplayResult switchSign() {
        Log.d(LoggerTags.METHOD_INVOCATION.name(), Constants.INVOKE_SWITCH_SIGN_METHOD);
        return memory.switchSign();
    }
}
