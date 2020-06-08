package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PacijentDTO;
import com.example.demo.dto.ZdravstveniKartonDTO;
import com.example.demo.model.Klinika;
import com.example.demo.model.Pacijent;
import com.example.demo.service.KlinikaService;
import com.example.demo.service.PacijentService;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

@CrossOrigin
@RestController
@RequestMapping(value = "/pacijent")
public class PacijentController {

    @Autowired
    private PacijentService service;
    @Autowired
    private KlinikaService klinikaService;


    @GetMapping(path = "/izlistajPacijenta/{id}")
    @PreAuthorize("hasAuthority('PACIJENT')")
    public ResponseEntity izlistajPacijenta(@PathVariable Long id){
        PacijentDTO pacijentDTO = service.izlistajPacijenta(id);
        if (pacijentDTO!=null){
            try {
                return new ResponseEntity(pacijentDTO, HttpStatus.OK);
            }catch (ValueException e){
                return new ResponseEntity(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }
        return new ResponseEntity("Pogresan zahtev", HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping(path = "/izlistajSvePacijenteKlinike/{clinicId}")
    @PreAuthorize("hasAuthority('DOKTOR')")
    public ResponseEntity<?> izlistajSvePacijente(@PathVariable Long clinicId){
    	Klinika klinika =  klinikaService.findClinic(clinicId) ;
    	
    	ArrayList<Pacijent> listP = (ArrayList<Pacijent>) klinika.getPacijenti();
    	ArrayList<PacijentDTO> listPDTO = new ArrayList<PacijentDTO>();
    	
    	for(Pacijent p : listP) {
    		listPDTO.add(new PacijentDTO(p));
    	}
    	
    	return new ResponseEntity<> (listPDTO,HttpStatus.OK);
    }
    
    @PutMapping(path="/izmeni", consumes = "application/json", produces= "application/json")
    @PreAuthorize("hasAuthority('PACIJENT')")
    public ResponseEntity izmeni (@RequestBody PacijentDTO pacijentDTO){

        if (pacijentDTO!=null){
            try {
                service.izmeni(pacijentDTO);
                return new ResponseEntity(pacijentDTO, HttpStatus.OK);
            }catch (ValueException e){
                return new ResponseEntity(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }
        return new ResponseEntity("Pogresan zahtev", HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/izlistajKarton/{id}", produces = "application/json")
    @PreAuthorize("hasAuthority('PACIJENT')")
    public ResponseEntity izlistajKarton(@PathVariable Long id){
        try {
            ZdravstveniKartonDTO zdravstveniKartonDTO = service.izlistajKarton(id);
            return new ResponseEntity(zdravstveniKartonDTO, HttpStatus.OK);
        }catch (ValueException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
