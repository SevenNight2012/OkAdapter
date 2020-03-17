package com.mrcd.ok.adapter;

import com.mrcd.ok.adapter.error.ErrorViewHelper;

public class DefaultErrorFactory extends HolderHelperFactory {

    DefaultErrorFactory(Class<? extends OkHolderHelper> inflaterClass) {
        super(inflaterClass);
    }

    @Override
    public OkHolderHelper<Object> createHolderInflater() {
        return new ErrorViewHelper();
    }
}
