package com.example.demo.model;


/** @pdOid 6e9e76ec-2839-44c8-988f-7b616e25f17a */
public class MedicinskaSestra {
   /** @pdOid c7c0b954-2649-4655-bca7-1ed3b3615d30 */
   private Long id;
   /** @pdOid 7d287d79-1cde-4c06-b796-df207c97c0bc */
   private String ime;
   /** @pdOid 1a5c1467-2cab-4678-8f53-cb4163d4bae2 */
   private String prezime;
   /** @pdOid 86e3c597-5f57-4cee-8473-827c6b075896 */
   private String email;
   /** @pdOid c64e2ddb-c51f-431e-b4ae-49cd2f1373d9 */
   private String lozinka;
   /** @pdOid 47447f06-078a-4334-9627-dcf73b8b6832 */
   private String adresa;
   /** @pdOid c7d0a759-976f-4c6f-a7dc-151fcbb79ac4 */
   private String grad;
   /** @pdOid e3dad044-52b3-4454-acd6-09c7697b6a1a */
   private String drzava;
   /** @pdOid fe607f8e-d030-4733-825a-6ddc3c79f1fb */
   private String telefon;
   /** @pdOid 43baeabe-d0a5-4bc0-b60b-8eae5e78bacc */
   private String jmbg;
   
   /** @pdRoleInfo migr=no name=ZahtevZaGodisnji assc=association22 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<ZahtevZaGodisnji> zahtevZaGodisnji;
   /** @pdRoleInfo migr=no name=Recept assc=association36 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Recept> recept;
   
   
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
   public java.util.List<Recept> getRecept() {
      if (recept == null)
         recept = new java.util.ArrayList<Recept>();
      return recept;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorRecept() {
      if (recept == null)
         recept = new java.util.ArrayList<Recept>();
      return recept.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newRecept */
   public void setRecept(java.util.List<Recept> newRecept) {
      removeAllRecept();
      for (java.util.Iterator iter = newRecept.iterator(); iter.hasNext();)
         addRecept((Recept)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newRecept */
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
   
   /** @pdGenerated default remove
     * @param oldRecept */
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
   
   /** @pdGenerated default removeAll */
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
   }

}