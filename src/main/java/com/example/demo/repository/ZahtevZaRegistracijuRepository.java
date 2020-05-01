package com.example.demo.repository;


import com.example.demo.model.ZahtevZaRegistraciju;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZahtevZaRegistracijuRepository extends JpaRepository<ZahtevZaRegistraciju, Long> {

    ZahtevZaRegistraciju findByEmail(String email);
}
