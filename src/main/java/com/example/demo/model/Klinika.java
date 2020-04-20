package com.example.demo.model;

/** @pdOid f5c64885-5972-4252-9cf9-77a1412a0dc2 */
public class Klinika {
   /** @pdOid 7c641235-aacc-42ef-a092-04aef2c42dd3 */
   private Long id;
   /** @pdOid 6ad4a8ad-3a5a-4191-9eb7-f16af6b3683d */
   private String naziv;
   /** @pdOid a79bd191-9962-4dd1-9349-7043a36bccd5 */
   private String adresa;
   /** @pdOid 184ff948-c5f6-4476-90a6-3f0cad1b4fcd */
   private String grad;
   /** @pdOid 7d7c4f46-e8b6-49fb-8933-5acdc8e22d75 */
   private String drzava;
   /** @pdOid 1ed5d6dd-e5fb-4a59-be0c-7515f3d43a98 */
   private String opis;
   
   /** @pdRoleInfo migr=no name=AdministratorKlinickogCentra assc=association17 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<AdministratorKlinickogCentra> administratorKlinickogCentra;
   /** @pdRoleInfo migr=no name=AdministratorKlinike assc=association18 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<AdministratorKlinike> administratorKlinike;
   /** @pdRoleInfo migr=no name=Pacijent assc=association19 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Pacijent> pacijent;
   /** @pdRoleInfo migr=no name=MedicinskaSestra assc=association16 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<MedicinskaSestra> medicinskaSestra;
   /** @pdRoleInfo migr=no name=Doktor assc=association21 coll=java.util.List impl=java.util.ArrayList mult=1..* */
   public java.util.List<Doktor> doktor;
   /** @pdRoleInfo migr=no name=Sala assc=association30 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<Sala> sala;
   /** @pdRoleInfo migr=no name=Pregled assc=association41 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Pregled> pregled;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<AdministratorKlinickogCentra> getAdministratorKlinickogCentra() {
      if (administratorKlinickogCentra == null)
         administratorKlinickogCentra = new java.util.HashSet<AdministratorKlinickogCentra>();
      return administratorKlinickogCentra;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAdministratorKlinickogCentra() {
      if (administratorKlinickogCentra == null)
         administratorKlinickogCentra = new java.util.HashSet<AdministratorKlinickogCentra>();
      return administratorKlinickogCentra.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAdministratorKlinickogCentra */
   public void setAdministratorKlinickogCentra(java.util.Collection<AdministratorKlinickogCentra> newAdministratorKlinickogCentra) {
      removeAllAdministratorKlinickogCentra();
      for (java.util.Iterator iter = newAdministratorKlinickogCentra.iterator(); iter.hasNext();)
         addAdministratorKlinickogCentra((AdministratorKlinickogCentra)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAdministratorKlinickogCentra */
   public void addAdministratorKlinickogCentra(AdministratorKlinickogCentra newAdministratorKlinickogCentra) {
      if (newAdministratorKlinickogCentra == null)
         return;
      if (this.administratorKlinickogCentra == null)
         this.administratorKlinickogCentra = new java.util.HashSet<AdministratorKlinickogCentra>();
      if (!this.administratorKlinickogCentra.contains(newAdministratorKlinickogCentra))
         this.administratorKlinickogCentra.add(newAdministratorKlinickogCentra);
   }
   
   /** @pdGenerated default remove
     * @param oldAdministratorKlinickogCentra */
   public void removeAdministratorKlinickogCentra(AdministratorKlinickogCentra oldAdministratorKlinickogCentra) {
      if (oldAdministratorKlinickogCentra == null)
         return;
      if (this.administratorKlinickogCentra != null)
         if (this.administratorKlinickogCentra.contains(oldAdministratorKlinickogCentra))
            this.administratorKlinickogCentra.remove(oldAdministratorKlinickogCentra);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAdministratorKlinickogCentra() {
      if (administratorKlinickogCentra != null)
         administratorKlinickogCentra.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<AdministratorKlinike> getAdministratorKlinike() {
      if (administratorKlinike == null)
         administratorKlinike = new java.util.HashSet<AdministratorKlinike>();
      return administratorKlinike;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAdministratorKlinike() {
      if (administratorKlinike == null)
         administratorKlinike = new java.util.HashSet<AdministratorKlinike>();
      return administratorKlinike.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAdministratorKlinike */
   public void setAdministratorKlinike(java.util.Collection<AdministratorKlinike> newAdministratorKlinike) {
      removeAllAdministratorKlinike();
      for (java.util.Iterator iter = newAdministratorKlinike.iterator(); iter.hasNext();)
         addAdministratorKlinike((AdministratorKlinike)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAdministratorKlinike */
   public void addAdministratorKlinike(AdministratorKlinike newAdministratorKlinike) {
      if (newAdministratorKlinike == null)
         return;
      if (this.administratorKlinike == null)
         this.administratorKlinike = new java.util.HashSet<AdministratorKlinike>();
      if (!this.administratorKlinike.contains(newAdministratorKlinike))
         this.administratorKlinike.add(newAdministratorKlinike);
   }
   
   /** @pdGenerated default remove
     * @param oldAdministratorKlinike */
   public void removeAdministratorKlinike(AdministratorKlinike oldAdministratorKlinike) {
      if (oldAdministratorKlinike == null)
         return;
      if (this.administratorKlinike != null)
         if (this.administratorKlinike.contains(oldAdministratorKlinike))
            this.administratorKlinike.remove(oldAdministratorKlinike);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAdministratorKlinike() {
      if (administratorKlinike != null)
         administratorKlinike.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Pacijent> getPacijent() {
      if (pacijent == null)
         pacijent = new java.util.HashSet<Pacijent>();
      return pacijent;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPacijent() {
      if (pacijent == null)
         pacijent = new java.util.HashSet<Pacijent>();
      return pacijent.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPacijent */
   public void setPacijent(java.util.Collection<Pacijent> newPacijent) {
      removeAllPacijent();
      for (java.util.Iterator iter = newPacijent.iterator(); iter.hasNext();)
         addPacijent((Pacijent)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPacijent */
   public void addPacijent(Pacijent newPacijent) {
      if (newPacijent == null)
         return;
      if (this.pacijent == null)
         this.pacijent = new java.util.HashSet<Pacijent>();
      if (!this.pacijent.contains(newPacijent))
         this.pacijent.add(newPacijent);
   }
   
   /** @pdGenerated default remove
     * @param oldPacijent */
   public void removePacijent(Pacijent oldPacijent) {
      if (oldPacijent == null)
         return;
      if (this.pacijent != null)
         if (this.pacijent.contains(oldPacijent))
            this.pacijent.remove(oldPacijent);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPacijent() {
      if (pacijent != null)
         pacijent.clear();
   }
   /** @pdGenerated default getter */
   public java.util.List<MedicinskaSestra> getMedicinskaSestra() {
      if (medicinskaSestra == null)
         medicinskaSestra = new java.util.ArrayList<MedicinskaSestra>();
      return medicinskaSestra;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorMedicinskaSestra() {
      if (medicinskaSestra == null)
         medicinskaSestra = new java.util.ArrayList<MedicinskaSestra>();
      return medicinskaSestra.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newMedicinskaSestra */
   public void setMedicinskaSestra(java.util.List<MedicinskaSestra> newMedicinskaSestra) {
      removeAllMedicinskaSestra();
      for (java.util.Iterator iter = newMedicinskaSestra.iterator(); iter.hasNext();)
         addMedicinskaSestra((MedicinskaSestra)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMedicinskaSestra */
   public void addMedicinskaSestra(MedicinskaSestra newMedicinskaSestra) {
      if (newMedicinskaSestra == null)
         return;
      if (this.medicinskaSestra == null)
         this.medicinskaSestra = new java.util.ArrayList<MedicinskaSestra>();
      if (!this.medicinskaSestra.contains(newMedicinskaSestra))
         this.medicinskaSestra.add(newMedicinskaSestra);
   }
   
   /** @pdGenerated default remove
     * @param oldMedicinskaSestra */
   public void removeMedicinskaSestra(MedicinskaSestra oldMedicinskaSestra) {
      if (oldMedicinskaSestra == null)
         return;
      if (this.medicinskaSestra != null)
         if (this.medicinskaSestra.contains(oldMedicinskaSestra))
            this.medicinskaSestra.remove(oldMedicinskaSestra);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllMedicinskaSestra() {
      if (medicinskaSestra != null)
         medicinskaSestra.clear();
   }
   /** @pdGenerated default getter */
   public java.util.List<Doktor> getDoktor() {
      if (doktor == null)
         doktor = new java.util.ArrayList<Doktor>();
      return doktor;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorDoktor() {
      if (doktor == null)
         doktor = new java.util.ArrayList<Doktor>();
      return doktor.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newDoktor */
   public void setDoktor(java.util.List<Doktor> newDoktor) {
      removeAllDoktor();
      for (java.util.Iterator iter = newDoktor.iterator(); iter.hasNext();)
         addDoktor((Doktor)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newDoktor */
   public void addDoktor(Doktor newDoktor) {
      if (newDoktor == null)
         return;
      if (this.doktor == null)
         this.doktor = new java.util.ArrayList<Doktor>();
      if (!this.doktor.contains(newDoktor))
         this.doktor.add(newDoktor);
   }
   
   /** @pdGenerated default remove
     * @param oldDoktor */
   public void removeDoktor(Doktor oldDoktor) {
      if (oldDoktor == null)
         return;
      if (this.doktor != null)
         if (this.doktor.contains(oldDoktor))
            this.doktor.remove(oldDoktor);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllDoktor() {
      if (doktor != null)
         doktor.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Sala> getSala() {
      if (sala == null)
         sala = new java.util.HashSet<Sala>();
      return sala;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSala() {
      if (sala == null)
         sala = new java.util.HashSet<Sala>();
      return sala.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSala */
   public void setSala(java.util.Collection<Sala> newSala) {
      removeAllSala();
      for (java.util.Iterator iter = newSala.iterator(); iter.hasNext();)
         addSala((Sala)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSala */
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
   
   /** @pdGenerated default remove
     * @param oldSala */
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
   
   /** @pdGenerated default removeAll */
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
   /** @pdGenerated default getter */
   public java.util.List<Pregled> getPregled() {
      if (pregled == null)
         pregled = new java.util.ArrayList<Pregled>();
      return pregled;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPregled() {
      if (pregled == null)
         pregled = new java.util.ArrayList<Pregled>();
      return pregled.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPregled */
   public void setPregled(java.util.List<Pregled> newPregled) {
      removeAllPregled();
      for (java.util.Iterator iter = newPregled.iterator(); iter.hasNext();)
         addPregled((Pregled)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPregled */
   public void addPregled(Pregled newPregled) {
      if (newPregled == null)
         return;
      if (this.pregled == null)
         this.pregled = new java.util.ArrayList<Pregled>();
      if (!this.pregled.contains(newPregled))
         this.pregled.add(newPregled);
   }
   
   /** @pdGenerated default remove
     * @param oldPregled */
   public void removePregled(Pregled oldPregled) {
      if (oldPregled == null)
         return;
      if (this.pregled != null)
         if (this.pregled.contains(oldPregled))
            this.pregled.remove(oldPregled);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPregled() {
      if (pregled != null)
         pregled.clear();
   }

}