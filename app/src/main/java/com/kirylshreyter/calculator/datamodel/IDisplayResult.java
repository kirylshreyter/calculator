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
    String value();

    /**
     * Set the result string to display.
     *
     * @param value should be a {@link String}.
     */
    void value(String value);
}
