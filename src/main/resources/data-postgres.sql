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
	VALUES ('Sekspirova 5', 'Srbija', 'masa@gmail.com', 'Novi Sad', 'Masa', '5050', 'masaklin', 'Matovic', '384', 1);

INSERT INTO public.pacijent(
	 adresa, drzava, email, grad, ime, jmbg, lozinka, prezime, telefon,  karton_id)
	VALUES ('Mirijevski Venac 10', 'Srbija', 'steva@gmail.com', 'Beograd', 'Stevan', '0409', 'stevica', 'Matovic', '85093', 2);

INSERT INTO public.pacijent(
	 adresa, drzava, email, grad, ime, jmbg, lozinka, prezime, telefon,  karton_id)
	VALUES ('NJegoseva 12', 'Srbija', 'nemanja@gmail.com', 'Backa Palanka', 'Stevan', '2105', 'neca', 'Kovacevic', '894204', 3);
