package com.example.demo.service;

import com.example.demo.dto.PregledDTO;
import com.example.demo.model.Klinika;
import com.example.demo.model.Pacijent;
import com.example.demo.model.Pregled;
import com.example.demo.repository.KlinikaRepository;
import com.example.demo.repository.PacijentRepository;
import com.example.demo.repository.PregledRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
public class PregledService {

    @Autowired
    PregledRepository pregledRepository;

    @Autowired
    KlinikaRepository klinikaRepository;

    @Autowired
    PacijentRepository pacijentRepository;

    public ArrayList<PregledDTO> izlistajUnapredDefPreglede (Long id){
        Klinika klinika = klinikaRepository.findById(id).orElse(null);
        if (klinika == null){
            throw new NoSuchElementException();
        }

        ArrayList<Pregled> pregledi = pregledRepository.getByKlinikaAndPacijentNull(klinika);
        ArrayList<PregledDTO> preglediDTO = new ArrayList<>();
        for (Pregled p: pregledi){
            PregledDTO pregledDTO = new PregledDTO(p);
            preglediDTO.add(pregledDTO);
        }
        return preglediDTO;
    }

    public  PregledDTO zakaziUDPregled (Long pacijent_id, Long pregled_id){

        Pacijent pacijent = pacijentRepository.findById(pacijent_id).orElse(null);
        if (pacijent == null){
            throw new NoSuchElementException();
        }
        Pregled pregled = pregledRepository.findById(pregled_id).orElse(null);
        if (pregled == null){
            throw new NoSuchElementException();
        }
        if (pregled.getPacijent() != null) {
            throw new ValidationException("Ovaj pregled je rezervisan");
        }
        pregled.setPacijent(pacijent);
        pregled.setOdobren(true);
        pregledRepository.save(pregled);
        return new PregledDTO(pregled);
    }

}
