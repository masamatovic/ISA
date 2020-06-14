INSERT INTO public.klinika(
	adresa, drzava, grad, naziv, opis, ocena)
	VALUES ( 'Danila Kisa 21', 'Srbija' , 'Novi Sad', 'Klinika Maksic', 'Sve vrste pregleda i labaratorijskih ispitivanja.', 4.85);
INSERT INTO public.klinika(
	adresa, drzava, grad, naziv, opis, ocena)
	VALUES ( 'Jovana Ducica 34', 'Srbija', 'Beograd', 'Poliklinika', 'Najbolje opramljena klinika sa najstrucnijim osobljem', 4.57);
INSERT INTO public.klinika(
	adresa, drzava, grad, naziv, opis, ocena)
	VALUES ( 'Jovan Jovanovic Zmaj 113', 'Srbija', 'Novi Sad', 'Moja Klinika', 'Vase zdravlje nam je na prvom mestu', 5.0);

INSERT INTO public.sala(broj, naziv, vrsta_sale, klinika_id) VALUES ( '5A', 'Operaciona sala', true, 1);
INSERT INTO public.sala(broj, naziv, vrsta_sale, klinika_id) VALUES ( '5B', 'Sala za preglede', false, 1);
INSERT INTO public.sala(broj, naziv, vrsta_sale, klinika_id) VALUES ( '3', 'Operaciona sala', true, 2);
INSERT INTO public.sala(broj, naziv, vrsta_sale, klinika_id) VALUES ( '4', 'Sala za preglede', false, 2);
INSERT INTO public.sala(broj, naziv, vrsta_sale, klinika_id) VALUES ( '76', 'Operaciona sala', true, 3);
INSERT INTO public.sala(broj, naziv,  vrsta_sale, klinika_id) VALUES ( '32', 'Sala za preglede', false ,3);


INSERT INTO public.tip_pregleda(cena, naziv, klinika_id) VALUES ('3000', 'EKG', 1);
INSERT INTO public.tip_pregleda(cena, naziv, klinika_id) VALUES ('2500','Ultrazvuk', 1);
INSERT INTO public.tip_pregleda(cena, naziv, klinika_id) VALUES ('4000','EKG', 2);
INSERT INTO public.tip_pregleda(cena, naziv, klinika_id) VALUES ('1500','Pregled oka', 2);
INSERT INTO public.tip_pregleda(cena, naziv, klinika_id) VALUES ('3800','EKG', 3);
INSERT INTO public.tip_pregleda(cena, naziv, klinika_id) VALUES ('3000','Ultrazvuk', 3);


INSERT INTO public.zdravstveni_karton(
	 alergije, dioptrija, krvna_grupa, pol, tezina, visina)
	VALUES ('ambrozija, brufen', 'nema', '0+', 'Ž', '60', '166');
INSERT INTO public.zdravstveni_karton(
	 alergije, dioptrija, krvna_grupa, pol, tezina, visina)
	VALUES ('nema', '+0.75', '0-', 'M', '89', '196');
INSERT INTO public.zdravstveni_karton(
	 alergije, dioptrija, krvna_grupa, pol, tezina, visina)
	VALUES ('aspirin', '+0.75', 'A+', 'M', '92', '190');


