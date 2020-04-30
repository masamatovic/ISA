package com.example.demo.dto;

public class ZahtevZaAutentikacijuDTO {

    private String email;
    private String lozinka;

    public ZahtevZaAutentikacijuDTO() {
        super();
    }

    public ZahtevZaAutentikacijuDTO(String email, String lozinka) {
        this.email = email;
        this.lozinka = lozinka;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}
