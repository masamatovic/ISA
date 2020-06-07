package com.example.demo.service;

import com.example.demo.dto.TipPregledaDTO;
import com.example.demo.model.TipPregleda;
import com.example.demo.repository.TipPregledaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TipPregledaService {

    @Autowired
    TipPregledaRepository tipPregledaRepository;

    public TipPregledaDTO izlistajPregled(Long id){
        TipPregleda tipPregleda = tipPregledaRepository.findById(id).orElse(null);
        if (tipPregleda == null){
            throw new NoSuchElementException();
        }
        return new TipPregledaDTO(tipPregleda);
    }
    public ArrayList<TipPregledaDTO> izlistajSvePreglede(){
        List<TipPregleda> tipoviPregleda = tipPregledaRepository.findAll();
        ArrayList<TipPregledaDTO> tipoviPregledaDTO = new ArrayList<>();
        for(TipPregleda tip : tipoviPregleda){
            tipoviPregledaDTO.add(new TipPregledaDTO(tip));
        }
        return tipoviPregledaDTO;
    }
}
