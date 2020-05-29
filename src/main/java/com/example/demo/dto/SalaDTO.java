package com.example.demo.dto;

import com.example.demo.model.Klinika;
import com.example.demo.model.Sala;

import javax.persistence.*;

public class SalaDTO {

    private Long id;

    private String naziv;

    private String broj;
    
    private boolean vrstaSale;

    public SalaDTO(Sala sala) {
        this.id = sala.getId();
        this.naziv = sala.getNaziv();
        this.broj = sala.getBroj();
        this.vrstaSale = sala.isVrstaSale();
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
}
