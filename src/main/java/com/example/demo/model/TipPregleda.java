package com.example.demo.model;

/** @pdOid 4e3559ee-10f0-4daa-bd41-50341ac18b8d */
public class TipPregleda {
   /** @pdOid 6ea2c27e-9dd2-482f-ae8c-a9f870c8ddcd */
   private Long id;
   /** @pdOid 16589e87-6b30-4f5e-93f8-5c343c3d8ec9 */
   private String naziv;
   
   /** @pdRoleInfo migr=no name=Pregled assc=association28 coll=java.util.List impl=java.util.ArrayList mult=1..* */
   public java.util.List<Pregled> pregled;
   
   
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