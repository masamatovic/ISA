package com.example.demo.repository;

import com.example.demo.dto.PregledDTO;
import com.example.demo.model.Doktor;
import com.example.demo.model.Klinika;
import com.example.demo.model.Pregled;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PregledRepository extends JpaRepository<Pregled,Long> {

    ArrayList<Pregled> getByKlinikaAndPacijentNull(Klinika klinika);
    ArrayList<Pregled> getByDoktor(Doktor doktor);

}
