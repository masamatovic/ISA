INSERT INTO public.klinika(
	adresa, drzava, grad, naziv, opis)
	VALUES ( 'Danila Kisa 21', 'Srbija' , 'Novi Sad', 'Klinika Maksic', 'Sve vrste pregleda i labaratorijskih ispitivanja.');
INSERT INTO public.klinika(
	adresa, drzava, grad, naziv, opis)
	VALUES ( 'Jovana Ducica 34', 'Srbija', 'Beograd', 'Poliklinika', 'Najbolje opramljena klinika sa najstrucnijim osobljem');
INSERT INTO public.klinika(
	adresa, drzava, grad, naziv, opis)
	VALUES ( 'Jovan Jovanovic Zmaj 113', 'Srbija', 'Novi Sad', 'Moja Klinika', 'Vase zdravlje nam je na prvom mestu');




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
	 adresa, drzava, email, grad, ime, jmbg, lozinka, prezime, telefon, karton_id)
	VALUES ('Sekspirova 5', 'Srbija', 'masa@gmail.com', 'Novi Sad', 'Masa', '5050', '$2y$12$LR4rL3FY8Z6ud1VZCB.hFuEftS6.7dvn.mXaV5CSl3P8rJoNQWIO2', 'Matovic', '384', 1);
INSERT INTO public.pacijent(
	 adresa, drzava, email, grad, ime, jmbg, lozinka, prezime, telefon,  karton_id)
	VALUES ('Mirijevski Venac 10', 'Srbija', 'steva@gmail.com', 'Beograd', 'Stevan', '0409', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Matovic', '85093', 2);
INSERT INTO public.pacijent(
	 adresa, drzava, email, grad, ime, jmbg, lozinka, prezime, telefon,  karton_id)
	VALUES ('NJegoseva 12', 'Srbija', 'nemanja@gmail.com', 'Backa Palanka', 'Stevan', '2105', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Kovacevic', '894204', 3);



INSERT INTO public.doktor(
	 adresa, drzava, email, grad, ime, jmbg, lozinka, prezime, telefon)
	VALUES ('Kralja Petra I 98', 'Srbija', 'marko@gmail.com', 'Beograd', 'Marko', '4820', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Markovic', '48920');
INSERT INTO public.doktor(
	 adresa, drzava, email, grad, ime, jmbg, lozinka, prezime, telefon)
	VALUES ('Mirijevski Venac 18', 'Srbija', 'mirko@gmail.com', 'Beograd', 'Mirko', '86004', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Mirkovic', '85093');
INSERT INTO public.doktor(
	 adresa, drzava, email, grad, ime, jmbg, lozinka, prezime, telefon)
	VALUES ('Vuka Karadica 78', 'Srbija', 'srecko@gmail.com', 'Pozarevac', 'Srecko', '5029458', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Sreckovic', '894204');


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
	 adresa, drzava, email, grad, ime, jmbg, lozinka, prezime, telefon)
	VALUES ('Kneza Milosa 56', 'Srbija', 'admink@gmail.com', 'Novi Sad', 'Sara', '5029458', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Saric', '894204');





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

INSERT INTO public.sestra_authority (sestra_id, authority_id) VALUES (1, 4);
INSERT INTO public.sestra_authority (sestra_id, authority_id) VALUES (2, 4);

INSERT INTO public.pacijent_authority (pacijent_id, authority_id) VALUES (1, 5);
INSERT INTO public.pacijent_authority (pacijent_id, authority_id) VALUES (2, 5);
INSERT INTO public.pacijent_authority (pacijent_id, authority_id) VALUES (3, 5);


