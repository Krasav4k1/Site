package com.repository;

import com.entity.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository  extends CrudRepository<Language,Integer> {
}
