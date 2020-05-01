package com.example.demo.model;


import com.example.demo.dto.PacijentDTO;

import javax.persistence.*;

@Entity
public class ZahtevZaRegistraciju {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(nullable = false)
   private String ime;
   @Column(nullable = false)
   private String prezime;
   @Column(nullable = false)
   private String email;
   @Column(nullable = false)
   private String lozinka;
   @Column(nullable = false)
   private String adresa;
   @Column(nullable = false)
   private String grad;
   @Column(nullable = false)
   private String drzava;
   @Column(nullable = false)
   private String telefon;
   @Column(nullable = false)
   private String jmbg;

   @Column(nullable = false)
   private Boolean odobren;


   public ZahtevZaRegistraciju() {
   }
   public ZahtevZaRegistraciju(PacijentDTO p) {
      this.ime = p.getIme();
      this.prezime = p.getPrezime();
      this.email = p.getEmail();
      this.lozinka = p.getLozinka();
      this.adresa= p.getAdresa();
      this.grad = p.getGrad();
      this.drzava = p.getDrzava();
      this.telefon = p.getTelefon();
      this.jmbg = p.getJmbg();
      this.odobren = false;
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

   public Boolean getOdobren() {
      return odobren;
   }

   public void setOdobren(Boolean odobren) {
      this.odobren = odobren;
   }
}