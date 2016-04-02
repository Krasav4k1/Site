package com.servise.binder;

import com.servise.CountryService;

import java.beans.PropertyEditorSupport;

public class CountryEditor extends PropertyEditorSupport{

    private final CountryService countryService;

    public CountryEditor(CountryService countryService) {
        this.countryService = countryService;
    }

    public void setAsText(String text) throws IllegalArgumentException{
        setValue(countryService.findById(Integer.parseInt(text)));
    }
}
