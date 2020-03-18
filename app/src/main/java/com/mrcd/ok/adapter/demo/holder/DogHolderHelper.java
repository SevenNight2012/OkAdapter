package com.mrcd.ok.adapter.demo.holder;

import android.view.View;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.mrcd.ok.adapter.OkHolderHelper;
import com.mrcd.ok.adapter.demo.R;
import com.mrcd.ok.adapter.demo.databinding.OkAnimalDogBinding;
import com.mrcd.ok.adapter.demo.domain.Dog;

public class DogHolderHelper extends OkHolderHelper<Dog> {

    private OkAnimalDogBinding mDogBinding;

    @Override
    public int getItemLayout() {
        return R.layout.ok_animal_dog;
    }

    @Override
    public void initViews(@NonNull View itemView) {
        mDogBinding = OkAnimalDogBinding.bind(itemView);
    }

    @Override
    public void setupData(Dog data, int position) {
        mDogBinding.dogName.setText(String.format("%s  %s", data.master, data.name));
        Glide.with(getContext()).load(data.head).into(mDogBinding.dogImage1);
        Glide.with(getContext()).load(data.url).into(mDogBinding.dogImage2);
    }
}
