package com.example.demo.controller;

import com.example.demo.dto.ZdravstveniKartonDTO;
import com.example.demo.model.Pacijent;
import com.example.demo.model.ZahtevZaRegistraciju;
import com.example.demo.service.EmailService;
import com.example.demo.service.PacijentService;
import com.example.demo.service.ZahtevZaRegistracijuService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "/registracija", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegistracijaController {

    @Autowired
    private PacijentService pacijentService;
    @Autowired
    private ZahtevZaRegistracijuService zaRegistracijuService;
    @Autowired
    private EmailService emailService;

    @PutMapping("/prihvatiZahtev")
    @PreAuthorize("hasAuthority('ADMIN_KCENTRA')")
    public ResponseEntity prihvatiZahtev(@RequestBody ZahtevZaRegistraciju zaRegistraciju){

        if (zaRegistraciju == null){
            return new ResponseEntity("Poslali ste pogresan zahtev", HttpStatus.BAD_REQUEST);
        }

        Pacijent prihvaceniPacijent = new Pacijent();
        try{
            prihvaceniPacijent = zaRegistracijuService.odobriZahtev(zaRegistraciju.getEmail());
        }catch (ValidationException e){
            return new ResponseEntity("Ne postoji zahtev sa ovim emailom", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
            emailService.posaljiMail(prihvaceniPacijent);
        } catch (MailException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(prihvaceniPacijent, HttpStatus.OK);

    }
    @PutMapping("/odbijZahtev/{poruka}")
    @PreAuthorize("hasAuthority('ADMIN_KCENTRA')")
    public ResponseEntity obijZahtev(@RequestBody ZahtevZaRegistraciju zaRegistraciju, @PathVariable String poruka){

        if (zaRegistraciju == null){
            return new ResponseEntity("Poslali ste pogresan zahtev", HttpStatus.BAD_REQUEST);
        }

        ZahtevZaRegistraciju odbijeniZahtev = new ZahtevZaRegistraciju();
        try{
           zaRegistracijuService.odbijZahtev(zaRegistraciju.getEmail());
        }catch (ValidationException e){
            return new ResponseEntity("Ne postoji zahtev sa ovim emailom", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
            emailService.posaljiMail(zaRegistraciju, poruka);
        } catch (MailException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ResponseEntity("Zahtev je odbijen", HttpStatus.OK);

    }

    @GetMapping(path = "/izlistajZahteve", produces = "application/json")
    @PreAuthorize("hasAuthority('ADMIN_KCENTRA')")
    public ResponseEntity izlistajKarton(){

        List<ZahtevZaRegistraciju> zahtevZaRegistracijus =  zaRegistracijuService.izlistajSve();
        return new ResponseEntity(zahtevZaRegistracijus, HttpStatus.OK);

    }


}
