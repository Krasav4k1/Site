package com.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Country;
import com.repository.CountryRepository;

@Service
public class CountryService {
	@Autowired
	private CountryRepository countryRepository;
	
	public void nameSave(String name){
	   Country country = new Country();
	   country.setName(name);
	   countryRepository.save(country);
	}
	
}
