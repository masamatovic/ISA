package com.example.demo.dto;


import com.example.demo.model.Doktor;

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
