package com.example.demo.service;
import com.example.demo.model.*;
import com.example.demo.repository.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    protected final Log LOGGER = LogFactory.getLog(getClass());
    @Autowired
    private AdminKCRepository adminKCRepository;

    @Autowired
    private AdminKlinikeRepository adminKlinikeRepository;

    @Autowired
    private SestraRepository sestraRepository;

    @Autowired
    private PacijentRepository pacijentRepository;

    @Autowired
    private DoktorRepository doktorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

   //vraca korisnika na osnovu emaila
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AdministratorKlinickogCentra administratorKlinickogCentra = adminKCRepository.findByEmail(username);
        AdministratorKlinike administratorKlinike = adminKlinikeRepository.findByEmail(username);
        Doktor doktor = doktorRepository.findByEmail(username);
        MedicinskaSestra medicinskaSestra = sestraRepository.findByEmail(username);
        Pacijent pacijent = pacijentRepository.findByEmail(username);

        if (administratorKlinickogCentra != null){
            return administratorKlinickogCentra;
        } else if (administratorKlinike != null){
            return administratorKlinike;
        } else if (doktor != null){
            return doktor;
        } else if (medicinskaSestra != null){
            return medicinskaSestra;
        } else if (pacijent != null){
            return pacijent;
        } else{
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }
    }

    // Funkcija pomocu koje korisnik menja svoju lozinku
   public void changePassword(String oldPassword, String newPassword) {

        // Ocitavamo trenutno ulogovanog korisnika
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String username = currentUser.getName();
        System.out.print(username);

        if (authenticationManager != null) {
            LOGGER.debug("Re-authenticating user '" + username + "' for password change request.");

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));
        } else {
            LOGGER.debug("No authentication manager set. can't change Password!");

            return;
        }

        LOGGER.debug("Changing password for user '" + username + "'");

        Object user = loadUserByUsername(username);

        if (user instanceof AdministratorKlinickogCentra){
            AdministratorKlinickogCentra adminKC = (AdministratorKlinickogCentra) user;
            adminKC.setLozinka(passwordEncoder.encode(newPassword));
            adminKCRepository.save(adminKC);
        } else if (user instanceof AdministratorKlinike){
            AdministratorKlinike administratorKlinike = (AdministratorKlinike) user;
            administratorKlinike.setLozinka(passwordEncoder.encode(newPassword));
            adminKlinikeRepository.save(administratorKlinike);
        } else if (user instanceof Doktor){
            Doktor doktor = (Doktor) user;
            doktor.setLozinka(passwordEncoder.encode(newPassword));
            doktorRepository.save(doktor);
        }else if (user instanceof MedicinskaSestra){
            MedicinskaSestra medicinskaSestra = (MedicinskaSestra) user;
            medicinskaSestra.setLozinka(passwordEncoder.encode(newPassword));
            sestraRepository.save(medicinskaSestra);
        }else if (user instanceof Pacijent){
            Pacijent pacijent = (Pacijent) user;
            pacijent.setLozinka(passwordEncoder.encode(newPassword));
            pacijentRepository.save(pacijent);
        }


    }
}