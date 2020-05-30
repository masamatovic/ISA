package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Pregled {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   private String datum;

   @Column
   private String vreme;

   @Column
   private Double trajanje;

   @Column
   private String cena;

   @Column
   private String popust;

   @Column
   private boolean odobren;

   @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
   @JoinColumn(name = "tip_pregleda_id")
   private TipPregleda tip;

   @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
   @JoinColumn(name = "sala_id")
   private Sala sala;

   @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
   @JoinColumn(name = "doktor_id")
   private Doktor doktor;

   @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
   @JoinColumn(name = "pacijent_id")
   private Pacijent pacijent;

   @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
   @JoinColumn(name = "klinika_id")
   private Klinika klinika;
   //public IzvestajOPregledu izvestajOPregledu;


   public Pregled() {
   }

   public Klinika getKlinika() {
      return klinika;
   }

   public void setKlinika(Klinika klinika) {
      this.klinika = klinika;
   }

   public boolean isOdobren() {
      return odobren;
   }

   public void setOdobren(boolean odobren) {
      this.odobren = odobren;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getDatum() {
      return datum;
   }

   public void setDatum(String datum) {
      this.datum = datum;
   }

   public String getVreme() {
      return vreme;
   }

   public void setVreme(String vreme) {
      this.vreme = vreme;
   }

   public Double getTrajanje() {
      return trajanje;
   }

   public void setTrajanje(Double trajanje) {
      this.trajanje = trajanje;
   }

   public String getCena() {
      return cena;
   }

   public void setCena(String cena) {
      this.cena = cena;
   }

   public String getPopust() {
      return popust;
   }

   public void setPopust(String popust) {
      this.popust = popust;
   }

   public TipPregleda getTip() {
      return tip;
   }

   public void setTip(TipPregleda tip) {
      this.tip = tip;
   }

   public Sala getSala() {
      return sala;
   }

   public void setSala(Sala sala) {
      this.sala = sala;
   }



   public void setDoktor(Doktor doktor) {
      this.doktor = doktor;
   }

   public Pacijent getPacijent() {
      return pacijent;
   }

   public void setPacijent(Pacijent pacijent) {
      this.pacijent = pacijent;
   }

   public Doktor getDoktor() {
      return doktor;
   }
   

 /*  public void setDoktor(Doktor newDoktor) {
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
*/

}