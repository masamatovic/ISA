package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.model.MedicinskaSestra;
import com.example.demo.model.Recept;

public class ReceptDTO {

   private Long id;
   public MedicinskaSestra medicinskaSestra;
   public boolean overen=false;
   
   
   public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public boolean isOveren() {
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

public ReceptDTO() {
	
}
public ReceptDTO(Recept r) {
	super();
	this.id = r.getId();
	this.medicinskaSestra = r.getMedicinskaSestra();
	this.overen = r.getOveren();
}
}
