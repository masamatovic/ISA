package com.example.demo.controller;


import com.example.demo.dto.DoctorDTO;
import com.example.demo.dto.PacijentDTO;
import com.example.demo.dto.PregledDTO;
import com.example.demo.model.Klinika;
import com.example.demo.service.DoctorService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
@RequestMapping(value = "/doktor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping(path = "/izlistajDoktere/{id}")
    @PreAuthorize("hasAuthority('PACIJENT')")
    public ResponseEntity izlistajDoktore(@PathVariable Long id){

        if (id == null) {
            return new ResponseEntity("Ne postoji klinika sa ovim id-em", HttpStatus.BAD_REQUEST);
        }

        try {
            ArrayList<DoctorDTO> doctorDTOS  = doctorService.izlistajDoktore(id);
            return new ResponseEntity<>(doctorDTOS, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Ne postoji klinika sa ovim id-em!", HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping(path = "/pretrazi/{id}/{datum}")
    @PreAuthorize("hasAuthority('PACIJENT')")
    public ResponseEntity pretraziDoktore(@PathVariable Long id, @RequestBody DoctorDTO doctorDTO, @PathVariable String datum) throws ParseException {

        if (id == null) {
            return new ResponseEntity("Ne postoji klinika sa ovim id-em", HttpStatus.BAD_REQUEST);
        }

        if (doctorDTO == null) {
            return new ResponseEntity("Niste uneli podatke", HttpStatus.BAD_REQUEST);
        }


        ArrayList<DoctorDTO> doctorDTOS  = doctorService.pretrazi(doctorDTO.getIme(), doctorDTO.getPrezime(), doctorDTO.getTipPregleda().getNaziv(), datum, id);
        return new ResponseEntity<>(doctorDTOS, HttpStatus.OK);

    }

}
