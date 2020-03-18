package com.mrcd.ok.adapter;

import java.util.ArrayList;
import java.util.List;

public class OkBean implements OkViewType {

    public static <D> OkViewType converter(D data, int viewType) {
        return new OkBeanWrapper(data, viewType);
    }

    public static <D> List<OkViewType> converter(List<D> dataList, int viewType) {
        return new ArrayList<>();
    }

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
