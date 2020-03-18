package com.mrcd.ok.adapter.demo.domain;

import com.mrcd.ok.adapter.OkViewType;

public class Dog extends Animal implements OkViewType {

    public String master;
    public String type;
    //头像
    public String head;

    @Override
    public int viewType() {
        return Animal.TYPE_DOG;
    }
}
