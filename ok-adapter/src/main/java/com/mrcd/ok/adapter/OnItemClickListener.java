package com.mrcd.ok.adapter;

import android.view.View;

public interface OnItemClickListener<T> {

    void onItemClick(View itemView, T data, int position, int viewType);

}
