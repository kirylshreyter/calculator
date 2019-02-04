package com.kirylshreyter.calculator.datamodel.impl;

import com.kirylshreyter.calculator.common.Constants;
import com.kirylshreyter.calculator.datamodel.ICalculator;
import com.kirylshreyter.calculator.datamodel.IDisplayResult;
import com.kirylshreyter.calculator.datamodel.IMemory;
import com.kirylshreyter.calculator.exceptions.DivisionByZeroException;
import com.kirylshreyter.calculator.exceptions.MalformedExpressionException;
import com.kirylshreyter.calculator.factories.OperandFactory;
import com.kirylshreyter.calculator.factories.OperatorFactory;

import java.util.logging.Logger;

/**
 * Main implementation of {@link ICalculator} interface.
 * <p>
 * Every method call was logged for further probably debug.
 */
public class Calculator implements ICalculator {
    private static final Logger LOGGER = Logger.getLogger(Calculator.class.toString());

    private OperandFactory operandFactory = new OperandFactory();
    private OperatorFactory operatorFactory = new OperatorFactory();
    private IMemory memory = new Memory();

    @Override
    public IDisplayResult one() {
        LOGGER.info(Constants.INVOKE_ONE_METHOD);
        return memory.add(operandFactory.getOperand(Constants.ONE));
    }

    @Override
    public IDisplayResult two() {
        LOGGER.info(Constants.INVOKE_TWO_METHOD);
        return memory.add(operandFactory.getOperand(Constants.TWO));
    }

    @Override
    public IDisplayResult three() {
        LOGGER.info(Constants.INVOKE_THREE_METHOD);
        return memory.add(operandFactory.getOperand(Constants.THREE));
    }

    @Override
    public IDisplayResult four() {
        LOGGER.info(Constants.INVOKE_FOUR_METHOD);
        return memory.add(operandFactory.getOperand(Constants.FOUR));
    }

    @Override
    public IDisplayResult five() {
        LOGGER.info(Constants.INVOKE_FIVE_METHOD);
        return memory.add(operandFactory.getOperand(Constants.FIVE));
    }

    @Override
    public IDisplayResult six() {
        LOGGER.info(Constants.INVOKE_SIX_METHOD);
        return memory.add(operandFactory.getOperand(Constants.SIX));
    }

    @Override
    public IDisplayResult seven() {
        LOGGER.info(Constants.INVOKE_SEVEN_METHOD);
        return memory.add(operandFactory.getOperand(Constants.SEVEN));
    }

    @Override
    public IDisplayResult eight() {
        LOGGER.info(Constants.INVOKE_EIGHT_METHOD);
        return memory.add(operandFactory.getOperand(Constants.EIGHT));
    }

    @Override
    public IDisplayResult nine() {
        LOGGER.info(Constants.INVOKE_NINE_METHOD);
        return memory.add(operandFactory.getOperand(Constants.NINE));
    }

    @Override
    public IDisplayResult zero() {
        LOGGER.info(Constants.INVOKE_ZERO_METHOD);
        return memory.add(operandFactory.getOperand(Constants.ZERO));
    }

    @Override
    public IDisplayResult dot() {
        LOGGER.info(Constants.INVOKE_DOT_METHOD);
        return memory.add(operandFactory.getOperand(Constants.DOT));
    }

    @Override
    public IDisplayResult add() {
        LOGGER.info(Constants.INVOKE_ADD_METHOD);
        return memory.add(operatorFactory.getOperator(Constants.ADDER));
    }

    @Override
    public IDisplayResult subtract() {
        LOGGER.info(Constants.INVOKE_SUBTRACT_METHOD);
        return memory.add(operatorFactory.getOperator(Constants.SUBTRACTOR));
    }

    @Override
    public IDisplayResult div() {
        LOGGER.info(Constants.INVOKE_DIV_METHOD);
        return memory.add(operatorFactory.getOperator(Constants.DIVIDER));
    }

    @Override
    public IDisplayResult multiply() {
        LOGGER.info(Constants.INVOKE_MULTIPLY_METHOD);
        return memory.add(operatorFactory.getOperator(Constants.MULTIPLIER));
    }

    @Override
    public IDisplayResult result() throws MalformedExpressionException, DivisionByZeroException {
        LOGGER.info(Constants.INVOKE_RESULT_METHOD);
        return memory.result();
    }

    @Override
    public IDisplayResult reset() {
        LOGGER.info(Constants.INVOKE_RESET_METHOD);
        return memory.clear();
    }

    @Override
    public IDisplayResult removeLastElement() {
        LOGGER.info(Constants.INVOKE_REMOVE_LAST_ELEMENT_METHOD);
        return memory.removeLastElement();
    }

    @Override
    public IDisplayResult switchSign() {
        LOGGER.info(Constants.INVOKE_SWITCH_SIGN_METHOD);
        return memory.switchSign();
    }
}
