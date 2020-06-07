package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.AdministratorKlinickogCentra;
import com.example.demo.model.Authority;

public class AdminKlinickogCentraDTO {

	
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
	   private List<Authority> authorities;
	
	   public AdminKlinickogCentraDTO() {
		
	}

	public AdminKlinickogCentraDTO(AdministratorKlinickogCentra ad) {
		
		this.id = ad.getId();
		this.ime = ad.getIme();
		this.prezime = ad.getPrezime();
		this.email = ad.getEmail();
		this.lozinka = ad.getLozinka();
		this.adresa = ad.getAdresa();
		this.grad = ad.getGrad();
		this.drzava = ad.getDrzava();
		this.telefon = ad.getTelefon();
		this.jmbg = ad.getJmbg();
		this.authorities = (List<Authority>) ad.getAuthorities();
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

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	   
	
	   
	   
	   
}
