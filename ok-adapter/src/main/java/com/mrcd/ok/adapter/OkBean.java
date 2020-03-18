package com.mrcd.ok.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 包装工具类
 */
public final class OkBean {

    public static <D> OkViewType converter(D data, int viewType) {
        return new OkBeanWrapper(data, viewType);
    }

    public static <D> List<OkViewType> converter(List<D> dataList, int viewType) {
        return new ArrayList<>();
    }

    /**
     * 包装器
     */
    static class OkBeanWrapper implements OkViewType {

        private Object mOriginalData;
        private int mViewType;

        OkBeanWrapper(Object originalData, int viewType) {
            mOriginalData = originalData;
            mViewType = viewType;
        }

        @Override
        public int viewType() {
            return mViewType;
        }

        Object getOriginalData() {
            return mOriginalData;
        }
    }
}
