package com.mrcd.ok.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/**
 * ViewHolder 渲染器
 *
 * @param <T> 数据类型
 */
interface HolderHelper<T> {

    /**
     * 渲染item视图
     *
     * @param inflater 渲染器对象
     * @param group    RecyclerView对象
     * @return item视图对象
     */
    void inflateItemView(@NonNull LayoutInflater inflater, @NonNull ViewGroup group);

    /**
     * 初始化View的方法
     *
     * @param itemView itemView
     */
    void initViews(@NonNull View itemView);

    /**
     * 初始化，绑定数据的方法
     *
     * @param data     数据对象
     * @param position 位置
     */
    void setupData(T data, int position);

}
