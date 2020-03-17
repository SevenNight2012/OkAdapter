package com.mrcd.ok.adapter;

import java.lang.reflect.Constructor;

class HolderHelperFactory<T> {

    protected Class<? extends OkHolderHelper<? extends T>> mInflaterClass;

    HolderHelperFactory(Class<? extends OkHolderHelper<? extends T>> inflaterClass) {
        mInflaterClass = inflaterClass;
    }

    public OkHolderHelper<? extends T> createHolderInflater() {
        try {
            Constructor<? extends OkHolderHelper<? extends T>> constructor = mInflaterClass.getConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
