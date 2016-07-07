package com.servise.binder;


import com.servise.MusicAlbomService;

import java.beans.PropertyEditorSupport;

public class MusicAlbomEditor extends PropertyEditorSupport{

    private final MusicAlbomService musicAlbomService;

    public MusicAlbomEditor(MusicAlbomService musicAlbomService) {
        this.musicAlbomService = musicAlbomService;
    }

    public void setAsText(String text) throws IllegalArgumentException{
        setValue(musicAlbomService.findById(Integer.parseInt(text)));
    }

}
