package com.example.countriesjava.di;

import com.example.countriesjava.model.CountryService;

import dagger.Component;

@Component(modules = {APIModule.class})
public interface APIComponent {

    void inject(CountryService countryService);

}
