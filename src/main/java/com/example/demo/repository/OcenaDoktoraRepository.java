package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OcenaDoktoraRepository extends JpaRepository<OcenaDoktora, Long> {
    OcenaDoktora findByPacijentAndDoktor(Pacijent pacijent, Doktor doktor);
    List<OcenaDoktora> findByDoktor(Doktor doktor);

}
