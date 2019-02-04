package com.kirylshreyter.calculator.datamodel.impl;

import com.kirylshreyter.calculator.common.ListUtils;
import com.kirylshreyter.calculator.datamodel.IDisplayResult;
import com.kirylshreyter.calculator.datamodel.IEmbeddedMemory;
import com.kirylshreyter.calculator.datamodel.ILogic;

import java.util.ArrayList;

/**
 * Main implementation of {@link IEmbeddedMemory}
 */
public class EmbeddedMemory<T extends ILogic> extends ArrayList<T> implements IEmbeddedMemory<T> {
    private ListUtils utils = ListUtils.getInstance();

    @Override
    public IDisplayResult result() {
        return utils.listToDisplayResult(this);
    }
}
