package com.example.demo.repository;

import com.example.demo.model.AdministratorKlinike;
import com.example.demo.model.Pacijent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminKlinikeRepository extends JpaRepository<AdministratorKlinike, Long> {
    AdministratorKlinike findByEmail(String email);
}

