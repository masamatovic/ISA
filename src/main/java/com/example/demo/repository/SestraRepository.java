package com.example.demo.repository;

import com.example.demo.model.MedicinskaSestra;
import com.example.demo.model.Pacijent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SestraRepository extends JpaRepository<MedicinskaSestra, Long> {
    MedicinskaSestra findByEmail(String email);
}
