package com.example.demo.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SalaDTO;
import com.example.demo.model.Klinika;
import com.example.demo.model.Sala;
import com.example.demo.repository.SalaRepository;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;


@Service
public class SalaService {

	@Autowired 
	private SalaRepository repository;
	
	//find Sala
	public SalaDTO findSala(Long id) {
		Sala sala = repository.findById(id).orElse(null);
		if(sala == null) {
			throw new ValueException("Sala je nepostojeca");
		}
		
		return new SalaDTO(sala);
	}
	//modify Sala
	public Sala modifySala(SalaDTO sDTO, Klinika klinika) {
		Sala s = repository.findById(sDTO.getId()).orElse(null);
		if(s == null) {
			throw new ValueException("Sala je nepostojeca");
		}
		
		try {
			s.setBroj(sDTO.getBroj());
			s.setNaziv(sDTO.getNaziv());
			s.setVrstaSale(sDTO.isVrstaSale());
			if(klinika != null) {
				s.setKlinika(klinika);
			}
			repository.save(s);
		}
		catch(EntityNotFoundException e) {
			throw new ValueException("Izmjene sale nisu uspjesne");

		}
		
		return s;
	}
	
	//delete sala
	public Sala deleteSala(Long id) {
		Sala sala = repository.findById(id).orElse(null);
		if(sala == null) {
			throw new ValueException("Sala je nepostojeca");
 
		}
		
		try {
			repository.delete(sala);
		}
		catch(Exception e){
			throw new ValueException("Greska u brisanju sale");

		}
		
		return sala;
	}
	//insert sala
	public SalaDTO addSala(SalaDTO sDTO, Klinika klinika) {
		
		Sala s = new Sala();
		try {
			s.setBroj(sDTO.getBroj());
			s.setNaziv(sDTO.getNaziv());
			s.setVrstaSale(sDTO.isVrstaSale());
			s.setKlinika(klinika);
			repository.save(s);
			
		}
		catch(IllegalArgumentException e){
			throw new ValueException("Nije uspjesno dodata sala");	
		}
		
		return new SalaDTO(s);
	}
	
	
	
}
