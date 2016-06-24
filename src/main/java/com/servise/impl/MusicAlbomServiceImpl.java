package com.servise.impl;

import com.entity.MusicAlbom;
import com.repository.MusicAlbomRepository;
import com.servise.MusicAlbomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class MusicAlbomServiceImpl implements MusicAlbomService{

    @Autowired
    MusicAlbomRepository musicAlbomRepository;

    public Iterable<MusicAlbom> getAll() {
        return musicAlbomRepository.findAll();
    }

    public void save(MusicAlbom musicAlbom) {
        musicAlbomRepository.save(musicAlbom);
    }

    public MusicAlbom findById(int id) {
        return musicAlbomRepository.findOne(id);
    }
}
