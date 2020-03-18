package com.mrcd.ok.adapter;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.mrcd.ok.adapter.OkBean.OkBeanWrapper;

public class OkAdapter extends SimpleAdapter<OkViewType> {

    private SparseArray<OnItemClickListener> mItemClickMap = new SparseArray<>();

    public OkAdapter addItemClickListener(int viewType, OnItemClickListener<? extends OkViewType> itemClickListener) {
        mItemClickMap.put(viewType, itemClickListener);
        super.defaultItemClickListener(new OkItemClickProxy(mItemClickMap));
        return this;
    }

    @Override
    public OkAdapter defaultItemClickListener(OnItemClickListener<OkViewType> itemClickListener) {
        mItemClickMap.put(0, itemClickListener);
        return (OkAdapter) super.defaultItemClickListener(new OkItemClickProxy(mItemClickMap));
    }

    @Override
    public OkAdapter addViewType(int viewType, Class<? extends OkHolderHelper<? extends OkViewType>> helperClass) {
        return (OkAdapter) super.addViewType(viewType, helperClass);
    }

    @Override
    public void onBindViewHolder(@NonNull OkViewHolder holder, int position) {
        OkViewType data = mData.get(position);
        if (holder.getItemViewType() == data.viewType()) {
            if (data instanceof OkBeanWrapper) {
                OkBeanWrapper beanWrapper = (OkBeanWrapper) data;
                holder.mHolderHelper.setupData(beanWrapper.getOriginalData(), position);
            } else {
                holder.mHolderHelper.setupData(data, position);
            }
        }
        setupItemClick(holder, position);
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).viewType();
    }
}
