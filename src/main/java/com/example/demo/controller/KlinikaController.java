package com.example.demo.controller;


import com.example.demo.dto.DoctorDTO;
import com.example.demo.dto.KlinikaDTO;
import com.example.demo.dto.OcenaKlinikeDTO;
import com.example.demo.dto.TipPregledaDTO;
import com.example.demo.model.Klinika;
import com.example.demo.model.OcenaKlinike;
import com.example.demo.service.DoctorService;
import com.example.demo.service.KlinikaService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
@RequestMapping(value = "/klinika")
public class KlinikaController {

    @Autowired
    private KlinikaService klinikaService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = "/izlistajSve")
    public ResponseEntity izlistaj(){

        try {
            List<KlinikaDTO> klinike = klinikaService.izlistajKlinike();
            return new ResponseEntity (klinike, HttpStatus.OK);
        }catch (ValueException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/sortiraj/{vrednost}")
    public ResponseEntity sortiraj(@PathVariable String vrednost ){

        List<Klinika> klinike = klinikaService.sortiraj(vrednost);
        List<KlinikaDTO> klinikaDTOS = new ArrayList<>();

        for (Klinika k : klinike){
            klinikaDTOS.add(new KlinikaDTO(k));
        }
        if (klinikaDTOS.isEmpty()){
            return new ResponseEntity("Ne postoje klinike", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(klinikaDTOS, HttpStatus.OK);
    }
    @GetMapping(value = "/izlistaj/{id}")
    public ResponseEntity izlistaj(@PathVariable Long id ){

        if (id == null){
            return new ResponseEntity("Id je null", HttpStatus.BAD_REQUEST);
        }
        try {
            KlinikaDTO klinikaDTO = klinikaService.izlistajKliniku(id);
            return new ResponseEntity (klinikaDTO, HttpStatus.OK);
        }catch (ValueException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping(value = "/izlistajTipovePregleda/{id}")
    public ResponseEntity izlistajTP(@PathVariable Long id ){

        if (id == null){
            return new ResponseEntity("Id je null", HttpStatus.BAD_REQUEST);
        }
        try {
            ArrayList<TipPregledaDTO> tipoviPregledaDTO = klinikaService.izlistajTipovePregledaKlinike(id);
            return new ResponseEntity (tipoviPregledaDTO, HttpStatus.OK);
        }catch (ValueException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @PostMapping(path = "/pretrazi/{tip}/{datum}")
    @PreAuthorize("hasAuthority('PACIJENT')")
    public ResponseEntity pretraziDoktore( @RequestBody KlinikaDTO klinikaDTO, @PathVariable String tip, @PathVariable String datum) throws ParseException {


        if (klinikaDTO == null) {
            return new ResponseEntity("Niste uneli podatke", HttpStatus.BAD_REQUEST);
        }


        ArrayList<KlinikaDTO> klinikaDTOS  = doctorService.pretrziKlinike(klinikaDTO.getNaziv(), klinikaDTO.getAdresa(), tip, datum, klinikaDTO.getOcena());
        return new ResponseEntity<>(klinikaDTOS, HttpStatus.OK);

    }

    @PostMapping(path = "/oceni")
    @PreAuthorize("hasAuthority('PACIJENT')")
    public ResponseEntity oceniKliniku(@RequestBody OcenaKlinikeDTO ocenaKlinikeDTO){


        if (ocenaKlinikeDTO == null) {
            return new ResponseEntity("Niste uneli podatke", HttpStatus.BAD_REQUEST);
        }
        try {
            KlinikaDTO klinikaDTO = klinikaService.oceniKliniku(ocenaKlinikeDTO);
            return new ResponseEntity (klinikaDTO, HttpStatus.OK);
        }catch (ValueException | NoSuchElementException e ){
            return new ResponseEntity(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
