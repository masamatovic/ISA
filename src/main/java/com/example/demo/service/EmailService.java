package com.example.demo.service;


import com.example.demo.model.Pacijent;
import com.example.demo.model.ZahtevZaRegistraciju;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment environment;

    @Async
    public void posaljiMail(Pacijent pacijent)  throws MailException, InterruptedException{
        System.out.println("Slanje emaila...");

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(pacijent.getEmail());
        mail.setFrom(environment.getProperty("spring.mail.username"));
        mail.setSubject("Klinički centar, potvrda registracije");
        mail.setText("Dobrodošli " + pacijent.getIme() + ",\n\n Vaš zahtev za registraciju je prigvaćen " +

                "Da biste potvrdili vašu mail adresu molimo vas da pristupite linku:\n\n" +
                "http://localhost:8081/#/aktivacijaPacijenta/"+ pacijent.getId() +
                "\n\nHvala vam na ukazanom poverenju!\n\n\n\n" );
        javaMailSender.send(mail);

        System.out.println("Email poslat!");
    }

    @Async
    public void posaljiMail(ZahtevZaRegistraciju zaRegistraciju, String poruka)  throws MailException, InterruptedException{
        System.out.println("Slanje emaila...");

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(zaRegistraciju.getEmail());
        mail.setFrom(environment.getProperty("spring.mail.username"));
        mail.setSubject("Klinički centar, odbijena registracija");
        mail.setText("Poštovani " + zaRegistraciju.getIme() + ",\n\n Vaš zahtev za registraciju je odbijen " +

                "Razlozi koje navode naši administratori su:\n\n" + poruka +
                "\n\nMolimo za razumevanje!\n\n\n\n" );
        javaMailSender.send(mail);

        System.out.println("Email poslat!");
    }

}
