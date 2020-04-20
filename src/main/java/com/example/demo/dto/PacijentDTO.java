package com.example.demo.dto;

import com.example.demo.model.Pacijent;

import javax.persistence.Id;

public class PacijentDTO {
    private Long id;
    private String ime;
    private String prezime;
    private String email;
    private String lozinka;
    private String adresa;
    private String drzava;
    private String grad;
    private String telefon;
    private String jmbg;

    public PacijentDTO() {
    }

    public PacijentDTO(Long id, String ime, String prezime, String email, String lozinka, String adresa, String drzava, String grad, String telefon, String jmbg) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.lozinka = lozinka;
        this.adresa = adresa;
        this.drzava = drzava;
        this.grad = grad;
        this.telefon = telefon;
        this.jmbg = jmbg;
    }
    public  PacijentDTO (Pacijent p){
        this.id = p.getId();
        this.ime = p.getIme();
        this.prezime = p.getPrezime();
        this.email = p.getEmail();
        this.lozinka = p.getLozinka();
        this.adresa = p.getAdresa();
        this.drzava = p.getDrzava();
        this.grad = p.getGrad();
        this.telefon = p.getTelefon();
        this.jmbg = p.getJmbg();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
}
