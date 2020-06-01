package com.example.demo.dto;


import com.example.demo.model.Doktor;

import javax.persistence.Column;
import java.util.ArrayList;

public class DoctorDTO {
	private Long id;	   
	private String ime;	   
	private String prezime;
	private String email;
	private String lozinka;	   
	private String adresa;	   
	private String grad;	   
	private String drzava;	   
	private String telefon;	   
	private String jmbg;
	private Long tipPregleda;
	private String pocetakRadnogVremena;
	private String krajRadnogVremena;
	private ArrayList<String> zauzetiSati;
	
	public DoctorDTO() {
		
	}
	
	public DoctorDTO(Doktor d) {
		this.id=d.getId();
		this.ime=d.getIme();
		this.prezime=d.getPrezime();
		this.email=d.getEmail();
		this.lozinka=d.getLozinka();
		this.adresa=d.getAdresa();
		this.grad=d.getGrad();
		this.drzava=d.getDrzava();
		this.telefon=d.getTelefon();
		this.jmbg=d.getJmbg();
		this.tipPregleda = d.getTipPregleda();
		this.pocetakRadnogVremena = d.getPocetakRadnogVremena();
		this.krajRadnogVremena = d.getKrajRadnogVremena();
		this.zauzetiSati = new ArrayList<>();

	}

	public ArrayList<String> getZauzetiSati() {
		return zauzetiSati;
	}

	public void setZauzetiSati(ArrayList<String> zauzetiSati) {
		this.zauzetiSati = zauzetiSati;
	}

	public String getPocetakRadnogVremena() {
		return pocetakRadnogVremena;
	}

	public void setPocetakRadnogVremena(String pocetakRadnogVremena) {
		this.pocetakRadnogVremena = pocetakRadnogVremena;
	}

	public String getKrajRadnogVremena() {
		return krajRadnogVremena;
	}

	public void setKrajRadnogVremena(String krajRadnogVremena) {
		this.krajRadnogVremena = krajRadnogVremena;
	}

	public Long getTipPregleda() {
		return tipPregleda;
	}

	public void setTipPregleda(Long tipPregleda) {
		this.tipPregleda = tipPregleda;
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
