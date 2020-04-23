package com.example.demo.repository;

import com.example.demo.model.Klinika;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KlinikaRepository extends JpaRepository<Klinika, Long> {

    List<Klinika> findAllByOrderByNazivAsc();
    List<Klinika> findAllByOrderByGradAsc();

}
