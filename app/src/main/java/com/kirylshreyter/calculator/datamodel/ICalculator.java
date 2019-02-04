package com.kirylshreyter.calculator.datamodel;

import com.kirylshreyter.calculator.exceptions.MalformedExpressionException;

/**
 * An main interface to implement calculator logic. Each method is equal the same button as is used
 * from in original calculator.
 * <p>
 * Each method returns {@link IDisplayResult}
 */
public interface ICalculator {

    /**
     * Method simulate button one clicked on calculator.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult one();

    /**
     * Method simulate button two clicked on calculator.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult two();

    /**
     * Method simulate button three clicked on calculator.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult three();

    /**
     * Method simulate button four clicked on calculator.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult four();

    /**
     * Method simulate button five clicked on calculator.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult five();

    /**
     * Method simulate button six clicked on calculator.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult six();

    /**
     * Method simulate button seven clicked on calculator.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult seven();

    /**
     * Method simulate button eight clicked on calculator.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult eight();

    /**
     * Method simulate button nine clicked on calculator.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult nine();

    /**
     * Method simulate button zero clicked on calculator.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult zero();

    /**
     * Method simulate button dot clicked on calculator.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult dot();

    /**
     * Method simulate button addition clicked on calculator.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult add();

    /**
     * Method simulate button subtraction clicked on calculator.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult subtract();

    /**
     * Method simulate button division clicked on calculator.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult div();

    /**
     * Method simulate button multiplication clicked on calculator.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult multiply();

    /**
     * Method simulate button result clicked on calculator.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult result() throws MalformedExpressionException;

    /**
     * Method simulate button reset clicked on calculator.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult reset();

    /**
     * Method simulate button remove last element clicked on calculator.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult removeLastElement();

    /**
     * Method simulate button switch sign clicked on calculator.
     *
     * @return {@link IDisplayResult}
     */
    IDisplayResult switchSign();
}
