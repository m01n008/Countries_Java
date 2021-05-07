package com.example.countriesjava.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountryService {

    String BASE_URL = "https://raw.githubusercontent.com";

    private CountryAPI api;
    {
        api = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(CountryAPI.class);
    }

    public Single<List<CountryPojo>> getCountries(){
        return api.getCountries();
    }
}
