package com.example.demo.model;

import javax.persistence.*;

@Entity
public class TipPregleda {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   private String naziv;

   @Column
   private String cena;

   @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
   private Klinika klinika;

   public TipPregleda() {
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getNaziv() {
      return naziv;
   }

   public void setNaziv(String naziv) {
      this.naziv = naziv;
   }

   public String getCena() {
      return cena;
   }

   public void setCena(String cena) {
      this.cena = cena;
   }

   public Klinika getKlinika() {
      return klinika;
   }

   public void setKlinika(Klinika klinika) {
      this.klinika = klinika;
   }
}