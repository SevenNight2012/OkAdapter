package com.mrcd.ok.adapter.demo.domain;

import com.mrcd.ok.adapter.OkViewType;

public class Cat extends Animal implements OkViewType {

    public String master;
    public String type;

    @Override
    public int viewType() {
        return Animal.TYPE_CAT;
    }
}
