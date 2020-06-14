package com.example.demo.controller;

import com.example.demo.dto.ZahtevZaPregledDTO;
import com.example.demo.model.ZahtevZaPregled;
import com.example.demo.service.EmailService;
import com.example.demo.service.ZahtevZaPregledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;

@CrossOrigin
@RestController
@RequestMapping(value = "/zahtevZaPregled", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZahtevZaPregledController {

    @Autowired
    ZahtevZaPregledService zahtevZaPregledService;

    @Autowired
    EmailService emailService;

    @PostMapping("/posalji")
    @PreAuthorize("hasAuthority('PACIJENT')")
    public ResponseEntity dodajZahtev (@RequestBody ZahtevZaPregledDTO zahtevZaPregledDTO){
        try {
            ZahtevZaPregled zahtevZaPregled = zahtevZaPregledService.napraviZahtev(zahtevZaPregledDTO);
            try {
                emailService.posaljiMail(zahtevZaPregledDTO.getKlinika());
            } catch (MailException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
            e.printStackTrace();
        }
            return new ResponseEntity(new ZahtevZaPregledDTO(zahtevZaPregled), HttpStatus.OK);
        }catch (ValidationException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
