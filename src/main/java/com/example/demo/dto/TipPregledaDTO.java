package com.example.demo.dto;

import com.example.demo.model.TipPregleda;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TipPregledaDTO {

    private Long id;

    private String naziv;

    private String cena;

    public TipPregledaDTO(TipPregleda tipPregleda) {
        this.id = tipPregleda.getId();
        this.naziv = tipPregleda.getNaziv();
        this.cena = tipPregleda.getCena();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }
}
