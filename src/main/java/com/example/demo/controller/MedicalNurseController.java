package com.example.demo.controller;

import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.MedicinskaSestraDTO;
import com.example.demo.dto.ReceptDTO;
import com.example.demo.model.Pacijent;
import com.example.demo.service.MedicinskaSestraService;
import com.example.demo.service.PacijentService;
import com.example.demo.service.ReceptService;
import com.example.demo.service.ZahtevZaPregledService;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class MedicalNurseController {

	@Autowired
    private PacijentService pacijentService;
	
	@Autowired
    private MedicinskaSestraService msService;
	
	@Autowired
	private ZahtevZaPregledService zzpService;
	
	@Autowired
	private ReceptService receptService;
	
	
	@GetMapping(path = "/izlistajPacijente/")
    @PreAuthorize("hasAuthority('MEDICINSKA_SESTRA')")
    public ResponseEntity izlistajDoktore(@PathVariable String vrednost){

        if (vrednost == null) {
            return new ResponseEntity("Niste uneli vrednost", HttpStatus.BAD_REQUEST);
        }

        try {
            List<Pacijent> listaPacijenata= pacijentService.izlistajPoVrednosti(vrednost);
            return new ResponseEntity<>(listaPacijenata, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Nema pacijenata", HttpStatus.NOT_FOUND);
        }
    }
	
	@GetMapping(path = "/prikaziSestru/{id}")
    @PreAuthorize("hasAuthority('MEDICINSKA_SESTRA')")
    public ResponseEntity prikaziSestru(@PathVariable Long id){
        MedicinskaSestraDTO msDTO = msService.getSestra(id);
        if (msDTO!=null){
            try {
                return new ResponseEntity(msDTO, HttpStatus.OK);
            }catch (ValueException e){
                return new ResponseEntity(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }
        return new ResponseEntity("Pogresan zahtev", HttpStatus.BAD_REQUEST);
    }
	/*
	@PostMapping(path = "/zakaziZahtev")
    @PreAuthorize("hasAuthority('MEDICINSKA_SESTRA')")
    public ResponseEntity pretraziDoktore(@RequestBody ZahtevZaPregledDTO zahtevDTO) throws ParseException {

        
        
        
        	try {
        		ZahtevZaPregled zzp= zzpService.napraviZahtev(zahtevDTO);
        		return new ResponseEntity(zzp, HttpStatus.OK);
        	}catch(ValueException e) {
        		return new ResponseEntity(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        	}
        	
        
        
        
        
    }*/
	
	@PostMapping(path = "/overiRecept/")
    @PreAuthorize("hasAuthority('MEDICINSKA_SESTRA')")
	public ResponseEntity overiRecept(@RequestBody ReceptDTO receptDTO) throws ParseException {

        
        
        
    	try {
    		ReceptDTO rDTO = receptService.overiRecept(receptDTO.getId());
    		return new ResponseEntity(rDTO, HttpStatus.OK);
    	}catch(ValueException e) {
    		return new ResponseEntity(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    	}
    	
    
    
    
    
}
	
	
	
	
}
