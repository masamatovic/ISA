package com.example.demo.repository;

import com.example.demo.model.Doktor;
import com.example.demo.model.Klinika;
import com.example.demo.model.Pacijent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface DoktorRepository extends JpaRepository<Doktor,Long> {

    Doktor findByEmail(String email);

    ArrayList<Doktor> findByKlinika(Klinika klinika);


   @Query("select d from Doktor d where " +
           "(?1 = '' or upper(d.ime) like upper(?1)) " +
           "and (?2 = '' or upper(d.prezime) like upper(?2)) " +
           "and (?3 = '' or  upper(d.tipPregleda.naziv) like upper(?3) )" +
           "and ( d.klinika.id = ?4)")
    ArrayList<Doktor> getByQuery (String ime, String Prezime, String tipPregleda, Long id );

}
