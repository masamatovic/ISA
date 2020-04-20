package com.example.demo.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

/** @pdOid 387fc34c-1c83-4515-b3d6-6b89a40ef402 */

@Entity
public class Pacijent {
   /** @pdOid 029246ac-6c2b-40fe-8e17-320b8b1cc0a5 */
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   /** @pdOid d6e1c002-e540-4344-a867-fe78df844b24 */
   @Column(nullable = false)
   private String ime;
   /** @pdOid d3e392ed-332f-4d1b-87fa-27330c825e2f */
   @Column(nullable = false)
   private String prezime;
   /** @pdOid ef922d13-b5be-48c2-b4c7-aa61a6646584 */
   @Column(nullable = false)
   private String email;
   /** @pdOid 7b8f4bef-79ad-4f26-9b25-92e26385e86e */
   @Column(nullable = false)
   private String lozinka;
   /** @pdOid 4e928049-b70c-4b8e-8a49-5b4b03cb49e0 */
   @Column(nullable = false)
   private String adresa;
   /** @pdOid 231fb435-9dd0-41ea-9dd3-a033a966f6b2 */
   @Column(nullable = false)
   private String grad;
   /** @pdOid 9f13fa1e-12e4-43ff-a931-052fbf3af9b7 */
   @Column(nullable = false)
   private String drzava;
   /** @pdOid abecafb1-9bdc-4c6d-9076-1e3c95551093 */
   @Column(nullable = false)
   private String telefon;
   /** @pdOid b41f3dff-9493-49fd-b636-e52b1c8692be */
   @Column(nullable = false)
   private String jmbg;
   
   /** @pdRoleInfo migr=no name=ZdravstveniKarton assc=association9 mult=1..1 */
   //public ZdravstveniKarton zdravstveniKarton;
   /** @pdRoleInfo migr=no name=Pregled assc=association11 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   //public java.util.List<Pregled> pregled;
   /** @pdRoleInfo migr=no name=ZahtevZaPregled assc=association33 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   //public java.util.List<ZahtevZaPregled> zahtevZaPregled;


   public Pacijent() {
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