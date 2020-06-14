package com.example.demo.controller;

import com.example.demo.dto.KlinikaDTO;
import com.example.demo.dto.PacijentDTO;
import com.example.demo.dto.PregledDTO;
import com.example.demo.dto.ZdravstveniKartonDTO;
import com.example.demo.model.*;
import com.example.demo.service.PacijentService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.websocket.server.PathParam;
import javax.validation.ValidationException;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/pacijent")
public class PacijentController {

    @Autowired
    private PacijentService service;


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
