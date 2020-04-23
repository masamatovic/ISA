package com.example.demo.dto;

import com.example.demo.model.ZdravstveniKarton;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ZdravstveniKartonDTO {

    private Long id;
    private String dioptrija;
    private String pol;
    private String krvnaGrupa;
    private String visina;
    private String tezina;
    private String alergije;

    public ZdravstveniKartonDTO(Long id, String dioptrija, String pol, String krvnaGrupa, String visina, String tezina, String alergije) {
        this.id = id;
        this.dioptrija = dioptrija;
        this.pol = pol;
        this.krvnaGrupa = krvnaGrupa;
        this.visina = visina;
        this.tezina = tezina;
        this.alergije = alergije;
    }
    public ZdravstveniKartonDTO(ZdravstveniKarton zdravstveniKarton) {
        this.id = zdravstveniKarton.getId();
        this.dioptrija = zdravstveniKarton.getDioptrija();
        this.pol = zdravstveniKarton.getPol();
        this.krvnaGrupa = zdravstveniKarton.getKrvnaGrupa();
        this.visina = zdravstveniKarton.getVisina();
        this.tezina = zdravstveniKarton.getTezina();
        this.alergije = zdravstveniKarton.getAlergije();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDioptrija() {
        return dioptrija;
    }

    public void setDioptrija(String dioptrija) {
        this.dioptrija = dioptrija;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getKrvnaGrupa() {
        return krvnaGrupa;
    }

    public void setKrvnaGrupa(String krvnaGrupa) {
        this.krvnaGrupa = krvnaGrupa;
    }

    public String getVisina() {
        return visina;
    }

    public void setVisina(String visina) {
        this.visina = visina;
    }

    public String getTezina() {
        return tezina;
    }

    public void setTezina(String tezina) {
        this.tezina = tezina;
    }

    public String getAlergije() {
        return alergije;
    }

    public void setAlergije(String alergije) {
        this.alergije = alergije;
    }
}
