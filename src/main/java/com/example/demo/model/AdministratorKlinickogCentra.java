package com.example.demo.model; /***********************************************************************
 * Module:  AdministratorKlinickogCentra.java
 * Author:  Korisnik
 * Purpose: Defines the Class AdministratorKlinickogCentra
 ***********************************************************************/

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
public class AdministratorKlinickogCentra implements UserDetails {

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
   @JoinTable(name = "adminkc_authority",
           joinColumns = @JoinColumn(name = "adminkc_id", referencedColumnName = "id"),
           inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
   private List<Authority> authorities;

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

   /*public java.util.List<ZahtevZaRegistraciju> zahtevZaRegistraciju;


   public java.util.List<ZahtevZaRegistraciju> getZahtevZaRegistraciju() {
      if (zahtevZaRegistraciju == null)
         zahtevZaRegistraciju = new java.util.ArrayList<ZahtevZaRegistraciju>();
      return zahtevZaRegistraciju;
   }

   public java.util.Iterator getIteratorZahtevZaRegistraciju() {
      if (zahtevZaRegistraciju == null)
         zahtevZaRegistraciju = new java.util.ArrayList<ZahtevZaRegistraciju>();
      return zahtevZaRegistraciju.iterator();
   }

   public void setZahtevZaRegistraciju(java.util.List<ZahtevZaRegistraciju> newZahtevZaRegistraciju) {
      removeAllZahtevZaRegistraciju();
      for (java.util.Iterator iter = newZahtevZaRegistraciju.iterator(); iter.hasNext(); )
         addZahtevZaRegistraciju((ZahtevZaRegistraciju) iter.next());
   }

   public void addZahtevZaRegistraciju(ZahtevZaRegistraciju newZahtevZaRegistraciju) {
      if (newZahtevZaRegistraciju == null)
         return;
      if (this.zahtevZaRegistraciju == null)
         this.zahtevZaRegistraciju = new java.util.ArrayList<ZahtevZaRegistraciju>();
      if (!this.zahtevZaRegistraciju.contains(newZahtevZaRegistraciju))
         this.zahtevZaRegistraciju.add(newZahtevZaRegistraciju);
   }

   public void removeZahtevZaRegistraciju(ZahtevZaRegistraciju oldZahtevZaRegistraciju) {
      if (oldZahtevZaRegistraciju == null)
         return;
      if (this.zahtevZaRegistraciju != null)
         if (this.zahtevZaRegistraciju.contains(oldZahtevZaRegistraciju))
            this.zahtevZaRegistraciju.remove(oldZahtevZaRegistraciju);
   }

   public void removeAllZahtevZaRegistraciju() {
      if (zahtevZaRegistraciju != null)
         zahtevZaRegistraciju.clear();
   }*/

   public void setAuthorities(List<Authority> authorities) {
      this.authorities = authorities;
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return this.authorities;
   }

   @Override
   public String getPassword() {
      return lozinka;
   }

   @Override
   public String getUsername() {
      return email;
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
}