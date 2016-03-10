package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

	private List<Person> list = new ArrayList<Person>();

/*	@RequestMapping("/")
	public String indexView(Model model) {
		model.addAttribute("persons", list);
		return "StartingPage";
	}*/

	/*@RequestMapping(value = "/", method = RequestMethod.POST)
	public String indexPost(@RequestParam(value="age") int age,
			@RequestParam String name, @RequestParam String lastName) {
		list.add(new Person(age, name , lastName));
		return "redirect:/";
	}

	@RequestMapping("/{id}")
	public String delete(@PathVariable int id) {
		list.remove(id);
		return "redirect:/";

	}*/
}
