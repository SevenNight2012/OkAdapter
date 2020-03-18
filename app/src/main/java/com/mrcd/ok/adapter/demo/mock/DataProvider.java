package com.mrcd.ok.adapter.demo.mock;

import android.os.Handler;
import android.os.Looper;
import com.mrcd.ok.adapter.demo.domain.Animal;
import com.mrcd.ok.adapter.demo.domain.Bird;
import com.mrcd.ok.adapter.demo.domain.Cat;
import com.mrcd.ok.adapter.demo.domain.Dog;
import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    public interface DataResult<T> {

        void onDataFetched(T data);
    }

    private static final String ANIMAL_URL = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584522161694&di=7879d7d085ee5b1eb3df114d2ba0c9b5&imgtype=0&src=http%3A%2F%2Fpic1.16pic.com%2F00%2F54%2F00%2F16pic_5400441_b.jpg";

    private static final String DOG_HEAD1 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584525285624&di=3a72b094ae00031d827657458d1bbb4a&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2Ffc44ff9843d4fff460d98301fea1e10fef0480cd133d0-oaKBvm_fw658";
    private static final String DOG_HEAD2 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584526204173&di=4855a253ac957d3451de0b6bffbd35d0&imgtype=0&src=http%3A%2F%2Fwww.aixinbaomu.com%2Fuploads%2Fallimg%2F181126%2F104GB514-7.jpg";

    private Handler mHandler = new Handler(Looper.getMainLooper());

    private String[] mNames = new String[]{};
    private String[] mDesc = new String[]{};

    public void fetchAnimals(DataResult<List<Animal>> callback) {
        mHandler.postDelayed(() -> {
            List<Animal> animals = new ArrayList<>();
            for (int i = 0; i < 15; i++) {
                Animal animal = new Animal();
                animal.name = "动物编号>>> " + i;
                animal.desc = "保护动物，人人有责";
                animal.url = ANIMAL_URL;
                animals.add(animal);
            }
            callback.onDataFetched(animals);
        }, 4000);

    }

    public void fetchDogAndAnimals(DataResult<List<Animal>> callback) {
        mHandler.postDelayed(() -> {
            List<Animal> animals = new ArrayList<>();
            for (int i = 0; i < 15; i++) {
                Animal animal;
                if (i % 2 == 0) {
                    animal = createAnimal(i);
                } else {
                    animal = createDog(i);
                    animal.url = DOG_HEAD2;
                }
                animals.add(animal);
            }
            callback.onDataFetched(animals);
        }, 4000);
    }

    public void fetchDogAndCat(DataResult<List<Animal>> callback) {

    }

    public void fetchBirds(DataResult<List<Bird>> callback) {

    }

    private Animal createDog(int index) {
        Dog dog = new Dog();
        dog.name = "小狗编号 >> " + index;
        dog.desc = "狗是人类最忠诚的朋友";
        dog.url = ANIMAL_URL;
        dog.head = DOG_HEAD1;
        dog.master = "Tom";
        return dog;
    }

    private Animal createAnimal(int index) {
        Animal animal = new Animal();
        animal.name = "动物编号 >> " + index;
        animal.desc = "保护动物，人人有责";
        animal.url = ANIMAL_URL;
        return animal;
    }

    private Animal createCat(int index) {
        Cat cat = new Cat();

        return cat;
    }
}
