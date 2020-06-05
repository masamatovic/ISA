package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.MedicinskaSestra;
import com.example.demo.model.Pacijent;

public interface MedicinskaSestraRepository extends JpaRepository<MedicinskaSestra,Long> {

	
}
