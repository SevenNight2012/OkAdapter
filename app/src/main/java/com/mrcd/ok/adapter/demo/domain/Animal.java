package com.mrcd.ok.adapter.demo.domain;

import com.mrcd.ok.adapter.OkViewType;

public class Animal implements OkViewType {

    public static final int TYPE_ANIMAL = 0;
    public static final int TYPE_DOG = 1;
    public static final int TYPE_CAT = 2;
    public static final int TYPE_BIRD = 3;

    public String name;
    public String url;
    public String desc;

    @Override
    public int viewType() {
        return 0;
    }
}
