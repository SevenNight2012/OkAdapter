package com.mrcd.ok.adapter;

import android.util.SparseArray;
import android.view.View;
import com.mrcd.ok.adapter.OkBean.OkBeanWrapper;

class OkItemClickListener implements OnItemClickListener<OkViewType> {

    private SparseArray<OnItemClickListener> mItemClickMap;

    public OkItemClickListener(SparseArray<OnItemClickListener> itemClickMap) {
        mItemClickMap = itemClickMap;
    }

    @Override
    public void onItemClick(View itemView, OkViewType data, int position, int viewType) {
        OnItemClickListener onItemClickListener = mItemClickMap.get(viewType);
        if (null != onItemClickListener && data.viewType() == viewType) {
            if (data instanceof OkBeanWrapper) {
                OkBeanWrapper okBean = (OkBeanWrapper) data;
                onItemClickListener.onItemClick(itemView, okBean.getOriginalData(), position, viewType);
            } else {
                onItemClickListener.onItemClick(itemView, data, position, viewType);
            }
        }
    }
}
