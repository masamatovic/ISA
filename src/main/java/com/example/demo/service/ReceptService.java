package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.ReceptDTO;
import com.example.demo.model.Recept;
import com.example.demo.repository.ReceptRepository;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class ReceptService {
	
	@Autowired
	ReceptRepository repository;
	
	public ReceptDTO getRecept(Long id){
        Recept r = repository.findById(id).orElse(null);
        if (r == null){
            throw new  ValueException("Recept sa datim id-em ne postoji");
        }
        return new ReceptDTO(r);

    }
	
	public ReceptDTO overiRecept(Long id){
        Recept r = repository.findById(id).orElse(null);
        if (r == null){
            throw new  ValueException("Recept sa datim id-em ne postoji");
        }else {
        	r.setOveren(true);
        	return new ReceptDTO(r);
        }
    }
}
