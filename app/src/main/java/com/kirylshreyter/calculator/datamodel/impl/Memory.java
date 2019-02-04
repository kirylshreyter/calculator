package com.kirylshreyter.calculator.datamodel.impl;

import com.google.common.collect.Iterables;
import com.kirylshreyter.calculator.common.ListUtils;
import com.kirylshreyter.calculator.datamodel.IDisplayResult;
import com.kirylshreyter.calculator.datamodel.IEmbeddedMemory;
import com.kirylshreyter.calculator.datamodel.ILogic;
import com.kirylshreyter.calculator.datamodel.IMemory;
import com.kirylshreyter.calculator.datamodel.IOperator;
import com.kirylshreyter.calculator.exceptions.DivisionByZeroException;
import com.kirylshreyter.calculator.exceptions.MalformedExpressionException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Main implementation of {@link IMemory}.
 */
public class Memory implements IMemory {
    private IEmbeddedMemory<ILogic> embeddedMemory = new EmbeddedMemory<>();
    private ListUtils utils = ListUtils.getInstance();

    @Override
    public IDisplayResult add(com.kirylshreyter.calculator.datamodel.IOperand operand) {
        if (!operand.isDot() || !utils.containsDot(listToScan(embeddedMemory))) {
            embeddedMemory.add(operand);
        }
        return embeddedMemory.result();
    }

    @Override
    public IDisplayResult add(IOperator operator) {
        if (embeddedMemory.isEmpty()) return embeddedMemory.result();

        ILogic element = Iterables.getLast(embeddedMemory);

        if (element.isOperand()) {
            embeddedMemory.add(new Separator());
            embeddedMemory.add(operator);
        }

        if (element.isOperator()) utils.setLast(operator, embeddedMemory);

        return embeddedMemory.result();
    }

    @Override
    public IDisplayResult result() throws MalformedExpressionException, DivisionByZeroException {
        embeddedMemory.add(new Separator());
        embeddedMemory = convertToStringRepresentation(embeddedMemory);

        List<ILogic> output = new ArrayList<>();
        Stack<IOperator> stack = new Stack<>();

        for (int count = 0; count < embeddedMemory.size(); count++) {
            ILogic element = embeddedMemory.get(count);

            if (element.isOperand()) {
                output.add(element);
            } else if (element.isOperator()) {
                if (stack.empty() || (stack.peek().priority() < ((IOperator) element).priority())) {
                    stack.push((IOperator) element);
                    continue;
                }
                while (!stack.empty() && (stack.peek().priority() >= ((IOperator) element).priority())) {
                    output.add(stack.pop());
                }
                stack.push((IOperator) element);
            }
        }

        while (!stack.empty()) {
            output.add(stack.pop());
        }

        if (output.size() % 2 == 0)
            throw new MalformedExpressionException();

        if (output.size() == 1) return embeddedMemory.result();

        utils.removeAllSeparators(output);

        embeddedMemory = applyOperations(output);

        return embeddedMemory.result();
    }

    @Override
    public IDisplayResult clear() {
        embeddedMemory.clear();
        return embeddedMemory.result();
    }

    @Override
    public IDisplayResult removeLastElement() {
        if (embeddedMemory.isEmpty()) return embeddedMemory.result();
        embeddedMemory.remove(Iterables.getLast(embeddedMemory));
        return embeddedMemory.result();
    }

    @Override
    public IDisplayResult switchSign() {
        if (!embeddedMemory.isEmpty() && Iterables.getLast(embeddedMemory).isOperand()) {
            Integer switchIndex = utils.getFirstOperandIndex(embeddedMemory.indexOf(Iterables.getLast(embeddedMemory)), embeddedMemory);
            ((com.kirylshreyter.calculator.datamodel.IOperand) embeddedMemory.get(switchIndex)).switchSign();
        }

        return embeddedMemory.result();
    }

    private List<ILogic> listToScan(IEmbeddedMemory<ILogic> elements) {
        if (elements.isEmpty()) return elements;

        Integer startIndexToScan = utils.getLastIndexOfSeparator(elements);
        Integer lastIndexToScan = utils.getLastElementIndex(elements);
        return elements.subList(startIndexToScan + 1, lastIndexToScan + 1);
    }

    private IEmbeddedMemory<ILogic> applyOperations(List<ILogic> elements) {
        List<String> tempResult = new ArrayList<>();
        for (ILogic element : elements) {
            if (element.isOperand()) {
                tempResult.add(element.value());
            } else if (element.isOperator()) {
                List<String> tail = tempResult.subList(tempResult.size() - 2, tempResult.size());
                String sum = ((Operator) element).perform(tail.get(0), tail.get(1));
                tempResult.removeAll(tail);
                tempResult.add(sum);
            }
        }

        IEmbeddedMemory<ILogic> result = new EmbeddedMemory<>();
        result.add(new IOperand(Iterables.getLast(tempResult)));

        return result;
    }

    private IEmbeddedMemory<ILogic> convertToStringRepresentation(IEmbeddedMemory<ILogic> elements) {
        IEmbeddedMemory<ILogic> result = new EmbeddedMemory<>();

        for (int i = 0; i < elements.size(); i++) {
            ILogic element = elements.get(i);

            if (element.isOperand()) {
                int nextIndex = utils.getNextIndexOfSeparator(i, elements);
                result.add(operandFromElements(elements.subList(i, nextIndex)));
                i = nextIndex;
            } else if (element.isOperator()) {
                result.add(new Separator());
                result.add(element);
            }
        }

        return result;
    }

    private com.kirylshreyter.calculator.datamodel.IOperand operandFromElements(List<ILogic> elements) {
        StringBuilder builder = new StringBuilder();

        for (ILogic element : elements) {
            builder.append(element.value());
        }

        return new IOperand(builder.toString());
    }
}