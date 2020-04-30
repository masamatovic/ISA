package com.example.demo.service;


import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Media;

@Service
public class LoginService {

    @Autowired
    private AdminKCRepository adminKCRepository;
    @Autowired
    private AdminKlinikeRepository adminKlinikeRepository;
    @Autowired
    private DoktorRepository doktorRepository;
    @Autowired
    private SestraRepository sestraRepository;
    @Autowired
    private PacijentRepository pacijentRepository;

    public AdministratorKlinickogCentra izlistajAdminaKC(String email){
        return adminKCRepository.findByEmail(email);
    }
    public AdministratorKlinike izlistajAdminaKlinike (String email){
        return adminKlinikeRepository.findByEmail(email);
    }
    public Doktor izlistajDoktora(String email){
        return doktorRepository.findByEmail(email);
    }
    public MedicinskaSestra izlistaSestru(String email){
        return sestraRepository.findByEmail(email);
    }
    public Pacijent izlistajPacijenta (String email){
        return pacijentRepository.findByEmail(email);
    }
}
