package com.example.demo.controller;

import com.example.demo.dto.KlinikaDTO;
import com.example.demo.dto.TipPregledaDTO;
import com.example.demo.service.TipPregledaService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/tipPregleda", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipPregledaController {

    @Autowired
    TipPregledaService tipPregledaService;

    @GetMapping(value = "/izlistaj/{id}")
    public ResponseEntity izlistaj(@PathVariable Long id ){

        if (id == null){
            return new ResponseEntity("Id je null", HttpStatus.BAD_REQUEST);
        }
        try {
            TipPregledaDTO tipPregledaDTO = tipPregledaService.izlistajPregled(id);
            return new ResponseEntity (tipPregledaDTO, HttpStatus.OK);
        }catch (ValueException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
