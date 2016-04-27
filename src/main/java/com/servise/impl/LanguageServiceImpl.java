package com.servise.impl;

import com.entity.Language;
import com.repository.LanguageRepository;
import com.servise.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService{

    @Autowired
    LanguageRepository languageRepository;

    public void addLanguage(String language){
        Language l = new Language();
        l.setLanguage(language);
        languageRepository.save(l);
    }

}
