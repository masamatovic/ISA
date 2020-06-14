package com.example.demo.repository;

import com.example.demo.model.Doktor;
import com.example.demo.model.Klinika;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface KlinikaRepository extends JpaRepository<Klinika, Long> {

    List<Klinika> findAllByOrderByNazivAsc();
    List<Klinika> findAllByOrderByGradAsc();

    @Query("select k from Klinika k where " +
            "(?1 = '' or upper(k.naziv) like upper(?1)) " +
            "and (?2 = '' or upper(k.adresa) like upper(?2)) and ( k.ocena is null or k.ocena >= ?3) ")
    ArrayList<Klinika> getByQuery (String naziv, String adresa, Double ocena );

}
