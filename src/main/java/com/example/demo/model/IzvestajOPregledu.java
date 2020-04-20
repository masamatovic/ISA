package com.example.demo.model;


/** @pdOid eb8ee9b6-02bb-41bb-97cd-a1b315ca597a */
public class IzvestajOPregledu {
   /** @pdOid f2ce0057-6d70-4a0c-ad56-9bc3d020642a */
   private Long id;
   
   /** @pdRoleInfo migr=no name=Lek assc=association26 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Lek> lek;
   /** @pdRoleInfo migr=no name=Recept assc=association25 mult=1..1 side=A */
   public Recept recept;
   /** @pdRoleInfo migr=no name=Doktor assc=association37 mult=1..1 side=A */
   public Doktor doktor;
   /** @pdRoleInfo migr=no name=Dijagnoza assc=association38 mult=1..1 side=A */
   public Dijagnoza dijagnoza;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Lek> getLek() {
      if (lek == null)
         lek = new java.util.HashSet<Lek>();
      return lek;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorLek() {
      if (lek == null)
         lek = new java.util.HashSet<Lek>();
      return lek.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLek */
   public void setLek(java.util.Collection<Lek> newLek) {
      removeAllLek();
      for (java.util.Iterator iter = newLek.iterator(); iter.hasNext();)
         addLek((Lek)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newLek */
   public void addLek(Lek newLek) {
      if (newLek == null)
         return;
      if (this.lek == null)
         this.lek = new java.util.HashSet<Lek>();
      if (!this.lek.contains(newLek))
         this.lek.add(newLek);
   }
   
   /** @pdGenerated default remove
     * @param oldLek */
   public void removeLek(Lek oldLek) {
      if (oldLek == null)
         return;
      if (this.lek != null)
         if (this.lek.contains(oldLek))
            this.lek.remove(oldLek);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLek() {
      if (lek != null)
         lek.clear();
   }

}