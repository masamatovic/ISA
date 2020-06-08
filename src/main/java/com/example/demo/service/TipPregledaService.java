package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TipPregledaDTO;
import com.example.demo.model.Klinika;
import com.example.demo.model.Pregled;
import com.example.demo.model.TipPregleda;
import com.example.demo.repository.PregledRepository;
import com.example.demo.repository.TipPregledaRepository;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

@Service
public class TipPregledaService {

    @Autowired
    TipPregledaRepository tipPregledaRepository;
    
    @Autowired
    private PregledRepository pregledRepository;

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
	public TipPregledaDTO addTipPregleda(TipPregledaDTO tpDTO, Klinika klinika) {
		// TODO Auto-generated method stub
		ArrayList<TipPregleda> listTP = (ArrayList<TipPregleda>) klinika.getTipPregleda();
		TipPregleda tp = new TipPregleda();
		try {
			tp.setId(tpDTO.getId());
			tp.setCena(tp.getCena());
			tp.setKlinika(klinika);
			tp.setNaziv(tp.getNaziv());
			tipPregledaRepository.save(tp);
			return new TipPregledaDTO(tp);
		}
		catch(IllegalArgumentException e) {
			throw new ValueException("Nije uspjesno dodavanje tipa pregleda");
		}	
	}
	
	public TipPregleda findTipPregleda(Long id) {
		TipPregleda tp = tipPregledaRepository.findById(id).orElse(null);
		if(tp == null) {
			throw new NoSuchElementException();
		}
		
		return tp;
		
	}
	public TipPregleda modifyTipPregleda(TipPregledaDTO tpDTO) {
		// TODO Auto-generated method stub
		TipPregleda tp = tipPregledaRepository.findById(tpDTO.getId()).orElse(null);
		if(tp != null) {
			try {
				tp.setId(tpDTO.getId());
				tp.setCena(tp.getCena());
				//tp.setKlinika(klinika);
				tp.setNaziv(tp.getNaziv());
				tipPregledaRepository.save(tp);
				return tp;
			}
			catch(IllegalArgumentException e) {
				throw new ValueException("Nije uspjesno dodavanje tipa pregleda");
			}	
		}
		return null;
	}
	public boolean deleteTipPregleda(Long id) throws Exception {
		// TODO Auto-generated method stub
		TipPregleda tp = tipPregledaRepository.findById(id).orElse(null);
		if(tp == null) {
			throw new NoSuchElementException();
		}
		
		ArrayList<Pregled> listPregled = (ArrayList<Pregled>)pregledRepository.findAll();
		for(Pregled p : listPregled) {
			if(p.getTip().getNaziv() == tp.getNaziv() && p.isOdobren()) {
				return false;
			}
		}
		
		try {
			tipPregledaRepository.delete(tp);
		}
		catch(Exception e ) {
			throw new Exception("Neuspjesno brisanje tipa pregleda");
		}
		
		return true;
		
	}
}
