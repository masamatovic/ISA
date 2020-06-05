package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/** @pdOid a2393c20-bbd9-45fd-b09c-e22d61f8acf3 */
public class Recept {
   /** @pdOid 1bf011f4-d26b-4a44-b208-80b11c6f072b */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
	@Column
   public MedicinskaSestra medicinskaSestra;
	
	@Column
	   public boolean overen=false;
   
   
   public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public boolean getOveren() {
		return overen;
	}


	public void setOveren(boolean overen) {
		this.overen = overen;
	}


	public void setMedicinskaSestra(MedicinskaSestra medicinskaSestra) {
		this.medicinskaSestra = medicinskaSestra;
	}


public MedicinskaSestra getMedicinskaSestra() {
      return medicinskaSestra;
   }

public Recept() {
	
}
public Recept(Recept r) {
	super();
	this.id = r.id;
	this.medicinskaSestra = r.medicinskaSestra;
	this.overen = r.overen;
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