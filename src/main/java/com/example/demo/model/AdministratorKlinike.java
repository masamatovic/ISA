package com.example.demo.model;

/** @pdOid d4d2e3d5-4bdf-4176-80cb-2f7f933f53d9 */
public class AdministratorKlinike {
   /** @pdOid ac4cedcf-2917-4075-9e06-e6a88c87a67b */
   private Long id;
   /** @pdOid e90170cc-bf36-48f0-921b-9a5df42ed8a5 */
   private String ime;
   /** @pdOid 1bb7b273-e88d-4eff-b9f1-7f7c28742e9b */
   private String prezime;
   /** @pdOid e89b34ce-f232-4fe1-8ea3-8f78dae29c7d */
   private String email;
   /** @pdOid 3ca9e930-535a-4afe-930c-821f50742296 */
   private String lozinka;
   /** @pdOid 32094962-c503-4add-a44f-035a4a01feae */
   private String adresa;
   /** @pdOid 53616c99-80b0-4e4e-81f3-b6283600770b */
   private String grad;
   /** @pdOid 281ec12b-7e24-44f6-8601-d53b39ba389a */
   private String drzava;
   /** @pdOid 07389922-ec39-482c-b277-71df87f86e96 */
   private String telefon;
   /** @pdOid 6adef1d7-6745-4e30-8912-381b942dc6c4 */
   private String jmbg;
   
   /** @pdRoleInfo migr=no name=ZahtevZaGodisnji assc=association31 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<ZahtevZaGodisnji> zahtevZaGodisnji;
   /** @pdRoleInfo migr=no name=ZahtevZaPregled assc=association34 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<ZahtevZaPregled> zahtevZaPregled;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<ZahtevZaGodisnji> getZahtevZaGodisnji() {
      if (zahtevZaGodisnji == null)
         zahtevZaGodisnji = new java.util.HashSet<ZahtevZaGodisnji>();
      return zahtevZaGodisnji;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorZahtevZaGodisnji() {
      if (zahtevZaGodisnji == null)
         zahtevZaGodisnji = new java.util.HashSet<ZahtevZaGodisnji>();
      return zahtevZaGodisnji.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newZahtevZaGodisnji */
   public void setZahtevZaGodisnji(java.util.Collection<ZahtevZaGodisnji> newZahtevZaGodisnji) {
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
         this.zahtevZaGodisnji = new java.util.HashSet<ZahtevZaGodisnji>();
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