package com.example.demo.dto;

import com.example.demo.model.Klinika;
import com.example.demo.model.OcenaKlinike;
import com.example.demo.model.Pacijent;

import javax.persistence.*;

public class OcenaKlinikeDTO {

    private Long id;
    private Integer ocena;
    private Long pacijent;
    private Long klinika;

    public OcenaKlinikeDTO() {

    }

    public OcenaKlinikeDTO(OcenaKlinike ocenaKlinike) {
        this.id = ocenaKlinike.getId();
        this.ocena = ocenaKlinike.getOcena();
        this.pacijent = ocenaKlinike.getPacijent().getId();
        this.klinika = ocenaKlinike.getKlinika().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public Long getPacijent() {
        return pacijent;
    }

    public void setPacijent(Long pacijent) {
        this.pacijent = pacijent;
    }

    public Long getKlinika() {
        return klinika;
    }

    public void setKlinika(Long klinika) {
        this.klinika = klinika;
    }
}
