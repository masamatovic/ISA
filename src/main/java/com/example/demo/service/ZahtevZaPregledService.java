package com.example.demo.service;

import com.example.demo.dto.ZahtevZaPregledDTO;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ZahtevZaPregledService {

    @Autowired
    ZahtevZaPregledRepository repository;

    @Autowired
    DoktorRepository doktorRepository;

    @Autowired
    KlinikaRepository klinikaRepository;

    @Autowired
    PacijentRepository pacijentRepository;

    @Autowired
    TipPregledaRepository tipPregledaRepository;

    public ZahtevZaPregled napraviZahtev(ZahtevZaPregledDTO zahtevZaPregledDTO){


        Doktor doktor = doktorRepository.findById(zahtevZaPregledDTO.getDoktor()).orElse(null);
        Pacijent pacijent = pacijentRepository.findById(zahtevZaPregledDTO.getPacijent()).orElse(null);
        Klinika klinika = klinikaRepository.findById(zahtevZaPregledDTO.getKlinika()).orElse(null);
        TipPregleda tipPregleda = tipPregledaRepository.findById(zahtevZaPregledDTO.getTip()).orElse(null);

        if (doktor==null || pacijent==null || klinika==null || tipPregleda==null)
            throw new NoSuchElementException();

        ZahtevZaPregled zahtevZaPregled = new ZahtevZaPregled();
        zahtevZaPregled.setCena(zahtevZaPregledDTO.getCena());
        zahtevZaPregled.setDatum(zahtevZaPregledDTO.getCena());
        zahtevZaPregled.setTrajanje("01");
        zahtevZaPregled.setDoktor(doktor);
        zahtevZaPregled.setPacijent(pacijent);
        zahtevZaPregled.setKlinika(klinika);
        zahtevZaPregled.setTip(tipPregleda);
        zahtevZaPregled.setOdobren(false);
        zahtevZaPregled.setVreme(zahtevZaPregledDTO.getVreme());
        this.repository.save(zahtevZaPregled);

        return zahtevZaPregled;


    }

}
