package com.example.demo.repository;

import com.example.demo.model.Klinika;
import com.example.demo.model.OcenaKlinike;
import com.example.demo.model.Pacijent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OcenaKlinikeRepository extends JpaRepository<OcenaKlinike, Long> {

    OcenaKlinike findByPacijentAndKlinika(Pacijent pacijent, Klinika klinika);
    List<OcenaKlinike> findByKlinika(Klinika klinika);
}
