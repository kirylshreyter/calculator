package com.kirylshreyter.calculator.common;

import com.google.common.collect.Iterables;
import com.kirylshreyter.calculator.datamodel.IDisplayResult;
import com.kirylshreyter.calculator.datamodel.IEmbeddedMemory;
import com.kirylshreyter.calculator.datamodel.ILogic;
import com.kirylshreyter.calculator.datamodel.IOperand;
import com.kirylshreyter.calculator.datamodel.ISeparator;
import com.kirylshreyter.calculator.datamodel.impl.DisplayResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class to provide additional functionality to extend native Java-functionality of {@link List}.
 */
public class ListUtils {
    private static final ListUtils INSTANCE = new ListUtils();

    private ListUtils() {
    }

    /**
     * Returns a singleton-object of {@link ListUtils}
     *
     * @return {@link ListUtils}
     */
    public static ListUtils getInstance() {
        return INSTANCE;
    }

    /**
     * Creates {@link DisplayResult} from the given {@link IEmbeddedMemory<? extends ILogic>} by concatenate the list in a single {@link String} using {@link StringBuilder}
     *
     * @param inputList the input {@link List<ILogic>} to present.
     * @return {@link IDisplayResult}
     */
    public IDisplayResult listToDisplayResult(IEmbeddedMemory<? extends ILogic> inputList) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < inputList.size(); i++) {
            builder.append(inputList.get(i).value());
        }
        return new DisplayResult(builder.toString());
    }

    /**
     * Replace the last element of {@link List<ILogic>} with given {@link ILogic}.
     *
     * @param element  the {@link ILogic} element to replace.
     * @param elements the input {@link List<ILogic>}
     */
    public void setLast(ILogic element, List<ILogic> elements) {
        elements.set(elements.size() - 1, element);
    }

    /**
     * Gets the last index of {@link ISeparator} from {@link List<ILogic>}.
     *
     * @param elements {@link List<ILogic>} to scan
     * @return {@link Integer}
     */
    public Integer getLastIndexOfSeparator(List<ILogic> elements) {
        if (elements.isEmpty()) return 0;

        List<Integer> indexes = new ArrayList<>();
        for (ILogic element : elements) {
            if (element.isSeparator()) {
                indexes.add(elements.indexOf(element));
            }
        }

        if (indexes.isEmpty()) return 0;

        Collections.sort(indexes);
        return Iterables.getLast(indexes);
    }

    /**
     * Gets the index of last element of {@link List<ILogic>}.
     *
     * @param elements {@link List<ILogic>} to scan.
     * @return {@link Integer}
     */
    public Integer getLastElementIndex(List<ILogic> elements) {
        if (elements.isEmpty()) return 0;

        return elements.indexOf(Iterables.getLast(elements));
    }

    /**
     * Identification if {@link List<ILogic>} contains element which is Dot(Comma).
     *
     * @param elements {@link List<ILogic>} to scan
     * @return {@link Boolean}
     */
    public Boolean containsDot(List<ILogic> elements) {
        for (ILogic element : elements) {
            if (element.isDot()) return true;
        }
        return false;
    }

    /**
     * Returns the next index of {@link ISeparator} in {@code elements}
     *
     * @param startIndex index to start to scan
     * @param elements   to scan
     * @return {@link Integer} index of found element.
     */
    public Integer getNextIndexOfSeparator(Integer startIndex, List<ILogic> elements) {
        if (elements.isEmpty()) return 0;

        for (int i = startIndex; i < elements.size(); i++) {
            if (elements.get(i).isSeparator()) return i;
        }
        return elements.size() - 1;
    }

    /**
     * Returns index of first occurrence of {@link IOperand} in {@code elements}
     *
     * @param lastIndex index to start to scan
     * @param elements  to scan
     * @return {@link Integer} index of found element.
     */
    public Integer getFirstOperandIndex(Integer lastIndex, List<ILogic> elements) {
        for (int i = lastIndex; i >= 0; i--) {
            if (!elements.get(i).isOperand()) {
                return i + 1;
            } else if (i == 0) {
                return i;
            }
        }
        return lastIndex;
    }

    /**
     * Removes all {@link ISeparator} from {@code elements}
     *
     * @param elements to clear
     */
    public void removeAllSeparators(List<ILogic> elements) {
        List<ILogic> elementsToDelete = new ArrayList<>();
        for (ILogic element : elements) {
            if (element.isSeparator()) elementsToDelete.add(element);
        }
        elements.removeAll(elementsToDelete);
    }
}
