package com.example.demo.model;



/** @pdOid c0cd605c-21e3-466a-affb-f18d154f2e2d */
public class Doktor {
   /** @pdOid 9c693132-0b58-4a08-b89e-4806dda151cb */
   private Long id;
   /** @pdOid c3ea0d26-0dee-40df-badc-f21462c10041 */
   private String ime;
   /** @pdOid 7296a8f2-ec78-47bf-b93f-a8d67a7ec6f7 */
   private String prezime;
   /** @pdOid 3e6f8e39-2673-41e9-9514-6cd626e1b383 */
   private String email;
   /** @pdOid 307c451f-6fb6-455e-9bd9-cdaa4991907b */
   private String lozinka;
   /** @pdOid 48fa5418-eb86-4b37-8407-090c4e51e1f7 */
   private String adresa;
   /** @pdOid 8262d606-d3d3-4455-a9dd-5d6bf504cfa0 */
   private String grad;
   /** @pdOid 72bce2fb-2166-4731-8b67-b58435d16e1c */
   private String drzava;
   /** @pdOid 72e95ff4-2f52-4220-ba17-8f61a23fe1d0 */
   private String telefon;
   /** @pdOid 73c0490f-1d3b-4c99-94c8-58b35590a80a */
   private String jmbg;
   
   /** @pdRoleInfo migr=no name=ZahtevZaGodisnji assc=association23 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<ZahtevZaGodisnji> zahtevZaGodisnji;
   /** @pdRoleInfo migr=no name=Pregled assc=association40 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Pregled> pregled;
   /** @pdRoleInfo migr=no name=ZahtevZaPregled assc=association35 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<ZahtevZaPregled> zahtevZaPregled;
   
   
   /** @pdGenerated default getter */
   public java.util.List<ZahtevZaGodisnji> getZahtevZaGodisnji() {
      if (zahtevZaGodisnji == null)
         zahtevZaGodisnji = new java.util.ArrayList<ZahtevZaGodisnji>();
      return zahtevZaGodisnji;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorZahtevZaGodisnji() {
      if (zahtevZaGodisnji == null)
         zahtevZaGodisnji = new java.util.ArrayList<ZahtevZaGodisnji>();
      return zahtevZaGodisnji.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newZahtevZaGodisnji */
   public void setZahtevZaGodisnji(java.util.List<ZahtevZaGodisnji> newZahtevZaGodisnji) {
      removeAllZahtevZaGodisnji();
      for (java.util.Iterator iter = newZahtevZaGodisnji.iterator(); iter.hasNext();)
         addZahtevZaGodisnji((ZahtevZaGodisnji)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newZahtevZaGodisnji */
   public void addZahtevZaGodisnji(ZahtevZaGodisnji newZahtevZaGodisnji) {
      if (newZahtevZaGodisnji == null)
         return;
      if (this.zahtevZaGodisnji == null)
         this.zahtevZaGodisnji = new java.util.ArrayList<ZahtevZaGodisnji>();
      if (!this.zahtevZaGodisnji.contains(newZahtevZaGodisnji))
         this.zahtevZaGodisnji.add(newZahtevZaGodisnji);
   }
   
   /** @pdGenerated default remove
     * @param oldZahtevZaGodisnji */
   public void removeZahtevZaGodisnji(ZahtevZaGodisnji oldZahtevZaGodisnji) {
      if (oldZahtevZaGodisnji == null)
         return;
      if (this.zahtevZaGodisnji != null)
         if (this.zahtevZaGodisnji.contains(oldZahtevZaGodisnji))
            this.zahtevZaGodisnji.remove(oldZahtevZaGodisnji);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllZahtevZaGodisnji() {
      if (zahtevZaGodisnji != null)
         zahtevZaGodisnji.clear();
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
      {
         this.pregled.add(newPregled);
         newPregled.setDoktor(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldPregled */
   public void removePregled(Pregled oldPregled) {
      if (oldPregled == null)
         return;
      if (this.pregled != null)
         if (this.pregled.contains(oldPregled))
         {
            this.pregled.remove(oldPregled);
            oldPregled.setDoktor((Doktor)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPregled() {
      if (pregled != null)
      {
         Pregled oldPregled;
         for (java.util.Iterator iter = getIteratorPregled(); iter.hasNext();)
         {
            oldPregled = (Pregled)iter.next();
            iter.remove();
            oldPregled.setDoktor((Doktor)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.List<ZahtevZaPregled> getZahtevZaPregled() {
      if (zahtevZaPregled == null)
         zahtevZaPregled = new java.util.ArrayList<ZahtevZaPregled>();
      return zahtevZaPregled;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorZahtevZaPregled() {
      if (zahtevZaPregled == null)
         zahtevZaPregled = new java.util.ArrayList<ZahtevZaPregled>();
      return zahtevZaPregled.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newZahtevZaPregled */
   public void setZahtevZaPregled(java.util.List<ZahtevZaPregled> newZahtevZaPregled) {
      removeAllZahtevZaPregled();
      for (java.util.Iterator iter = newZahtevZaPregled.iterator(); iter.hasNext();)
         addZahtevZaPregled((ZahtevZaPregled)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newZahtevZaPregled */
   public void addZahtevZaPregled(ZahtevZaPregled newZahtevZaPregled) {
      if (newZahtevZaPregled == null)
         return;
      if (this.zahtevZaPregled == null)
         this.zahtevZaPregled = new java.util.ArrayList<ZahtevZaPregled>();
      if (!this.zahtevZaPregled.contains(newZahtevZaPregled))
         this.zahtevZaPregled.add(newZahtevZaPregled);
   }
   
   /** @pdGenerated default remove
     * @param oldZahtevZaPregled */
   public void removeZahtevZaPregled(ZahtevZaPregled oldZahtevZaPregled) {
      if (oldZahtevZaPregled == null)
         return;
      if (this.zahtevZaPregled != null)
         if (this.zahtevZaPregled.contains(oldZahtevZaPregled))
            this.zahtevZaPregled.remove(oldZahtevZaPregled);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllZahtevZaPregled() {
      if (zahtevZaPregled != null)
         zahtevZaPregled.clear();
   }

}