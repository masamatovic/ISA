package com.example.demo.controller;

import com.example.demo.dto.PacijentDTO;
import com.example.demo.model.Pacijent;
import com.example.demo.service.PacijentService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.xml.ws.Response;

@CrossOrigin
@RestController
@RequestMapping(value = "/pacijent")
public class PacijentController {

    @Autowired
    private PacijentService service;

    @PutMapping(path="/izmeni", consumes = "application/json", produces= "application/json")
    private ResponseEntity izmeni (@RequestBody PacijentDTO pacijentDTO){
        if (pacijentDTO!=null){
            try {
                return new ResponseEntity(pacijentDTO, HttpStatus.OK);
            }catch (ValueException e){
                return new ResponseEntity(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }
        return new ResponseEntity("Pogresan zahtev", HttpStatus.BAD_REQUEST);
    }
}
