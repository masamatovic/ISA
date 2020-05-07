package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.model.Doktor;
import com.example.demo.repository.DoktorRepository;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;


@Service
public class DoctorService {

	@Autowired
	private DoktorRepository repository;

	public void addDoctor(DoctorDTO dDTO) {
		// TODO Auto-generated method stub
		Doktor d = new Doktor();
		try {
			d.setIme(dDTO.getIme());
			d.setPrezime(dDTO.getPrezime());
			d.setEmail(dDTO.getEmail());
			d.setLozinka(dDTO.getLozinka());
			d.setAdresa(dDTO.getAdresa());
			d.setGrad(dDTO.getGrad());
			d.setTelefon(dDTO.getTelefon());
			d.setDrzava(dDTO.getDrzava());
			d.setJmbg(dDTO.getJmbg());
			
			repository.save(d);
			
		}
		catch(IllegalArgumentException e){
			throw new ValueException("Nije uspjesno dodati doktor");
			
		}
		
	}
	

	
	
	
}
