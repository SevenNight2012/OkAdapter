package com.mrcd.ok.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

public abstract class OkHolderHelper<T> implements HolderHelper<T> {

    public View itemView;

    private OkViewHolder mViewHolder;

    final void setViewHolder(OkViewHolder viewHolder) {
        mViewHolder = viewHolder;
    }

    @Override
    public final void inflateItemView(@NonNull LayoutInflater inflater, @NonNull ViewGroup group) {
        if (0 != getItemLayout()) {
            itemView = inflater.inflate(getItemLayout(), group, false);
            if (itemView != null) {
                initViews(itemView);
            }
        }
    }

    protected Context getContext() {
        return itemView.getContext();
    }

    protected OkViewHolder getViewHolder() {
        return mViewHolder;
    }

    public abstract int getItemLayout();
}
