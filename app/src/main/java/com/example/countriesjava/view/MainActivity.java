package com.example.countriesjava.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countriesjava.R;
import com.example.countriesjava.model.CountryPojo;
import com.example.countriesjava.viewmodel.ListViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private ListViewModel viewModel;
    private RecyclerView countryRecyclerView;
    private List<CountryPojo> countryPojoList = new ArrayList<CountryPojo>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        bindObjects();

        viewModel.refresh();

        viewModel.getCountryPojoObservable().subscribe(new Observer<CountryPojo>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CountryPojo value) {
                countryPojoList.add(value);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                countryRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                countryRecyclerView.setAdapter(new CountryListAdapter(countryPojoList));
            }
        });


    }

    private void bindObjects() {
        viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
    }

    private void bindViews() {
        countryRecyclerView = findViewById(R.id.countryRecyclerView);
    }

}