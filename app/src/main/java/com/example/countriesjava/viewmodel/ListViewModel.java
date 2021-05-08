package com.example.countriesjava.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.countriesjava.model.CountryPojo;
import com.example.countriesjava.model.CountryService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ListViewModel extends ViewModel {

    private CountryService countryService = new CountryService();
    private Observable<List<CountryPojo>> countryList = countryService.getCountries()
            .toObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());


    public Observable<List<CountryPojo>> getCountryList() {
        return countryList;
    }
}





