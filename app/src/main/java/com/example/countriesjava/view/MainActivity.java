package com.example.countriesjava.view;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
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
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ListViewModel viewModel;
    private RecyclerView countryRecyclerView;
    private List<CountryPojo> countryList = new ArrayList<CountryPojo>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        bindObjects();

        ObserveModel();


    }

    private void ObserveModel(){

        viewModel.getCountryList().subscribe(new Observer<List<CountryPojo>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onNext(List<CountryPojo> value) {
               countryList = value;

            }

            @Override
            public void onError(Throwable e) {
                Log.e("onError:",e.toString());
            }

            @Override
            public void onComplete() {
                countryRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                countryRecyclerView.setAdapter(new CountryListAdapter(countryList));
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