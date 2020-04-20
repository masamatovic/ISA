package com.example.demo.service;


import com.example.demo.dto.PacijentDTO;
import com.example.demo.model.Pacijent;
import com.example.demo.repository.PacijentRepository;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PacijentService {

    @Autowired
    private PacijentRepository repository;


    public Pacijent izmeni( PacijentDTO pdto){
        Pacijent p = repository.findById(pdto.getId()).orElse(null);
        if (p == null){
            throw new  ValueException("Pacijent sa datim id-em ne postoji");
        }
        try {
            p.setIme(pdto.getIme());
            p.setPrezime(pdto.getPrezime());
            p.setAdresa(pdto.getAdresa());
            p.setDrzava(pdto.getDrzava());
            p.setGrad(pdto.getGrad());
            p.setTelefon(pdto.getTelefon());
            this.repository.save(p);
        }catch (EntityNotFoundException e){
            throw new ValueException("Pacijent sa datim id-em ne postoji");
        }
        return p;
    }
}
