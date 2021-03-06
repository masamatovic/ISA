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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PregledService {

    @Autowired
    PregledRepository pregledRepository;

    @Autowired
    KlinikaRepository klinikaRepository;

    @Autowired
    PacijentRepository pacijentRepository;

    public ArrayList<PregledDTO> izlistajUnapredDefPreglede(Long id) throws ParseException {
        Klinika klinika = klinikaRepository.findById(id).orElse(null);
        if (klinika == null) {
            throw new NoSuchElementException();
        }

        Date danas = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        ArrayList<Pregled> pregledi = pregledRepository.getByKlinikaAndPacijentNull(klinika);
        ArrayList<PregledDTO> preglediDTO = new ArrayList<>();
        for (Pregled p : pregledi) {
            Date datumPregleda = formatter.parse(p.getDatum());
            if (datumPregleda.after(danas) || datumPregleda.equals(danas)) {
                preglediDTO.add(new PregledDTO(p));
            }

        }
        return preglediDTO;
    }

    public PregledDTO zakaziUDPregled(Long pacijent_id, Long pregled_id) {

        Pacijent pacijent = pacijentRepository.findById(pacijent_id).orElse(null);
        if (pacijent == null) {
            throw new NoSuchElementException();
        }
        Pregled pregled = pregledRepository.findById(pregled_id).orElse(null);
        if (pregled == null) {
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

    public ArrayList<PregledDTO> izlisajIstoriju(Long id) throws ParseException {
        Date danas = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        //System.out.println(formatter.format(date));
        Pacijent pacijent = pacijentRepository.findById(id).orElse(null);
        if (pacijent == null) {
            throw new NoSuchElementException();
        }
        ArrayList<Pregled> pregledi = pregledRepository.getByPacijent(pacijent);
        ArrayList<PregledDTO> preglediDTO = new ArrayList<>();
        if (!pregledi.isEmpty()) {
            for (Pregled pregled : pregledi) {
                Date datumPregleda = formatter.parse(pregled.getDatum());
                if (datumPregleda.before(danas) && !datumPregleda.equals(danas)) {
                    preglediDTO.add(new PregledDTO(pregled));
                }
            }
        }
        return preglediDTO;
    }

    public ArrayList<PregledDTO> sortiraj(String vrednost, Long id) throws ParseException {

        Pacijent pacijent = pacijentRepository.findById(id).orElse(null);
        if (pacijent == null){
            throw new NoSuchElementException();
        }
        Date danas = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<PregledDTO> preglediDTO = new ArrayList<>();
        if (vrednost.equals("datum")) {

            List<Pregled> pregledi = pregledRepository.findAllByPacijentOrderByDatumAsc(pacijent);
            if (!pregledi.isEmpty()) {
                for (Pregled pregled : pregledi) {
                    Date datumPregleda = formatter.parse(pregled.getDatum());
                    if (datumPregleda.before(danas) && !datumPregleda.equals(danas)) {
                        preglediDTO.add(new PregledDTO(pregled));
                    }
                }
            }
            return preglediDTO;
        }
        else if (vrednost.equals("tip")){
            List<Pregled> pregledi = pregledRepository.findAllByPacijentOrderByTipAsc(pacijent);
            if (!pregledi.isEmpty()) {
                for (Pregled pregled : pregledi) {
                    Date datumPregleda = formatter.parse(pregled.getDatum());
                    if (datumPregleda.before(danas) && !datumPregleda.equals(danas)) {
                        preglediDTO.add(new PregledDTO(pregled));
                    }
                }
            }
            return preglediDTO;
        }
        else
            return this.izlisajIstoriju(id);
    }
}