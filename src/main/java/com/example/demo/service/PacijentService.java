package com.example.demo.service;


import com.example.demo.dto.PacijentDTO;
import com.example.demo.dto.ZdravstveniKartonDTO;
import com.example.demo.model.Pacijent;
import com.example.demo.model.ZahtevZaRegistraciju;
import com.example.demo.model.ZdravstveniKarton;
import com.example.demo.repository.PacijentRepository;
import com.example.demo.repository.ZahtevZaRegistracijuRepository;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.EntityNotFoundException;


@Service
public class PacijentService {

    @Autowired
    private PacijentRepository repository;

    public PacijentDTO izlistajPacijenta(Long id){
        Pacijent p = repository.findById(id).orElse(null);
        if (p == null){
            throw new  ValueException("Pacijent sa datim id-em ne postoji");
        }
        return new PacijentDTO(p);

    }
    public PacijentDTO izlistajPacijenta(String email){
        Pacijent p = repository.findByEmail(email);
        if (p==null){
            return null;
        }
        return new PacijentDTO(p);

    }

    public Pacijent izmeni( PacijentDTO pdto){
        Pacijent p = repository.findById(pdto.getId()).orElse(null);
        if (p == null){
            throw new  ValueException("Pacijent sa datim id-em ne postoji");
        }
        try {
            p.setIme(pdto.getIme());
            p.setPrezime(pdto.getPrezime());
            p.setAdresa(pdto.getAdresa());
            p.setDrzava(pdto.getDrzava());
            p.setGrad(pdto.getGrad());
            p.setTelefon(pdto.getTelefon());
            this.repository.save(p);
        }catch (EntityNotFoundException e){
            throw new ValueException("Pacijent sa datim id-em ne postoji");
        }
        return p;
    }

    public ZdravstveniKartonDTO izlistajKarton(Long id){
        if (id == null){
            throw new  ValueException("Pacijent sa datim id-em ne postoji");
        }
        Pacijent p = repository.findById(id).orElse(null);
        if (p == null){
            throw new  ValueException("Pacijent sa datim id-em ne postoji");
        }
        ZdravstveniKarton zk = p.getZdravstveniKarton();
        if (zk == null){
            throw new  ValueException("Zdravstevni karton sa datim id-em ne postoji");
        }
        ZdravstveniKartonDTO zdravstveniKartonDTO = new ZdravstveniKartonDTO(zk);
        return zdravstveniKartonDTO;

    }
    public List<Pacijent> izlistajPoVrednosti (String vrednost){

        if (vrednost.equals("ime"))
            return repository.findAllByOrderByImeAsc();
        else if (vrednost.equals("prezime"))
            return repository.findAllByOrderByPrezimeAsc();
        else if(vrednost.equals("jmbg"))
        	return repository.findAllByOrderByJmbgAsc();
        else
            return repository.findAll();

   }

}
