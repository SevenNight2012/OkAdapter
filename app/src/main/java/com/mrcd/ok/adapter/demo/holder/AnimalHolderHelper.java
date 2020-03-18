package com.mrcd.ok.adapter.demo.holder;

import android.view.View;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.mrcd.ok.adapter.OkHolderHelper;
import com.mrcd.ok.adapter.demo.R;
import com.mrcd.ok.adapter.demo.databinding.OkAnimalItemBinding;
import com.mrcd.ok.adapter.demo.domain.Animal;

public class AnimalHolderHelper extends OkHolderHelper<Animal> {

    private OkAnimalItemBinding mItemBinding;

    @Override
    public int getItemLayout() {
        return R.layout.ok_animal_item;
    }

    @Override
    public void initViews(@NonNull View itemView) {
        mItemBinding = OkAnimalItemBinding.bind(itemView);
    }

    @Override
    public void setupData(Animal data, int position) {
        mItemBinding.animalItem.setText(data.name);
        Glide.with(getContext()).load(data.url).into(mItemBinding.animalImage);
    }
}
