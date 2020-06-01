package com.example.demo.dto;

import com.example.demo.model.*;

import javax.persistence.*;

public class PregledDTO {

    private Long id;
    private String datum;
    private String vreme;
    private String trajanje;
    private String cena;
    private String popust;
    private boolean odobren;
    private TipPregledaDTO tip;
    private SalaDTO sala;
    private DoctorDTO doktor;
    private PacijentDTO pacijent;
    private KlinikaDTO klinika;

    public PregledDTO(Pregled pregled) {
        this.id = pregled.getId();
        this.datum = pregled.getDatum();
        this.vreme = pregled.getVreme();
        this.trajanje = pregled.getTrajanje();
        this.cena = pregled.getCena();
        this.popust = pregled.getPopust();
        this.odobren= pregled.isOdobren();
        this.tip = new TipPregledaDTO(pregled.getTip());
        this.sala = new SalaDTO(pregled.getSala());
        this.doktor =new DoctorDTO(pregled.getDoktor());
        if (pregled.getPacijent() != null)
            this.pacijent = new PacijentDTO(pregled.getPacijent());
        this.klinika = new KlinikaDTO(pregled.getKlinika());
    }

    public Long getId() {
        return id;
    }

    public boolean isOdobren() {
        return odobren;
    }

    public void setOdobren(boolean odobren) {
        this.odobren = odobren;
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

    public String getPopust() {
        return popust;
    }

    public void setPopust(String popust) {
        this.popust = popust;
    }

    public TipPregledaDTO getTip() {
        return tip;
    }

    public void setTip(TipPregledaDTO tip) {
        this.tip = tip;
    }

    public SalaDTO getSala() {
        return sala;
    }

    public void setSala(SalaDTO sala) {
        this.sala = sala;
    }

    public DoctorDTO getDoktor() {
        return doktor;
    }

    public void setDoktor(DoctorDTO doktor) {
        this.doktor = doktor;
    }

    public PacijentDTO getPacijent() {
        return pacijent;
    }

    public void setPacijent(PacijentDTO pacijent) {
        this.pacijent = pacijent;
    }

    public KlinikaDTO getKlinika() {
        return klinika;
    }

    public void setKlinika(KlinikaDTO klinika) {
        this.klinika = klinika;
    }
}
