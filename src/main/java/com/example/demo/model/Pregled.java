package com.example.demo.model;

/** @pdOid d7b7241a-3fc2-42ca-91f8-4fed09a3c075 */
public class Pregled {
   /** @pdOid 35bdcc99-0c7f-4f75-98ad-9cbaa7ff1365 */
   private Long id;
   /** @pdOid 7746576c-5747-4dc7-b5a5-5efb9a0e56db */
   private String datum;
   /** @pdOid a3132e6a-162d-4d90-941c-bac7c60834a1 */
   private String vreme;
   /** @pdOid 6febd3ea-3a70-454f-a1e5-6763a8cfcebf */
   private TipPregleda tip;
   /** @pdOid bf7af466-d8fd-4f92-9745-babdf23ac99b */
   private Double trajanje;
   /** @pdOid 479c17df-ea78-4683-a6d8-4cc4e3d4b216 */
   private Sala sala;
   /** @pdOid 6be42aa4-88f7-4b40-a1cf-e6b2a7d34142 */
   private int attribute7;
   
   /** @pdRoleInfo migr=no name=IzvestajOPregledu assc=association27 mult=1..1 */
   public IzvestajOPregledu izvestajOPregledu;
   /** @pdRoleInfo migr=no name=Doktor assc=association40 mult=1..1 side=A */
   public Doktor doktor;
   
   
   /** @pdGenerated default parent getter */
   public Doktor getDoktor() {
      return doktor;
   }
   
   /** @pdGenerated default parent setter
     * @param newDoktor */
   public void setDoktor(Doktor newDoktor) {
      if (this.doktor == null || !this.doktor.equals(newDoktor))
      {
         if (this.doktor != null)
         {
            Doktor oldDoktor = this.doktor;
            this.doktor = null;
            oldDoktor.removePregled(this);
         }
         if (newDoktor != null)
         {
            this.doktor = newDoktor;
            this.doktor.addPregled(this);
         }
      }
   }

}