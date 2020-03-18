package com.mrcd.ok.adapter;

/**
 * 视图类型
 */
public interface OkViewType {

    /**
     * 返回视图类型
     *
     * @return 数值，默认值为0
     */
    default int viewType() {
        return 0;
    }

}
