package com.example.demo.dto;

import com.example.demo.model.Klinika;

import javax.persistence.Column;

public class KlinikaDTO {
    private Long id;
    private String naziv;
    private String adresa;
    private String grad;
    private String drzava;
    private String opis;
    private Double ocena;
    private String cena;

    public KlinikaDTO() {
    }
    public KlinikaDTO(Klinika klinika) {
        this.id = klinika.getId();
        this.naziv = klinika.getNaziv();
        this.adresa = klinika.getAdresa();
        this.grad = klinika.getGrad();
        this.drzava = klinika.getDrzava();
        this.opis = klinika.getOpis();
        this.ocena = klinika.getOcena();
    }

    public Double getOcena() {
        return ocena;
    }

    public void setOcena(Double ocena) {
        this.ocena = ocena;
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }
}
