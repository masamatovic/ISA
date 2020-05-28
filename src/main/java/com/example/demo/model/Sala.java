package com.example.demo.model;


import javax.persistence.*;

@Entity
public class Sala {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   private String naziv;

   @Column
   private String broj;

   @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
   public Klinika klinika;

   public Sala() {
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

   public String getBroj() {
      return broj;
   }

   public void setBroj(String broj) {
      this.broj = broj;
   }

   public Klinika getKlinika() {
      return klinika;
  }



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