package com.kirylshreyter.calculator.datamodel;

/**
 * Main interface to implement to provide updated display result.
 */
public interface IDisplayResult {

    /**
     * Method returns result to display.
     *
     * @return {@link String}
     */
    String getValue();
}
