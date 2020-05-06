package com.example.demo.dto;

import com.example.demo.model.AdministratorKlinike;
import com.example.demo.model.Klinika;

public class AdminClinicDTO {

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

 
   private Klinika klinika;
   
   public AdminClinicDTO() {
	   
   }
   //konstrukot sa objekorm administratoraKlinike
   public AdminClinicDTO(AdministratorKlinike adminClinic) {
	   this.id=adminClinic.getId();
	   this.ime=adminClinic.getIme();
	   this.prezime=adminClinic.getPrezime();
	   this.email=adminClinic.getEmail();
	   this.lozinka=adminClinic.getLozinka();
	   this.adresa=adminClinic.getAdresa();
	   this.grad=adminClinic.getGrad();
	   this.drzava=adminClinic.getDrzava();
	   this.telefon=adminClinic.getTelefon();
	   this.jmbg = adminClinic.getJmbg();
	   
	   this.klinika=adminClinic.getKlinika();
	   
   }

   //konstruktor sa parametrima
   public AdminClinicDTO(Long id, String ime, String prezime, String email, String lozinka, String adresa, String drzava, String grad, String telefon, String jmbg) {
		   
		   this.id=id;
		   this.ime=ime;
		   this.prezime=prezime;
		   this.email=email;
		   this.lozinka = lozinka;
		   this.adresa = adresa;
		   this.grad= grad;
		   this.drzava=drzava;
		   this.telefon= telefon;
		   this.jmbg=jmbg;
		   
	   }

	
   //getters and setters
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
	public Klinika getKlinika() {
		return klinika;
	}
	public void setKlinika(Klinika klinika) {
		this.klinika = klinika;
	}

	   


}
