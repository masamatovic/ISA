package com.example.demo.repository;


import com.example.demo.model.ZahtevZaRegistraciju;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface ZahtevZaRegistracijuRepository extends JpaRepository<ZahtevZaRegistraciju, Long> {

    ZahtevZaRegistraciju findByEmail(String email);
    List<ZahtevZaRegistraciju> findAllByOdobren(Boolean odobren);
}
