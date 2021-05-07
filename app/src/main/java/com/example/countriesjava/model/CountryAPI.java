package com.example.countriesjava.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface CountryAPI {

    @GET("devtides/countries/master/countriesV2.json")
    public Single<List<CountryPojo>> getCountries();

}
