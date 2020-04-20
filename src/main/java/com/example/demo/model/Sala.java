package com.example.demo.model;


/** @pdOid 7a2afd5d-4b14-41db-89d5-1a60ebdc0e9f */
public class Sala {
   /** @pdOid 80fc793a-10f9-4c8a-84f1-4bc998ad0698 */
   private Long id;
   /** @pdOid 50bd47eb-3cb7-4a84-a2e3-77d78e81a90c */
   private String broj;
   /** @pdOid 38e1efa3-c68d-43a9-a227-0800e7739fd1 */
   private String naziv;
   
   /** @pdRoleInfo migr=no name=Pregled assc=association29 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Pregled> pregled;
   /** @pdRoleInfo migr=no name=Klinika assc=association30 mult=1..1 side=A */
   public Klinika klinika;
   
   
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
   /** @pdGenerated default parent getter */
   public Klinika getKlinika() {
      return klinika;
   }
   
   /** @pdGenerated default parent setter
     * @param newKlinika */
   public void setKlinika(Klinika newKlinika) {
      if (this.klinika == null || !this.klinika.equals(newKlinika))
      {
         if (this.klinika != null)
         {
            Klinika oldKlinika = this.klinika;
            this.klinika = null;
            oldKlinika.removeSala(this);
         }
         if (newKlinika != null)
         {
            this.klinika = newKlinika;
            this.klinika.addSala(this);
         }
      }
   }

}