INSERT INTO public.pacijent(
	 adresa, aktivan,  drzava, email, grad, ime, jmbg, lozinka, prezime, telefon, karton_id)
	VALUES ('Sekspirova 5', true, 'Srbija', 'masa@gmail.com', 'Novi Sad', 'Masa', '5050', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Matovic', '384', 1);
INSERT INTO public.pacijent(
	 adresa, aktivan, drzava, email, grad, ime, jmbg, lozinka, prezime, telefon,  karton_id)
	VALUES ('Mirijevski Venac 10', true, 'Srbija', 'steva@gmail.com', 'Beograd', 'Stevan', '0409', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Matovic', '85093', 2);
INSERT INTO public.pacijent(
	 adresa, aktivan, drzava, email, grad, ime, jmbg, lozinka, prezime, telefon,  karton_id)
	VALUES ('NJegoseva 12', true, 'Srbija', 'nemanja@gmail.com', 'Backa Palanka', 'Nemanja', '2105', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Kovacevic', '894204', 3);



INSERT INTO public.doktor(
	 adresa, drzava, email, grad, ime, jmbg, kraj_radnog_vremena, lozinka, pocetak_radnog_vremena, prezime, telefon, tip_pregleda, klinika_id, ocena)
	VALUES ('Kralja Petra I 98', 'Srbija', 'marko@gmail.com', 'Novi Sad', 'Marko', '4820', '12', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '06', 'Markovic', '48920', 1, 1, 4.8);

INSERT INTO public.doktor(
	 adresa, drzava, email, grad, ime, jmbg, kraj_radnog_vremena, lozinka, pocetak_radnog_vremena, prezime, telefon, tip_pregleda, klinika_id, ocena)
	VALUES ('Kralja Petra I 98', 'Srbija', 'zivko@gmail.com', 'Beograd', 'Zivko', '4820', '18', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '10', 'Pavlovic', '48920', 1, 1, 4.8);

INSERT INTO public.doktor(
	 adresa, drzava, email, grad, ime, jmbg, kraj_radnog_vremena, lozinka, pocetak_radnog_vremena, prezime, telefon, tip_pregleda, klinika_id, ocena)
	VALUES ('Kralja Petra I 98', 'Srbija', 'jako@gmail.com', 'Zrenjanin', 'Janko', '4820', '23', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '18', 'Markovic', '48920', 2, 1, 4.8);

INSERT INTO public.doktor(
	 adresa, drzava, email, grad, ime, jmbg, kraj_radnog_vremena, lozinka, pocetak_radnog_vremena, prezime, telefon, tip_pregleda, klinika_id, ocena)
	VALUES ('Mirijevski Venac 18', 'Srbija', 'aca@gmail.com', 'Obrenovac', 'Aca', '86004', '12', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '06', 'Mirkovic', '85093', 3, 2, 4.5);
INSERT INTO public.doktor(
	 adresa, drzava, email, grad, ime, jmbg, kraj_radnog_vremena, lozinka, pocetak_radnog_vremena, prezime, telefon, tip_pregleda, klinika_id, ocena)
	VALUES ('Mirijevski Venac 18', 'Srbija', 'peca@gmail.com', 'Beograd', 'Peca', '86004', '16', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '08', 'Mirkovic', '85093', 4, 2, 4.8);
INSERT INTO public.doktor(
	 adresa, drzava, email, grad, ime, jmbg, kraj_radnog_vremena, lozinka, pocetak_radnog_vremena, prezime, telefon, tip_pregleda, klinika_id, ocena)
	VALUES ('Mirijevski Venac 18', 'Srbija', 'neca@gmail.com', 'Beograd', 'Neca', '86004', '22', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '15', 'Mirkovic', '85093', 3, 2, 5.0);

INSERT INTO public.doktor(
	 adresa, drzava, email, grad, ime, jmbg, kraj_radnog_vremena, lozinka, pocetak_radnog_vremena, prezime, telefon, tip_pregleda, klinika_id, ocena)
	VALUES ('Vuka Karadica 78', 'Srbija', 'mima@gmail.com', 'Novi Sad', 'Mima', '5029458', '15', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '08', 'Sreckovic', '894204', 5, 3, 4.9);

INSERT INTO public.doktor(
	 adresa, drzava, email, grad, ime, jmbg, kraj_radnog_vremena, lozinka, pocetak_radnog_vremena, prezime, telefon, tip_pregleda, klinika_id, ocena)
	VALUES ('Vuka Karadica 78', 'Srbija', 'mina@gmail.com', 'Novi Sad', 'Mina', '5029458', '20', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '12', 'Sreckovic', '894204', 5, 3, 4.8);

INSERT INTO public.doktor(
	 adresa, drzava, email, grad, ime, jmbg, kraj_radnog_vremena, lozinka, pocetak_radnog_vremena, prezime, telefon, tip_pregleda, klinika_id, ocena)
	VALUES ('Vuka Karadica 78', 'Srbija', 'nina@gmail.com', 'Backa Palanka', 'Nina', '5029458', '20', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '16', 'Sreckovic', '894204', 6, 3, 4.8);


INSERT INTO public.medicinska_sestra(
	 adresa, drzava, email, grad, ime, jmbg, lozinka, prezime, telefon)
	VALUES ('Kralja Petra I', 'Srbija', 'mirka@gmail.com', 'Beograd', 'Mirka', '4829734', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Mirkovic', '539058');
INSERT INTO public.medicinska_sestra(
	 adresa, drzava, email, grad, ime, jmbg, lozinka, prezime, telefon)
	VALUES ('Mirijevski Venac 18', 'Srbija', 'mirko@gmail.com', 'Novi Sad', 'Zika', '532598723', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Zikic', '6436353');




INSERT INTO public.administrator_klinickog_centra(
    adresa, drzava, email, grad, ime, jmbg, lozinka, prezime, telefon)
	VALUES ('Brace Ribnikara 12', 'Srbija', 'adminkc@gmail.com', 'Kragujevac', 'Zoran', '490582', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Zoranic', '30949');



INSERT INTO public.administrator_klinike(
	 adresa, drzava, email, grad, ime, jmbg, lozinka, prezime, telefon, klinika_id)
	VALUES ('Kneza Milosa 56', 'Srbija', 'masa.matovic@uns.ac.rs', 'Novi Sad', 'Sara', '5029458', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Saric', '894204', 1);
INSERT INTO public.administrator_klinike(
	 adresa, drzava, email, grad, ime, jmbg, lozinka, prezime, telefon, klinika_id)
	VALUES ('Kneza Milosa 56', 'Srbija', 'masa.matovic@uns.ac.rs', 'Novi Sad', 'Ana', '5029458', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Nikolasevic', '894204', 2);
INSERT INTO public.administrator_klinike(
	 adresa, drzava, email, grad, ime, jmbg, lozinka, prezime, telefon, klinika_id)
	VALUES ('Kneza Milosa 56', 'Srbija', 'masa.matovic@uns.ac.rs', 'Novi Sad', 'Milica', '5029458', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Culibrk', '894204', 3);





INSERT INTO public.authority (uloga) VALUES ('ADMIN_KCENTRA');
INSERT INTO public.authority (uloga) VALUES ('ADMIN_KLINIKE');
INSERT INTO public.authority (uloga) VALUES ('LEKAR');
INSERT INTO public.authority (uloga) VALUES ('MEDICINSKA_SESTRA');
INSERT INTO public.authority (uloga) VALUES ('PACIJENT');



INSERT INTO public.adminkc_authority (adminkc_id, authority_id) VALUES (1, 1);

INSERT INTO public.adminklinike_authority (adminklinike_id, authority_id) VALUES (1, 2);


INSERT INTO public.doktor_authority (doktor_id, authority_id) VALUES (1, 3);
INSERT INTO public.doktor_authority (doktor_id, authority_id) VALUES (2, 3);
INSERT INTO public.doktor_authority (doktor_id, authority_id) VALUES (3, 3);
INSERT INTO public.doktor_authority (doktor_id, authority_id) VALUES (4, 3);
INSERT INTO public.doktor_authority (doktor_id, authority_id) VALUES (5, 3);

INSERT INTO public.sestra_authority (sestra_id, authority_id) VALUES (1, 4);
INSERT INTO public.sestra_authority (sestra_id, authority_id) VALUES (2, 4);

INSERT INTO public.pacijent_authority (pacijent_id, authority_id) VALUES (1, 5);
INSERT INTO public.pacijent_authority (pacijent_id, authority_id) VALUES (2, 5);
INSERT INTO public.pacijent_authority (pacijent_id, authority_id) VALUES (3, 5);



/*  unapred definisani pregledi */
INSERT INTO public.pregled(
	cena, datum, odobren, popust, trajanje, vreme, doktor_id, klinika_id, pacijent_id, sala_id, tip_pregleda_id)
	VALUES ( 3000, '2020-06-14', false, 'nema','3', '16', 1, 1, null, 1, 1);
INSERT INTO public.pregled(
	cena, datum,  odobren, popust, trajanje, vreme, doktor_id, klinika_id, pacijent_id, sala_id, tip_pregleda_id)
	VALUES ( 2000, '2020-06-14', false , 'nema','3', '16', 1, 1, null, 2, 1);
INSERT INTO public.pregled(
	cena, datum,  odobren, popust, trajanje, vreme, doktor_id, klinika_id, pacijent_id, sala_id, tip_pregleda_id)
	VALUES ( 1500, '2020-06-14', false, 'nema','3', '16', 2, 1, null, 3, 1);
INSERT INTO public.pregled(
	cena, datum,  odobren, popust, trajanje, vreme, doktor_id, klinika_id, pacijent_id, sala_id, tip_pregleda_id)
	VALUES ( 2500, '2020-06-22', false , 'nema','3', '06', 4, 2, null, 3, 3);
INSERT INTO public.pregled(
	cena, datum,  odobren, popust, trajanje, vreme, doktor_id, klinika_id, pacijent_id, sala_id, tip_pregleda_id)
	VALUES ( 2000, '2020-06-22', false , 'nema','3', '09', 4, 2, null, 3, 3);
INSERT INTO public.pregled(
	cena, datum,  odobren, popust, trajanje, vreme, doktor_id, klinika_id, pacijent_id, sala_id, tip_pregleda_id)
	VALUES ( 1750, '2020-06-23', false , 'nema','3', '06', 7, 3, null, 5, 5);
INSERT INTO public.pregled(
	cena, datum,  odobren, popust, trajanje, vreme, doktor_id, klinika_id, pacijent_id, sala_id, tip_pregleda_id)
	VALUES ( 2800, '2020-06-24', false , 'nema','1', '17', 9, 3, null, 6, 6);

/*  urezervisani pregledi pregledi */
INSERT INTO public.pregled(
	cena, datum,  odobren, popust, trajanje, vreme, doktor_id, klinika_id, pacijent_id, sala_id, tip_pregleda_id)
	VALUES ( 2000, '2020-06-20', true , 'nema','3', '06', 4, 2, 1, 3, 3);
INSERT INTO public.pregled(
	cena, datum,  odobren, popust, trajanje, vreme, doktor_id, klinika_id, pacijent_id, sala_id, tip_pregleda_id)
	VALUES ( 2000, '2020-06-20', true , 'nema','3', '09', 4, 2, 2, 3, 3);
INSERT INTO public.pregled(
	cena, datum,  odobren, popust, trajanje, vreme, doktor_id, klinika_id, pacijent_id, sala_id, tip_pregleda_id)
	VALUES ( 2000, '2020-06-20', true , 'nema','3', '09', 5, 2, 3, 4, 4);
INSERT INTO public.pregled(
	cena, datum,  odobren, popust, trajanje, vreme, doktor_id, klinika_id, pacijent_id, sala_id, tip_pregleda_id)
	VALUES ( 2000, '2020-06-20', true , 'nema','1', '14', 5, 2, 3, 4, 4);
INSERT INTO public.pregled(
	cena, datum,  odobren, popust, trajanje, vreme, doktor_id, klinika_id, pacijent_id, sala_id, tip_pregleda_id)
	VALUES ( 2000, '2020-06-20', true , 'nema','1', '16', 6, 2, 3, 3, 3);
INSERT INTO public.pregled(
	cena, datum,  odobren, popust, trajanje, vreme, doktor_id, klinika_id, pacijent_id, sala_id, tip_pregleda_id)
	VALUES ( 2000, '2020-06-20', true , 'nema','3', '20', 6, 2, 1, 3, 3);

/*  istorija pregleda  */
INSERT INTO public.pregled(
	cena, datum,  odobren, popust, trajanje, vreme, doktor_id, klinika_id, pacijent_id, sala_id, tip_pregleda_id)
	VALUES ( 2000, '2020-06-8', true , 'nema','1', '15', 6, 2, 1, 3, 3);
INSERT INTO public.pregled(
	cena, datum,  odobren, popust, trajanje, vreme, doktor_id, klinika_id, pacijent_id, sala_id, tip_pregleda_id)
	VALUES ( 1500, '2020-06-10', true, 'nema','3', '16', 2, 1, 1, 3, 1);


INSERT INTO public.zahtev_za_registraciju(
	 adresa, drzava, email, grad, ime, jmbg, lozinka, odobren, prezime, telefon)
	VALUES ( 'Vojvode Misica', 'Drzava', 'zlata@gmail.com', 'Beograd', 'Zlata', '473292940', '123', false , 'Zlatic', '0493727');