package com.example.demo.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Doktor implements UserDetails {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column
   private String ime;
   @Column
   private String prezime;
   @Column
   private String email;
   @Column
   private String lozinka;
   @Column
   private String adresa;
   @Column
   private String grad;
   @Column
   private String drzava;
   @Column
   private String telefon;
   @Column
   private String jmbg;

   @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
   @JoinTable(name = "doktor_authority",
           joinColumns = @JoinColumn(name = "doktor_id", referencedColumnName = "id"),
           inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
   private List<Authority> authorities;
   
   
  @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
   @JoinColumn(name = "klinika_id")
   private Klinika klinika;

   /*
   public java.util.List<ZahtevZaGodisnji> zahtevZaGodisnji;
   public java.util.List<Pregled> pregled;
   public java.util.List<ZahtevZaPregled> zahtevZaPregled;
   */

   public Doktor() {
	   
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

   public void setAuthorities(List<Authority> authorities) {
      this.authorities = authorities;
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return this.authorities;
   }

   @Override
   public String getPassword() {
      return this.lozinka;
   }

   @Override
   public String getUsername() {
      return this.email;
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return true;
   }


  /*
   public java.util.List<ZahtevZaGodisnji> getZahtevZaGodisnji() {
      if (zahtevZaGodisnji == null)
         zahtevZaGodisnji = new java.util.ArrayList<ZahtevZaGodisnji>();
      return zahtevZaGodisnji;
   }
   
   public java.util.Iterator getIteratorZahtevZaGodisnji() {
      if (zahtevZaGodisnji == null)
         zahtevZaGodisnji = new java.util.ArrayList<ZahtevZaGodisnji>();
      return zahtevZaGodisnji.iterator();
   }
   
   public void setZahtevZaGodisnji(java.util.List<ZahtevZaGodisnji> newZahtevZaGodisnji) {
      removeAllZahtevZaGodisnji();
      for (java.util.Iterator iter = newZahtevZaGodisnji.iterator(); iter.hasNext();)
         addZahtevZaGodisnji((ZahtevZaGodisnji)iter.next());
   }
   public void addZahtevZaGodisnji(ZahtevZaGodisnji newZahtevZaGodisnji) {
      if (newZahtevZaGodisnji == null)
         return;
      if (this.zahtevZaGodisnji == null)
         this.zahtevZaGodisnji = new java.util.ArrayList<ZahtevZaGodisnji>();
      if (!this.zahtevZaGodisnji.contains(newZahtevZaGodisnji))
         this.zahtevZaGodisnji.add(newZahtevZaGodisnji);
   }
   
   public void removeZahtevZaGodisnji(ZahtevZaGodisnji oldZahtevZaGodisnji) {
      if (oldZahtevZaGodisnji == null)
         return;
      if (this.zahtevZaGodisnji != null)
         if (this.zahtevZaGodisnji.contains(oldZahtevZaGodisnji))
            this.zahtevZaGodisnji.remove(oldZahtevZaGodisnji);
   }
   
   public void removeAllZahtevZaGodisnji() {
      if (zahtevZaGodisnji != null)
         zahtevZaGodisnji.clear();
   }

   public java.util.List<ZahtevZaPregled> getZahtevZaPregled() {
      if (zahtevZaPregled == null)
         zahtevZaPregled = new java.util.ArrayList<ZahtevZaPregled>();
      return zahtevZaPregled;
   }
   public java.util.Iterator getIteratorZahtevZaPregled() {
      if (zahtevZaPregled == null)
         zahtevZaPregled = new java.util.ArrayList<ZahtevZaPregled>();
      return zahtevZaPregled.iterator();
   }
   
   public void setZahtevZaPregled(java.util.List<ZahtevZaPregled> newZahtevZaPregled) {
      removeAllZahtevZaPregled();
      for (java.util.Iterator iter = newZahtevZaPregled.iterator(); iter.hasNext();)
         addZahtevZaPregled((ZahtevZaPregled)iter.next());
   }
   
   public void addZahtevZaPregled(ZahtevZaPregled newZahtevZaPregled) {
      if (newZahtevZaPregled == null)
         return;
      if (this.zahtevZaPregled == null)
         this.zahtevZaPregled = new java.util.ArrayList<ZahtevZaPregled>();
      if (!this.zahtevZaPregled.contains(newZahtevZaPregled))
         this.zahtevZaPregled.add(newZahtevZaPregled);
   }
   
   public void removeZahtevZaPregled(ZahtevZaPregled oldZahtevZaPregled) {
      if (oldZahtevZaPregled == null)
         return;
      if (this.zahtevZaPregled != null)
         if (this.zahtevZaPregled.contains(oldZahtevZaPregled))
            this.zahtevZaPregled.remove(oldZahtevZaPregled);
   }
   
   public void removeAllZahtevZaPregled() {
      if (zahtevZaPregled != null)
         zahtevZaPregled.clear();
   }*/

}