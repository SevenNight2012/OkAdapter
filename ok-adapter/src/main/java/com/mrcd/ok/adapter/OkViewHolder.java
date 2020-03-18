package com.mrcd.ok.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 通过{@link OkHolderHelper}将ViewHolder的职能嫁接过来，
 * 不选择直接在ViewHolder的基础上进行封装的主要目的在于，Holder构造器的super方法无法调用抽象方法，
 * 我的想法：团队开发中，不同人写的不同的Holder，如果需要修改布局文件，
 * 按照{@link androidx.recyclerview.widget.RecyclerView.ViewHolder}的写法，
 * 势必要找到view创建的地方，才能知道对应的布局文件，为了避免这种情况，将Holder的职能嫁接出去，
 * 并且将Helper与Holder相互绑定，这样在Helper中需要Holder的某些方法也能方便调用
 */
class OkViewHolder extends RecyclerView.ViewHolder {

    private OkHolderHelper mHolderHelper;

    OkViewHolder(@NonNull OkHolderHelper holderHelper) {
        super(holderHelper.itemView);
        mHolderHelper = holderHelper;
    }

    public OkHolderHelper getHelper() {
        return mHolderHelper;
    }
}
