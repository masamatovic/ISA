package com.example.demo.model;


/** @pdOid a2393c20-bbd9-45fd-b09c-e22d61f8acf3 */
public class Recept {
   /** @pdOid 1bf011f4-d26b-4a44-b208-80b11c6f072b */
   private Long id;
   
   public MedicinskaSestra medicinskaSestra;
   
   
   public MedicinskaSestra getMedicinskaSestra() {
      return medicinskaSestra;
   }
   
 /*  public void setMedicinskaSestra(MedicinskaSestra newMedicinskaSestra) {
      if (this.medicinskaSestra == null || !this.medicinskaSestra.equals(newMedicinskaSestra))
      {
         if (this.medicinskaSestra != null)
         {
            MedicinskaSestra oldMedicinskaSestra = this.medicinskaSestra;
            this.medicinskaSestra = null;
            oldMedicinskaSestra.removeRecept(this);
         }
         if (newMedicinskaSestra != null)
         {
            this.medicinskaSestra = newMedicinskaSestra;
            this.medicinskaSestra.addRecept(this);
         }
      }
   }*/

}