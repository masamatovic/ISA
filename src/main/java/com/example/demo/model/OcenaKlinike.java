package com.example.demo.model;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import javax.persistence.*;

@Entity
public class OcenaKlinike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer ocena;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "pacijent", referencedColumnName = "id")
    private Pacijent pacijent;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "klinika")
    private Klinika klinika;

    public OcenaKlinike() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public Klinika getKlinika() {
        return klinika;
    }

    public void setKlinika(Klinika klinika) {
        this.klinika = klinika;
    }
}
