package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.MedicinskaSestraDTO;
import com.example.demo.dto.ReceptDTO;
import com.example.demo.model.MedicinskaSestra;
import com.example.demo.model.Recept;
import com.example.demo.repository.MedicinskaSestraRepository;
import com.example.demo.repository.ReceptRepository;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class MedicinskaSestraService {

	@Autowired
	private MedicinskaSestraRepository repository;
	
	
	
	public MedicinskaSestraDTO getSestra(Long id){
        MedicinskaSestra ms = repository.findById(id).orElse(null);
        if (ms == null){
            throw new  ValueException("Medicinska sestra sa datim id-em ne postoji");
        }
        return new MedicinskaSestraDTO(ms);

    }
	
	
}
