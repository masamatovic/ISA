package com.example.demo.repository;

import com.example.demo.model.Klinika;
import com.example.demo.model.TipPregleda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipPregledaRepository extends JpaRepository<TipPregleda, Long> {
    TipPregleda findByKlinikaAndAndNaziv(Klinika klinika, String naziv);
}
