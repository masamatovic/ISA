package com.example.demo.service;


import com.example.demo.dto.PacijentDTO;
import com.example.demo.model.Authority;
import com.example.demo.model.Pacijent;
import com.example.demo.model.ZahtevZaRegistraciju;
import com.example.demo.model.ZdravstveniKarton;
import com.example.demo.repository.AuthorityRepository;
import com.example.demo.repository.PacijentRepository;
import com.example.demo.repository.ZahtevZaRegistracijuRepository;
import com.example.demo.repository.ZdravstveniKartonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ZahtevZaRegistracijuService {

    @Autowired
    private ZahtevZaRegistracijuRepository zahtevZaRegistracijuRepository;

    @Autowired
    private ZdravstveniKartonRepository zdravstveniKartonRepository;

    @Autowired
    private PacijentRepository pacijentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityRepository authorityRepository;

    public ZahtevZaRegistraciju posaljiZahtev (PacijentDTO pacijentDTO){

        ZahtevZaRegistraciju provera = zahtevZaRegistracijuRepository.findByEmail(pacijentDTO.getEmail());
        if (provera != null){
            throw new ValidationException("Vec postoji korisnik sa ovim emailom");
        }

        ZahtevZaRegistraciju zahtevZaRegistraciju = new ZahtevZaRegistraciju(pacijentDTO);

        zahtevZaRegistracijuRepository.save(zahtevZaRegistraciju);
        return  zahtevZaRegistraciju;
    }

    public Pacijent odobriZahtev (String email){
        ZahtevZaRegistraciju zahtevZaRegistraciju = zahtevZaRegistracijuRepository.findByEmail(email);
        if (zahtevZaRegistraciju == null){
            throw new ValidationException("Ne postoji zahtev sa ovim id-em");
        }
        zahtevZaRegistraciju.setOdobren(true);
        //kreiranje novog pacijenta
        Pacijent pacijent = new Pacijent(zahtevZaRegistraciju);
        pacijent.setAktivan(false);
        pacijent.setLozinka(passwordEncoder.encode(pacijent.getLozinka()));

        //kreiranje praznog zdravstvenog kartona za pacijenta
        ZdravstveniKarton zdravstveniKarton = new ZdravstveniKarton();
        zdravstveniKartonRepository.save(zdravstveniKarton);
        pacijent.setZdravstveniKarton(zdravstveniKarton);
        pacijentRepository.save(pacijent);
        zahtevZaRegistracijuRepository.save(zahtevZaRegistraciju);
        return pacijent;

    }
    public ZahtevZaRegistraciju odbijZahtev (String email){
        ZahtevZaRegistraciju zahtevZaRegistraciju = zahtevZaRegistracijuRepository.findByEmail(email);
        if (zahtevZaRegistraciju == null){
            throw new ValidationException("Ne postoji zahtev sa ovim id-em");
        }
        zahtevZaRegistraciju.setOdobren(false);
        zahtevZaRegistracijuRepository.save(zahtevZaRegistraciju);
        return zahtevZaRegistraciju;

    }

    public Pacijent aktivacijaPacijenta(Long id){

        Pacijent pacijent = pacijentRepository.findById(id).orElse(null);
        if (pacijent == null){
            throw new ValidationException("Ne postoji pacijend sa ovim id-em");
        }
        pacijent.setAktivan(true);
        List<Authority> authorities= authorityRepository.findByUloga("PACIJENT");
        pacijent.setAuthorities(authorities);
        pacijentRepository.save(pacijent);
        return  pacijent;
    }

}
