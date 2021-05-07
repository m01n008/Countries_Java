package com.example.countriesjava.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.countriesjava.model.CountryPojo;
import com.example.countriesjava.model.CountryService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListViewModel extends ViewModel {

    public List<CountryPojo> countryPojoList = new ArrayList<CountryPojo>();
    private CountryService countryService = new CountryService();
    Observable<CountryPojo> countryPojoObservable = Observable.fromIterable(getData())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());

    public Observable<CountryPojo> getCountryPojoObservable() {
        return countryPojoObservable;
    }

    public void setCountryPojoObservable(Observable<CountryPojo> countryPojoObservable) {
        this.countryPojoObservable = countryPojoObservable;
    }

    public void refresh() {

        getData();

    }

    private List<CountryPojo> getData() {

        countryPojoList = (List<CountryPojo>) countryService.getCountries();
        return countryPojoList;

    }
}
