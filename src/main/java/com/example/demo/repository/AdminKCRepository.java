package com.example.demo.repository;

import com.example.demo.model.AdministratorKlinickogCentra;
import com.example.demo.model.Pacijent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminKCRepository extends JpaRepository<AdministratorKlinickogCentra, Long> {
    AdministratorKlinickogCentra findByEmail(String email);
}
