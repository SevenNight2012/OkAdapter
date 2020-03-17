package com.mrcd.ok.adapter;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class SimpleAdapter<T> extends RecyclerView.Adapter<OkViewHolder> {

    private List<T> mData = new ArrayList<>();

    private LayoutInflater mInflater;
    private SparseArray<HolderHelperFactory<? extends T>> mFactoryMap = new SparseArray<>();
    private HolderHelperFactory mErrorFactory;

    private OnItemClickListener<T> mItemClickListener;

    public SimpleAdapter() {
    }

    public <D extends T> SimpleAdapter(Class<? extends OkHolderHelper<D>> helpClass) {
        registerViewType(0, helpClass);
    }

    public <D extends T> SimpleAdapter registerViewType(int viewType, Class<? extends OkHolderHelper<D>> helperClass) {
        mFactoryMap.put(viewType, new HolderHelperFactory<D>(helperClass));
        return this;
    }

    public SimpleAdapter setErrorHolderHelperFactory(HolderHelperFactory<Object> errorFactory) {
        mErrorFactory = errorFactory;
        return this;
    }

    public SimpleAdapter setItemClickListener(OnItemClickListener<T> itemClickListener) {
        mItemClickListener = itemClickListener;
        return this;
    }

    public <D extends T> void addData(D data) {
        if (null == data) {
            return;
        }
        int size = mData.size();
        mData.add(data);
        notifyItemRangeChanged(size, 1);
    }

    public <D extends T> void addDataList(List<D> dataList) {
        if (null == dataList || dataList.size() == 0) {
            return;
        }
        int size = mData.size();
        mData.addAll(dataList);
        notifyItemRangeInserted(size, dataList.size());
    }

    public <D extends T> void addToHead(D data) {
        if (null == data) {
            return;
        }
        mData.add(0, data);
        notifyItemRangeInserted(0, 1);
    }

    public <D extends T> void addToHead(List<D> dataList) {
        if (null == dataList || dataList.size() == 0) {
            return;
        }
        mData.addAll(0, dataList);
        notifyItemRangeInserted(0, dataList.size());
    }

    @NonNull
    @Override
    public OkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (null == mInflater) {
            mInflater = LayoutInflater.from(parent.getContext());
        }
        //根据视图类型，获取视图渲染器工厂
        HolderHelperFactory factory = mFactoryMap.get(viewType);
        //确保工厂的可用性
        factory = null == factory ? getErrorFactory() : factory;
        //工厂创建视图渲染器
        OkHolderHelper holderHelper = factory.createHolderInflater();
        //渲染器创建视图对象
        holderHelper.inflateItemView(mInflater, parent);
        //创建Holder对象
        OkViewHolder okViewHolder = new OkViewHolder(holderHelper.itemView);
        //将Holder对象与渲染器对象相互绑定
        okViewHolder.mHolderHelper = holderHelper;
        holderHelper.setViewHolder(okViewHolder);
        return okViewHolder;
    }

    private HolderHelperFactory getErrorFactory() {
        return null == mErrorFactory ? new DefaultErrorFactory(null) : mErrorFactory;
    }

    @Override
    public void onBindViewHolder(@NonNull OkViewHolder holder, int position) {
        holder.mHolderHelper.setupData(mData.get(position), position);
        if (mItemClickListener != null) {
            holder.itemView.setOnClickListener(new OkSmoothClick(v -> {
                mItemClickListener.onItemClick(v, mData.get(position), position, holder.getItemViewType());
            }));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
