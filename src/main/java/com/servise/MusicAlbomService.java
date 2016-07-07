package com.servise;

import com.entity.MusicAlbom;

public interface MusicAlbomService {

    Iterable<MusicAlbom> getAll();

    void save(MusicAlbom musicAlbom);

    MusicAlbom findById(int id);

}
