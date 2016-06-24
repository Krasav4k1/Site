package com.servise.binder;

import com.servise.GrupService;

import java.beans.PropertyEditorSupport;

public class GrupEditor extends PropertyEditorSupport{

    private final GrupService grupService ;

    public GrupEditor(GrupService grupService) {
        this.grupService = grupService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        setValue(grupService.findById(Integer.parseInt(text)));
    }
}
