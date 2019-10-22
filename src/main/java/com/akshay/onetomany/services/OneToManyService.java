package com.akshay.onetomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.onetomany.models.Dojo;
import com.akshay.onetomany.models.Ninja;
import com.akshay.onetomany.repositories.DojoRepository;
import com.akshay.onetomany.repositories.NinjaRepository;

@Service
public class OneToManyService {

	@Autowired
	private DojoRepository dojoRepository;
	
	@Autowired
	private NinjaRepository ninjaRepository;
	
	public List<Dojo> getAllDojos() {
		return dojoRepository.findAll();
	}
	
	
	public List<Ninja> getAllNinjas() {
		return ninjaRepository.findAll();
	}
	
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	
	public Dojo getDojo (Long id) {
		System.out.println("Came here in services");
		Optional <Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			System.out.println("Dojo found");
			return optionalDojo.get();
		}
		else {
			System.out.println("No Such Dojo Location available");
			return null;
		}
	}
	
	
	
}
