package com.example.demo.controller;

import com.example.demo.dto.PregledDTO;
import com.example.demo.service.EmailService;
import com.example.demo.service.PregledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.NoSuchElementException;


@CrossOrigin
@RestController
@RequestMapping(value = "/pregled")
public class PregledController {

    @Autowired
    PregledService pregledService;

    @Autowired
    EmailService emailService;

    @GetMapping(path = "/izlistajUDPreglede/{id}")
    @PreAuthorize("hasAuthority('ADMIN_KCENTRA') or hasAuthority('PACIJENT')")
    public ResponseEntity izlistajUnapredDefPreglede(@PathVariable Long id) {
        try {
            ArrayList<PregledDTO> preglediDTO  = pregledService.izlistajUnapredDefPreglede(id);
            return new ResponseEntity<>(preglediDTO, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Ne postoji klinika sa ovim id-em!", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path="/reservisiUD/{pregled_id}/{pacijent_id}")
    @PreAuthorize("hasAuthority('PACIJENT')")
    public ResponseEntity zakaziUDPregled(@PathVariable Long pregled_id, @PathVariable Long pacijent_id) {

        if (pregled_id == null) {
            return new ResponseEntity("Ne postoji pregled sa ovim id-em", HttpStatus.BAD_REQUEST);
        }
        if (pacijent_id == null) {
            return new ResponseEntity("Ne postoji pacijent sa ovim id-em", HttpStatus.BAD_REQUEST);
        }

        try {
            PregledDTO pregledDTO = pregledService.zakaziUDPregled(pacijent_id, pregled_id);

            try {
                emailService.posaljiMail(pregledDTO);
            } catch (MailException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return new ResponseEntity<>(pregledDTO, HttpStatus.OK);
        } catch (ValidationException | NoSuchElementException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
