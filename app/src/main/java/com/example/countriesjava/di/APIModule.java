package com.example.countriesjava.di;


import com.example.countriesjava.model.CountryAPI;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIModule {
    String BASE_URL = "https://raw.githubusercontent.com";

    public CountryAPI provideCountryAPI(){

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(CountryAPI.class);

    }

}
