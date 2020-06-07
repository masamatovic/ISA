package com.example.demo.repository;


import com.example.demo.model.Pacijent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacijentRepository extends JpaRepository<Pacijent,Long> {
    Pacijent findByEmail(String email);
    
    List<Pacijent> findAllByOrderByImeAsc();
    List<Pacijent> findAllByOrderByPrezimeAsc();
    List<Pacijent> findAllByOrderByJmbgAsc();
}
