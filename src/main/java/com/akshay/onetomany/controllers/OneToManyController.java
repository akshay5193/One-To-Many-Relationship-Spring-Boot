package com.akshay.onetomany.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.akshay.onetomany.models.Dojo;
import com.akshay.onetomany.models.Ninja;
import com.akshay.onetomany.services.OneToManyService;

@Controller
public class OneToManyController {

	@Autowired
	private OneToManyService oneToManyService;
	
	@GetMapping ("/dojos")
	public String index(Model model) {
		List<Dojo> dojos = oneToManyService.getAllDojos();
		model.addAttribute("dojos", dojos);
		return "/dojo-ninja/index.jsp";
	}
	
	
	@GetMapping ("/dojos/new")
	public String addNewDojoPage (@ModelAttribute ("dojo") Dojo dojo) {
		return "/dojo-ninja/newDojo.jsp";
	}
	
	
	@PostMapping ("/dojos")
	public String addNewDojo (@Valid @ModelAttribute ("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "/dojos/new";
		}
		else {
			oneToManyService.createDojo(dojo);
			return "redirect:/dojos";
		}	
	}
	
	
	@GetMapping ("/dojos/{id}")
	public String dojoDetails (@PathVariable ("id") Long id, Model model) {
		Dojo dojo = oneToManyService.getDojo(id);
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", dojo.getNinjas());
		System.out.println("page loaded...");
		System.out.println(dojo.getNinjas());
		return "/dojo-ninja/showDojo.jsp";
	}
	
	
	@GetMapping ("/ninjas/new")
	public String addNewNinjaPage(@ModelAttribute ("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", oneToManyService.getAllDojos());
		return "/dojo-ninja/newNinja.jsp";
	}
	
	
	@GetMapping ("/ninjas")
	public String allNinjas(Model model) {
		return "/dojo-ninja/ninjas.jsp";
	}
	
	@PostMapping ("/ninjas")
	public String addNewNinja (@Valid @ModelAttribute ("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "/dojos/new";
		}
		else {
			oneToManyService.createNinja(ninja);
			return "redirect:/dojos";
		}	
	}
	
}
