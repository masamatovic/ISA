package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Authority;
import com.example.demo.model.MedicinskaSestra;

public class MedicinskaSestraDTO {

	
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
	   
	   
	   public MedicinskaSestraDTO() {
			
		}
	   
	   



	public MedicinskaSestraDTO(MedicinskaSestra md) {
		super();
		this.id = md.getId();
		this.ime = md.getIme();
		this.prezime = md.getPrezime();
		this.email = md.getEmail();
		this.lozinka = md.getLozinka();
		this.adresa = md.getAdresa();
		this.grad = md.getGrad();
		this.drzava = md.getDrzava();
		this.telefon = md.getTelefon();
		this.jmbg = md.getJmbg();
		this.authorities = (List<Authority>) md.getAuthorities();
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
