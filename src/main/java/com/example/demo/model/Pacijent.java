package com.example.demo.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/** @pdOid 387fc34c-1c83-4515-b3d6-6b89a40ef402 */

@Entity
public class Pacijent implements UserDetails {
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
   
   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "karton_id", referencedColumnName = "id")
   public ZdravstveniKarton zdravstveniKarton;

   //public java.util.List<Pregled> pregled;
   //public java.util.List<ZahtevZaPregled> zahtevZaPregled;

   @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
   @JoinTable(name = "pacijent_authority",
           joinColumns = @JoinColumn(name = "pacijent_id", referencedColumnName = "id"),
           inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
   private List<Authority> authorities;


   public Pacijent() {
   }

   public ZdravstveniKarton getZdravstveniKarton() {
      return zdravstveniKarton;
   }

   public void setZdravstveniKarton(ZdravstveniKarton zdravstveniKarton) {
      this.zdravstveniKarton = zdravstveniKarton;
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
   public java.util.List<Pregled> getPregled() {
      if (pregled == null)
         pregled = new java.util.ArrayList<Pregled>();
      return pregled;
   }
   

   public java.util.Iterator getIteratorPregled() {
      if (pregled == null)
         pregled = new java.util.ArrayList<Pregled>();
      return pregled.iterator();
   }
   


   public void setPregled(java.util.List<Pregled> newPregled) {
      removeAllPregled();
      for (java.util.Iterator iter = newPregled.iterator(); iter.hasNext();)
         addPregled((Pregled)iter.next());
   }
   


   public void addPregled(Pregled newPregled) {
      if (newPregled == null)
         return;
      if (this.pregled == null)
         this.pregled = new java.util.ArrayList<Pregled>();
      if (!this.pregled.contains(newPregled))
         this.pregled.add(newPregled);
   }
   


   public void removePregled(Pregled oldPregled) {
      if (oldPregled == null)
         return;
      if (this.pregled != null)
         if (this.pregled.contains(oldPregled))
            this.pregled.remove(oldPregled);
   }
   

   public void removeAllPregled() {
      if (pregled != null)
         pregled.clear();
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