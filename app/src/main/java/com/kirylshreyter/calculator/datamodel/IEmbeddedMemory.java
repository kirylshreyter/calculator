package com.kirylshreyter.calculator.datamodel;

import java.util.List;

/**
 * Main interface to implement embedded memory of calculator. Just a wrapper on {@link List}
 *
 * @param <T> type of elements
 */
public interface IEmbeddedMemory<T> extends List<T> {
    /**
     * Returns result of embedded memory.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult result();
}
