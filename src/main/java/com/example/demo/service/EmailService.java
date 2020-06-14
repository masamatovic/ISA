package com.example.demo.service;


import com.example.demo.dto.PregledDTO;
import com.example.demo.dto.ZahtevZaPregledDTO;
import com.example.demo.model.AdministratorKlinike;
import com.example.demo.model.Klinika;
import com.example.demo.model.Pacijent;
import com.example.demo.model.ZahtevZaRegistraciju;
import com.example.demo.repository.AdminKlinikeRepository;
import com.example.demo.repository.KlinikaRepository;
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

    @Autowired
    private AdminKlinikeRepository adminKlinikeRepository;

    @Autowired
    private KlinikaRepository klinikaRepository;

    @Async
    public void posaljiMail(Pacijent pacijent)  throws MailException, InterruptedException{

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(pacijent.getEmail());
        mail.setFrom(environment.getProperty("spring.mail.username"));
        mail.setSubject("Klinički centar, potvrda registracije");
        mail.setText("Dobrodošli " + pacijent.getIme() + ",\n\n Vaš zahtev za registraciju je prigvaćen " +

                "Da biste potvrdili vašu mail adresu molimo vas da pristupite linku:\n\n" +
                "http://localhost:8081/#/aktivacijaPacijenta/"+ pacijent.getId() +
                "\n\nHvala vam na ukazanom poverenju!\n\n\n\n" );
        javaMailSender.send(mail);

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

    }
    @Async
    public void posaljiMail(PregledDTO pregledDTO)  throws MailException, InterruptedException{

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(pregledDTO.getPacijent().getEmail());
        mail.setFrom(environment.getProperty("spring.mail.username"));
        mail.setSubject("Klinički centar, zakzaivanje Unapred definisanog pregleda");
        mail.setText("Poštovani, \n\nRezervistali ste pregled na klinici  " +
                  pregledDTO.getKlinika().getNaziv()+
                "\nInformacije o pregledu:\n    Tip pregleda:" +  pregledDTO.getTip().getNaziv() +
                "\n     Sala: " + pregledDTO.getSala().getNaziv() + " "+ pregledDTO.getSala().getBroj() +
                "\n     Doktor: " + pregledDTO.getDoktor().getIme() + " "+ pregledDTO.getDoktor().getPrezime() +
                "\n     Datum: " + pregledDTO.getDatum() + " u  "+ pregledDTO.getVreme() + "h" +

                "\n\nSrdacan pozdrav!\n\n\n\n" );
        javaMailSender.send(mail);

    }
    @Async
    public void posaljiMail(Long klinika)  throws MailException, InterruptedException{

        Klinika klinika1 = klinikaRepository.findById(klinika).orElse(null);
        AdministratorKlinike administratorKlinike = adminKlinikeRepository.findByKlinika(klinika1);

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(administratorKlinike.getEmail());
        mail.setFrom(environment.getProperty("spring.mail.username"));
        mail.setSubject("Novi zahtev za pregled");
        mail.setText("Poštovani, \n\n  " +
                "\nKreiran je novi zahtev za pregled.\n   "+
                "\nZa vise informacija posetite vas profil" +

                "\n\nSrdacan pozdrav!\n\n\n\n" );
        javaMailSender.send(mail);
    }
}
