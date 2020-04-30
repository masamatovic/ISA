package com.example.demo.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class MedicinskaSestra implements UserDetails {

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
   @JoinTable(name = "sestra_authority",
           joinColumns = @JoinColumn(name = "sestra_id", referencedColumnName = "id"),
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

 /*  public java.util.List<ZahtevZaGodisnji> zahtevZaGodisnji;
   public java.util.List<Recept> recept;
 */
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
   public java.util.List<Recept> getRecept() {
      if (recept == null)
         recept = new java.util.ArrayList<Recept>();
      return recept;
   }
   
   public java.util.Iterator getIteratorRecept() {
      if (recept == null)
         recept = new java.util.ArrayList<Recept>();
      return recept.iterator();
   }
   
   public void setRecept(java.util.List<Recept> newRecept) {
      removeAllRecept();
      for (java.util.Iterator iter = newRecept.iterator(); iter.hasNext();)
         addRecept((Recept)iter.next());
   }
   
   public void addRecept(Recept newRecept) {
      if (newRecept == null)
         return;
      if (this.recept == null)
         this.recept = new java.util.ArrayList<Recept>();
      if (!this.recept.contains(newRecept))
      {
         this.recept.add(newRecept);
         newRecept.setMedicinskaSestra(this);      
      }
   }
   
   public void removeRecept(Recept oldRecept) {
      if (oldRecept == null)
         return;
      if (this.recept != null)
         if (this.recept.contains(oldRecept))
         {
            this.recept.remove(oldRecept);
            oldRecept.setMedicinskaSestra((MedicinskaSestra)null);
         }
   }
   
   public void removeAllRecept() {
      if (recept != null)
      {
         Recept oldRecept;
         for (java.util.Iterator iter = getIteratorRecept(); iter.hasNext();)
         {
            oldRecept = (Recept)iter.next();
            iter.remove();
            oldRecept.setMedicinskaSestra((MedicinskaSestra)null);
         }
      }
   }*/

}