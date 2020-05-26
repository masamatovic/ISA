package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/** @pdOid f5c64885-5972-4252-9cf9-77a1412a0dc2 */
@Entity
public class Klinika {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(nullable = false)
   private String naziv;

   @Column(nullable = false)
   private String adresa;

   @Column(nullable = false)
   private String grad;

   @Column(nullable = false)
   private String drzava;

   @Column(nullable = false)
   private String opis;
   
   //administrator klinike
   @OnDelete(action = OnDeleteAction.CASCADE)
   @OneToMany(mappedBy = "klinika", fetch = FetchType.LAZY)
   private List<AdministratorKlinike> administratorKlinike;

   @OnDelete(action = OnDeleteAction.CASCADE)
   @OneToMany(mappedBy = "klinika", fetch = FetchType.LAZY)
   private List<Doktor> doktor;

   @OnDelete(action = OnDeleteAction.CASCADE)
   @OneToMany(mappedBy = "klinika", fetch = FetchType.LAZY)
   public java.util.Collection<Sala> sala;

   @OnDelete(action = OnDeleteAction.CASCADE)
   @OneToMany(mappedBy = "klinika", fetch = FetchType.LAZY)
   private List<TipPregleda> tipPregleda;


   /*

   public java.util.Collection<AdministratorKlinickogCentra> administratorKlinickogCentra;


   public java.util.Collection<Pacijent> pacijent;

   public java.util.List<MedicinskaSestra> medicinskaSestra;


   public java.util.List<Pregled> pregled;*/

   public Klinika() {
   }

   public List<AdministratorKlinike> getAdministratorKlinike() {
	return administratorKlinike;
   }

   public void setAdministratorKlinike(List<AdministratorKlinike> administratorKlinike) {
	this.administratorKlinike = administratorKlinike;
	}

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getNaziv() {
      return naziv;
   }

