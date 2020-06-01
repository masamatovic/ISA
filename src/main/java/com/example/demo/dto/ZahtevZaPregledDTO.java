package com.example.demo.dto;

import com.example.demo.model.*;

import javax.persistence.*;

public class ZahtevZaPregledDTO {

    private Long id;
    private String datum;
    private String vreme;
    private String trajanje;
    private String cena;
    private boolean odobren;
    private Long tip;
    private Long doktor;
    private Long pacijent;
    private Long klinika;

    public ZahtevZaPregledDTO() {

    }

    public ZahtevZaPregledDTO(ZahtevZaPregled zahtevZaPregled) {
        this.id = zahtevZaPregled.getId();
        this.datum = zahtevZaPregled.getDatum();
        this.vreme = zahtevZaPregled.getVreme();
        this.trajanje = zahtevZaPregled.getTrajanje();
        this.cena = zahtevZaPregled.getCena();
        this.odobren = zahtevZaPregled.isOdobren();
        this.tip = zahtevZaPregled.getTip().getId();
        this.doktor = zahtevZaPregled.getDoktor().getId();
        this.pacijent = zahtevZaPregled.getPacijent().getId();
        this.klinika = zahtevZaPregled.getKlinika().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public String getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(String trajanje) {
        this.trajanje = trajanje;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public boolean isOdobren() {
        return odobren;
    }

    public void setOdobren(boolean odobren) {
        this.odobren = odobren;
    }

    public Long getTip() {
        return tip;
    }

    public void setTip(Long tip) {
        this.tip = tip;
    }

    public Long getDoktor() {
        return doktor;
    }

    public void setDoktor(Long doktor) {
        this.doktor = doktor;
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
