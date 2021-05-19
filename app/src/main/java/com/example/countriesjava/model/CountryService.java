package com.example.countriesjava.model;

import com.example.countriesjava.di.DaggerAPIComponent;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountryService {


    @Inject
    CountryAPI api;
    {
        DaggerAPIComponent.builder().build().inject(this);
    }

    public Single<List<CountryPojo>> getCountries() {
        return api.getCountries();
    }
}
