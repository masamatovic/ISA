package com.example.demo.model;


import javax.persistence.*;

/** @pdOid 8b65cf59-b20e-400a-8a57-dc711418aad5 */
@Entity
public class ZdravstveniKarton {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   /** @pdOid 7597a942-f4db-47e4-a1f3-8cecfb1b8b7e */
   @Column
   private String dioptrija;
   /** @pdOid 9731354d-bf5d-4441-b898-aa61eb4c2ee0 */
   @Column
   private String pol;
   /** @pdOid f813b39c-04fb-47f3-bc43-1774ba2a5f87 */
   @Column
   private String krvnaGrupa;
   /** @pdOid 77e4ba23-9faa-47b7-9eaa-31eee648b0fc */
   @Column
   private String visina;
   /** @pdOid fd62adbd-1b1c-4631-b1b3-6a9211a92b03 */
   @Column
   private String tezina;
   /** @pdOid 31ccaaef-f2aa-4080-947e-2318fd87ebc4 */
   @Column
   private String alergije;

   public ZdravstveniKarton() {
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getDioptrija() {
      return dioptrija;
   }

   public void setDioptrija(String dioptrija) {
      this.dioptrija = dioptrija;
   }

   public String getPol() {
      return pol;
   }

   public void setPol(String pol) {
      this.pol = pol;
   }

   public String getKrvnaGrupa() {
      return krvnaGrupa;
   }

   public void setKrvnaGrupa(String krvnaGrupa) {
      this.krvnaGrupa = krvnaGrupa;
   }

   public String getVisina() {
      return visina;
   }

   public void setVisina(String visina) {
      this.visina = visina;
   }

   public String getTezina() {
      return tezina;
   }

   public void setTezina(String tezina) {
      this.tezina = tezina;
   }

   public String getAlergije() {
      return alergije;
   }

   public void setAlergije(String alergije) {
      this.alergije = alergije;
   }
}