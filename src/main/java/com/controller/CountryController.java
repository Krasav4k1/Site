package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.servise.CountryService;

@Controller
public class CountryController {
	
	
	@Autowired
	CountryService countryService;
	
	@RequestMapping("/country")
	public String Show(){
		return "Country";
	}
	@RequestMapping(value = "/country", method = RequestMethod.POST)
	public String save( @RequestParam String name){
		countryService.nameSave(name);
		return "redirect:/country";
	}

	
}
