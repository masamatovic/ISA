package com.example.demo.service;


import com.example.demo.dto.PregledDTO;
import com.example.demo.model.Klinika;
import com.example.demo.model.Pregled;
import com.example.demo.repository.KlinikaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.model.Doktor;
import com.example.demo.model.Klinika;
import com.example.demo.repository.DoktorRepository;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.util.ArrayList;
import java.util.NoSuchElementException;


@Service
public class DoctorService {

	@Autowired
	private DoktorRepository repository;
	@Autowired
	private KlinikaRepository klinikaRepository;

//<<<<<<< HEAD
	public void addDoctor(DoctorDTO dDTO,Klinika klinika) {
//=======
	

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
			if(klinika != null) {
				d.setKlinika(klinika);
			}
			
			repository.save(d);
			
		}
		catch(IllegalArgumentException e) {
			throw new ValueException("Nije uspjesno dodati doktor");

		}

	}
	

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
		catch(IllegalArgumentException e) {
			throw new ValueException("Nije uspjesno dodati doktor");

		}

	}
	
	
	
	public ArrayList<DoctorDTO> izlistajDoktore (Long id){
		Klinika klinika = klinikaRepository.findById(id).orElse(null);
		if (klinika == null){
			throw new NoSuchElementException();
		}

		ArrayList<Doktor> doktori = repository.findByKlinika(klinika);
		ArrayList<DoctorDTO> doctorDTOS = new ArrayList<>();
		for (Doktor p: doktori){
			DoctorDTO doctorDTO = new DoctorDTO(p);
			doctorDTOS.add(doctorDTO);
		}
		return doctorDTOS;
	}
	public ArrayList<DoctorDTO> pretrazi(String ime, String prezime, Long tipPregleda, Long klinika){
		ArrayList<Doktor> doktori =  new ArrayList<Doktor>();
		doktori = repository.getByQuery(ime, prezime, tipPregleda, klinika);
		ArrayList<DoctorDTO> doctorDTOS = new ArrayList<>();
		for (Doktor p: doktori){
			DoctorDTO doctorDTO = new DoctorDTO(p);
			doctorDTOS.add(doctorDTO);
		}
		return doctorDTOS;
	}

	
	
	
}
