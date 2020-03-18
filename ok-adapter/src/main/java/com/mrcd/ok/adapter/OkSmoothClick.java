package com.mrcd.ok.adapter;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * 点击防抖
 */
public class OkSmoothClick implements View.OnClickListener {

    private static final long DEFAULT_CLICK_DURING_TIME = 500;

    private long mClickDuring = DEFAULT_CLICK_DURING_TIME;
    private OnClickListener mOriginalClick;

    public OkSmoothClick(OnClickListener originalClick) {
        mOriginalClick = originalClick;
    }

    public OkSmoothClick(long clickDuring, OnClickListener originalClick) {
        mClickDuring = clickDuring;
        mOriginalClick = originalClick;
    }

    @Override
    public void onClick(View v) {
        if (null == v) {
            return;
        }
        Object tag = v.getTag(R.id.ok_smooth_click_tag);
        long thisTime = System.currentTimeMillis();
        v.setTag(R.id.ok_smooth_click_tag, thisTime);
        if (null != tag) {
            long lastTime = (long) tag;
            long during = thisTime - lastTime;
            if (during > mClickDuring) {
                callClick(v);
            }
        } else {
            callClick(v);
        }
    }

    private void callClick(View view) {
        if (mOriginalClick != null) {
            mOriginalClick.onClick(view);
        }
    }
}
