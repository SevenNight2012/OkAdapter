package com.mrcd.ok.adapter.demo;

import android.Manifest.permission;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.mrcd.ok.adapter.OkAdapter;
import com.mrcd.ok.adapter.OnItemClickListener;
import com.mrcd.ok.adapter.demo.databinding.ActivityMainBinding;
import com.mrcd.ok.adapter.demo.domain.Animal;
import com.mrcd.ok.adapter.demo.domain.Dog;
import com.mrcd.ok.adapter.demo.holder.AnimalHolderHelper;
import com.mrcd.ok.adapter.demo.holder.DogHolderHelper;
import com.mrcd.ok.adapter.demo.mock.DataProvider;
import com.mrcd.ok.adapter.demo.mock.DataProvider.DataResult;
import com.xxc.dev.permission.Sudo;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] mPermissions = new String[]{permission.WRITE_EXTERNAL_STORAGE,
        permission.READ_EXTERNAL_STORAGE};

    private ActivityMainBinding mMainBinding;
    private DataProvider mDataProvider = new DataProvider();
    private OkAdapter mOkAdapter = new OkAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mMainBinding.getRoot());
        Sudo.getInstance()
            .prepare()
            .setPermissions(mPermissions)
            .setGranted(permissions -> requestAnimals())
            .request(this);
    }

    private void requestAnimals() {
        mOkAdapter.addViewType(Animal.TYPE_ANIMAL, AnimalHolderHelper.class);
        mOkAdapter.addViewType(Animal.TYPE_DOG, DogHolderHelper.class);
        mOkAdapter.addItemClickListener(Animal.TYPE_ANIMAL, new OnItemClickListener<Animal>() {
            @Override
            public void onItemClick(View itemView, Animal data, int position, int viewType) {
                String text = "点击animal >> " + data.name;
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
        mOkAdapter.addItemClickListener(Animal.TYPE_DOG, new OnItemClickListener<Dog>() {
            @Override
            public void onItemClick(View itemView, Dog data, int position, int viewType) {
                String text = "点击小狗 >> " + data.master + "  " + data.name;
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
        mMainBinding.mainRecycler.setAdapter(mOkAdapter);
        mMainBinding.mainRecycler.setLayoutManager(new LinearLayoutManager(this));
//        requestAnimalList();
        requestDogAndAnimalList();
    }

    private void requestAnimalList() {
        mDataProvider.fetchAnimals(new DataResult<List<Animal>>() {
            @Override
            public void onDataFetched(List<Animal> data) {
                mOkAdapter.addDataList(data);
            }
        });
    }

    private void requestDogAndAnimalList() {
        mDataProvider.fetchDogAndAnimals(new DataResult<List<Animal>>() {
            @Override
            public void onDataFetched(List<Animal> data) {
                mOkAdapter.addDataList(data);
            }
        });
    }
}
