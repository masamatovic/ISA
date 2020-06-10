package com.example.demo.dto;

import com.example.demo.model.Doktor;
import com.example.demo.model.OcenaDoktora;
import com.example.demo.model.Pacijent;

import javax.persistence.*;

public class OcenaDoktoraDTO {

    private Long id;
    private Integer ocena;
    private Long pacijent;
    private Long doktor;

    public OcenaDoktoraDTO() {
    }

    public OcenaDoktoraDTO(OcenaDoktora doktor) {
        this.id = doktor.getId();
        this.ocena = doktor.getOcena();
        this.pacijent = doktor.getPacijent().getId();
        this.doktor = doktor.getDoktor().getId();
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

    public Long getDoktor() {
        return doktor;
    }

    public void setDoktor(Long doktor) {
        this.doktor = doktor;
    }
}
