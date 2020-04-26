package com.example.demo.repository;

import com.example.demo.model.Doktor;
import com.example.demo.model.Pacijent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoktorRepository extends JpaRepository<Doktor,Long> {
    Doktor findByEmail(String email);
}
