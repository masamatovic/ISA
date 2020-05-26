package com.example.demo.dto;

import com.example.demo.model.Klinika;
import com.example.demo.model.Sala;

import javax.persistence.*;

public class SalaDTO {

    private Long id;

    private String naziv;

    private String broj;

    public SalaDTO(Sala sala) {
        this.id = sala.getId();
        this.naziv = sala.getNaziv();
        this.broj = sala.getBroj();
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

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }
}
