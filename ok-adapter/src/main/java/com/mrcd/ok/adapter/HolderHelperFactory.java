package com.mrcd.ok.adapter;

import java.lang.reflect.Constructor;

/**
 * 创建HolderHelper的工厂类
 *
 * @param <T> 泛型参数，实体类型
 */
class HolderHelperFactory<T> {

    private Class<? extends OkHolderHelper<? extends T>> mInflaterClass;

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
