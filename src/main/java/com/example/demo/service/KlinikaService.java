package com.example.demo.service;


import com.example.demo.dto.KlinikaDTO;
import com.example.demo.model.Klinika;
import com.example.demo.repository.KlinikaRepository;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KlinikaService {

    @Autowired
    private KlinikaRepository repository;

    public List<KlinikaDTO> izlistajKlinike(){

        List<KlinikaDTO> klinikaDTOS = new ArrayList<>();
        List<Klinika> klinike = repository.findAll();
        if(klinike.isEmpty()){
            throw new ValueException("U sistemu nema klinika");
        }

        for (Klinika k : klinike){
            klinikaDTOS.add(new KlinikaDTO(k));
        }
        return klinikaDTOS;
    }

    public List<Klinika> sortiraj (String vrednost){

         if (vrednost.equals("naziv"))
             return repository.findAllByOrderByNazivAsc();
         else if (vrednost.equals("grad"))
             return repository.findAllByOrderByGradAsc();
         else
             return repository.findAll();

    }
}