   public void setNaziv(String naziv) {
      this.naziv = naziv;
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

   public String getOpis() {
      return opis;
   }

   public void setOpis(String opis) {
      this.opis = opis;
   }

   public java.util.Collection<Sala> getSala() {
      if (sala == null)
         sala = new java.util.HashSet<Sala>();
      return sala;
   }

   public java.util.Iterator getIteratorSala() {
      if (sala == null)
         sala = new java.util.HashSet<Sala>();
      return sala.iterator();
   }

   public void setSala(java.util.Collection<Sala> newSala) {
      removeAllSala();
      for (java.util.Iterator iter = newSala.iterator(); iter.hasNext();)
         addSala((Sala)iter.next());
   }

   public void addSala(Sala newSala) {
      if (newSala == null)
         return;
      if (this.sala == null)
         this.sala = new java.util.HashSet<Sala>();
      if (!this.sala.contains(newSala))
      {
         this.sala.add(newSala);
         newSala.setKlinika(this);
      }
   }

   public void removeSala(Sala oldSala) {
      if (oldSala == null)
         return;
      if (this.sala != null)
         if (this.sala.contains(oldSala))
         {
            this.sala.remove(oldSala);
            oldSala.setKlinika((Klinika)null);
         }
   }

   public void removeAllSala() {
      if (sala != null)
      {
         Sala oldSala;
         for (java.util.Iterator iter = getIteratorSala(); iter.hasNext();)
         {
            oldSala = (Sala)iter.next();
            iter.remove();
            oldSala.setKlinika((Klinika)null);
         }
      }
   }
   public java.util.List<Doktor> getDoktor() {
      if (doktor == null)
         doktor = new java.util.ArrayList<Doktor>();
      return doktor;
   }

   public java.util.Iterator getIteratorDoktor() {
      if (doktor == null)
         doktor = new java.util.ArrayList<Doktor>();
      return doktor.iterator();
   }

   public void setDoktor(java.util.List<Doktor> newDoktor) {
      removeAllDoktor();
      for (java.util.Iterator iter = newDoktor.iterator(); iter.hasNext();)
         addDoktor((Doktor)iter.next());
   }

   public void addDoktor(Doktor newDoktor) {
      if (newDoktor == null)
         return;
      if (this.doktor == null)
         this.doktor = new java.util.ArrayList<Doktor>();
      if (!this.doktor.contains(newDoktor))
         this.doktor.add(newDoktor);
   }

   public void removeDoktor(Doktor oldDoktor) {
      if (oldDoktor == null)
         return;
      if (this.doktor != null)
         if (this.doktor.contains(oldDoktor))
            this.doktor.remove(oldDoktor);
   }

   public void removeAllDoktor() {
      if (doktor != null)
         doktor.clear();
   }

 /*
   public java.util.Collection<AdministratorKlinickogCentra> getAdministratorKlinickogCentra() {
      if (administratorKlinickogCentra == null)
         administratorKlinickogCentra = new java.util.HashSet<AdministratorKlinickogCentra>();
      return administratorKlinickogCentra;
   }
   

   public java.util.Iterator getIteratorAdministratorKlinickogCentra() {
      if (administratorKlinickogCentra == null)
         administratorKlinickogCentra = new java.util.HashSet<AdministratorKlinickogCentra>();
      return administratorKlinickogCentra.iterator();
   }
   

   public void setAdministratorKlinickogCentra(java.util.Collection<AdministratorKlinickogCentra> newAdministratorKlinickogCentra) {
      removeAllAdministratorKlinickogCentra();
      for (java.util.Iterator iter = newAdministratorKlinickogCentra.iterator(); iter.hasNext();)
         addAdministratorKlinickogCentra((AdministratorKlinickogCentra)iter.next());
   }
   

   public void addAdministratorKlinickogCentra(AdministratorKlinickogCentra newAdministratorKlinickogCentra) {
      if (newAdministratorKlinickogCentra == null)
         return;
      if (this.administratorKlinickogCentra == null)
         this.administratorKlinickogCentra = new java.util.HashSet<AdministratorKlinickogCentra>();
      if (!this.administratorKlinickogCentra.contains(newAdministratorKlinickogCentra))
         this.administratorKlinickogCentra.add(newAdministratorKlinickogCentra);
   }
   

   public void removeAdministratorKlinickogCentra(AdministratorKlinickogCentra oldAdministratorKlinickogCentra) {
      if (oldAdministratorKlinickogCentra == null)
         return;
      if (this.administratorKlinickogCentra != null)
         if (this.administratorKlinickogCentra.contains(oldAdministratorKlinickogCentra))
            this.administratorKlinickogCentra.remove(oldAdministratorKlinickogCentra);
   }
   

   public void removeAllAdministratorKlinickogCentra() {
      if (administratorKlinickogCentra != null)
         administratorKlinickogCentra.clear();
   }

   public java.util.Collection<AdministratorKlinike> getAdministratorKlinike() {
      if (administratorKlinike == null)
         administratorKlinike = new java.util.HashSet<AdministratorKlinike>();
      return administratorKlinike;
   }

   public java.util.Iterator getIteratorAdministratorKlinike() {
      if (administratorKlinike == null)
         administratorKlinike = new java.util.HashSet<AdministratorKlinike>();
      return administratorKlinike.iterator();
   }

   public void setAdministratorKlinike(java.util.Collection<AdministratorKlinike> newAdministratorKlinike) {
      removeAllAdministratorKlinike();
      for (java.util.Iterator iter = newAdministratorKlinike.iterator(); iter.hasNext();)
         addAdministratorKlinike((AdministratorKlinike)iter.next());
   }

   public void addAdministratorKlinike(AdministratorKlinike newAdministratorKlinike) {
      if (newAdministratorKlinike == null)
         return;
      if (this.administratorKlinike == null)
         this.administratorKlinike = new java.util.HashSet<AdministratorKlinike>();
      if (!this.administratorKlinike.contains(newAdministratorKlinike))
         this.administratorKlinike.add(newAdministratorKlinike);
   }
   

   public void removeAdministratorKlinike(AdministratorKlinike oldAdministratorKlinike) {
      if (oldAdministratorKlinike == null)
         return;
      if (this.administratorKlinike != null)
         if (this.administratorKlinike.contains(oldAdministratorKlinike))
            this.administratorKlinike.remove(oldAdministratorKlinike);
   }
   
   public void removeAllAdministratorKlinike() {
      if (administratorKlinike != null)
         administratorKlinike.clear();
   }
   public java.util.Collection<Pacijent> getPacijent() {
      if (pacijent == null)
         pacijent = new java.util.HashSet<Pacijent>();
      return pacijent;
   }
   public java.util.Iterator getIteratorPacijent() {
      if (pacijent == null)
         pacijent = new java.util.HashSet<Pacijent>();
      return pacijent.iterator();
   }
   
   public void setPacijent(java.util.Collection<Pacijent> newPacijent) {
      removeAllPacijent();
      for (java.util.Iterator iter = newPacijent.iterator(); iter.hasNext();)
         addPacijent((Pacijent)iter.next());
   }
   
   public void addPacijent(Pacijent newPacijent) {
      if (newPacijent == null)
         return;
      if (this.pacijent == null)
         this.pacijent = new java.util.HashSet<Pacijent>();
      if (!this.pacijent.contains(newPacijent))
         this.pacijent.add(newPacijent);
   }
   
   public void removePacijent(Pacijent oldPacijent) {
      if (oldPacijent == null)
         return;
      if (this.pacijent != null)
         if (this.pacijent.contains(oldPacijent))
            this.pacijent.remove(oldPacijent);
   }
   
   public void removeAllPacijent() {
      if (pacijent != null)
         pacijent.clear();
   }
   public java.util.List<MedicinskaSestra> getMedicinskaSestra() {
      if (medicinskaSestra == null)
         medicinskaSestra = new java.util.ArrayList<MedicinskaSestra>();
      return medicinskaSestra;
   }
   
   public java.util.Iterator getIteratorMedicinskaSestra() {
      if (medicinskaSestra == null)
         medicinskaSestra = new java.util.ArrayList<MedicinskaSestra>();
      return medicinskaSestra.iterator();
   }
   
   public void setMedicinskaSestra(java.util.List<MedicinskaSestra> newMedicinskaSestra) {
      removeAllMedicinskaSestra();
      for (java.util.Iterator iter = newMedicinskaSestra.iterator(); iter.hasNext();)
         addMedicinskaSestra((MedicinskaSestra)iter.next());
   }
   
   public void addMedicinskaSestra(MedicinskaSestra newMedicinskaSestra) {
      if (newMedicinskaSestra == null)
         return;
      if (this.medicinskaSestra == null)
         this.medicinskaSestra = new java.util.ArrayList<MedicinskaSestra>();
      if (!this.medicinskaSestra.contains(newMedicinskaSestra))
         this.medicinskaSestra.add(newMedicinskaSestra);
   }
   
   public void removeMedicinskaSestra(MedicinskaSestra oldMedicinskaSestra) {
      if (oldMedicinskaSestra == null)
         return;
      if (this.medicinskaSestra != null)
         if (this.medicinskaSestra.contains(oldMedicinskaSestra))
            this.medicinskaSestra.remove(oldMedicinskaSestra);
   }
   
   public void removeAllMedicinskaSestra() {
      if (medicinskaSestra != null)
         medicinskaSestra.clear();
   }


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
   }*/

}