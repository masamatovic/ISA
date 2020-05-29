package com.example.demo.dto;

import com.example.demo.model.Klinika;
import com.example.demo.model.Sala;

import java.util.Date;

import javax.persistence.*;

public class SalaDTO {

    private Long id;

    private String naziv;

    private String broj;
    
    private boolean vrstaSale;
    
    private boolean zauzece;
    private Date datumZauzeca;

    public SalaDTO(Sala sala) {
        this.id = sala.getId();
        this.naziv = sala.getNaziv();
        this.broj = sala.getBroj();
        this.vrstaSale = sala.isVrstaSale();
        this.zauzece = sala.isZauzece();
        this.datumZauzeca = sala.getDatumZauzeca();
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

	public boolean isVrstaSale() {
		return vrstaSale;
	}

	public void setVrstaSale(boolean vrstaSale) {
		this.vrstaSale = vrstaSale;
	}

	public boolean isZauzece() {
		return zauzece;
	}

	public void setZauzece(boolean zauzece) {
		this.zauzece = zauzece;
	}

	public Date getDatumZauzeca() {
		return datumZauzeca;
	}

	public void setDatumZauzeca(Date datumZauzeca) {
		this.datumZauzeca = datumZauzeca;
	}
}
