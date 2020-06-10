package com.example.demo.service;


import com.example.demo.dto.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class DoctorService {

	@Autowired
	private DoktorRepository repository;

	@Autowired
	private KlinikaRepository klinikaRepository;

	@Autowired
	private PregledRepository pregledRepository;

	@Autowired
	private OcenaDoktoraRepository ocenaDoktoraRepository;

	@Autowired
	private PacijentRepository pacijentRepository;

	public void addDoctor(DoctorDTO dDTO) {
		// TODO Auto-generated method stub
		Doktor d = new Doktor();
		try {
			d.setIme(dDTO.getIme());
			d.setPrezime(dDTO.getPrezime());
			d.setEmail(dDTO.getEmail());
			d.setLozinka(dDTO.getLozinka());
			d.setAdresa(dDTO.getAdresa());
			d.setGrad(dDTO.getGrad());
			d.setTelefon(dDTO.getTelefon());
			d.setDrzava(dDTO.getDrzava());
			d.setJmbg(dDTO.getJmbg());

			repository.save(d);

		} catch (IllegalArgumentException e) {
			throw new ValueException("Nije uspjesno dodati doktor");

		}

	}

	public ArrayList<DoctorDTO> izlistajDoktore(Long id) {
		Klinika klinika = klinikaRepository.findById(id).orElse(null);
		if (klinika == null) {
			throw new NoSuchElementException();
		}

		ArrayList<Doktor> doktori = repository.findByKlinika(klinika);
		ArrayList<DoctorDTO> doctorDTOS = new ArrayList<>();
		for (Doktor p : doktori) {
			DoctorDTO doctorDTO = new DoctorDTO(p);
			doctorDTOS.add(doctorDTO);
		}
		return doctorDTOS;
	}

	public ArrayList<DoctorDTO> izlistajDTO(ArrayList<Doktor> doktori) {
		ArrayList<DoctorDTO> doctorDTOS = new ArrayList<>();
		for (Doktor p : doktori) {
			DoctorDTO doctorDTO = new DoctorDTO(p);
			doctorDTOS.add(doctorDTO);
		}
		return doctorDTOS;
	}
	public ArrayList<Pregled> izlistajDoktorovePreglede(Doktor doktor, Date datum) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<Pregled> pregledi = new ArrayList<>();
		ArrayList<Pregled> sviPregledi = new ArrayList<>();
		sviPregledi = pregledRepository.getByDoktor(doktor);
		for (Pregled pregled : sviPregledi) {
			Date datumPregleda = formatter.parse(pregled.getDatum());
			if (formatter.format(datum).equals(formatter.format(datumPregleda))) {
				pregledi.add(pregled);
			}}
		return pregledi;
	}

	public ArrayList<DoctorDTO> pretrazi(String ime, String prezime, String tipPregleda, String datum, Long klinika) throws ParseException {
		//float radniBrSati = 0;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date izabraniDatum = formatter.parse(datum);

		//vracamo doktre kojima je broj radnih sati veci od broja zauzetih sati
		//samo doktori koji imaju bar sat vremena da tog dana izvrse pregled
		ArrayList<DoctorDTO> doctorDTOS = new ArrayList<>();
		if (datum != "") {
			ArrayList<Doktor> doktori = new ArrayList<Doktor>();
			doktori = repository.getByQuery(ime, prezime, tipPregleda, klinika);
			for (Doktor doktor : doktori) {
				float radnoVremeDoktora = 0;
				float radniBrSati = 0;
				radnoVremeDoktora = Float.parseFloat(doktor.getKrajRadnogVremena()) - Float.parseFloat(doktor.getPocetakRadnogVremena());
				DoctorDTO doctorDTO = new DoctorDTO(doktor);
				ArrayList<Pregled> doktoroviPregledi = new ArrayList<Pregled>();
				doktoroviPregledi = this.izlistajDoktorovePreglede(doktor, izabraniDatum);
				if (!doktoroviPregledi.isEmpty()) {
					//-------prolazi kroz sve preglede zadatog doktora i racuna njegovo zauzece za taj dan--------
					for (Pregled pregled : doktoroviPregledi) {
							radniBrSati += Float.parseFloat(pregled.getTrajanje());
							//------------belezi broj zaizetih sati----------
							doctorDTO.getZauzetiSati().add(pregled.getVreme());
							if (Integer.parseInt(pregled.getTrajanje()) > 1) {
								Integer pocetakPregleda = Integer.parseInt(pregled.getVreme());
								for (int i = 1; i < Integer.parseInt(pregled.getTrajanje()); i++) {
									Integer vreme = pocetakPregleda + i;
									//da bi onemogucili vreme na frontu moramo ga cuvati u formatu 01,02...
									if (vreme <= 9 ) {
										doctorDTO.getZauzetiSati().add("0"+vreme.toString());
									}else {
										doctorDTO.getZauzetiSati().add(vreme.toString());
									}
								}
							}
					}
					if (radnoVremeDoktora - radniBrSati >= 1) {
						doctorDTOS.add(doctorDTO);
					}
				} else {
					doctorDTOS.add(doctorDTO);
				}
			}
		} else {
			ArrayList<Doktor> doktori = new ArrayList<Doktor>();
			doktori = repository.getByQuery(ime, prezime, tipPregleda, klinika);
			doctorDTOS = izlistajDTO(doktori);
		}
		return doctorDTOS;
	}

	public ArrayList<KlinikaDTO> pretrziKlinike(String naziv, String adresa, String tipPregleda, String datum) throws ParseException {
		ArrayList<Klinika> klinike = new ArrayList<Klinika>();
		klinike = klinikaRepository.getByQuery(naziv,adresa);
		ArrayList<KlinikaDTO> klinikeDTO = new ArrayList<KlinikaDTO>();


		for(Klinika k : klinike){
			ArrayList<DoctorDTO> doctorDTOS = new ArrayList<DoctorDTO>();
			doctorDTOS = this.pretrazi("", "" , tipPregleda, datum, k.getId());
			if (!doctorDTOS.isEmpty()){
				klinikeDTO.add(new KlinikaDTO(k));
			}
		}
		return klinikeDTO;
	}

	public void napraviOcenuDoktora (Pacijent pacijent, Doktor doktor, Integer ocena ){
		OcenaDoktora ocenaDoktora = new OcenaDoktora();
		ocenaDoktora.setDoktor(doktor);
		ocenaDoktora.setOcena(ocena);
		ocenaDoktora.setPacijent(pacijent);
		ocenaDoktoraRepository.save(ocenaDoktora);
	}

	public DoctorDTO oceniDoktora (OcenaDoktoraDTO ocenaDoktoraDTO){

		Pacijent pacijent = pacijentRepository.findById(ocenaDoktoraDTO.getPacijent()).orElse(null);
		if (pacijent == null){
			throw new NoSuchElementException();
		}
		Doktor doktor = repository.findById(ocenaDoktoraDTO.getDoktor()).orElse(null);
		if (doktor == null){
			throw new NoSuchElementException();
		}

		OcenaDoktora ocenaDoktora = ocenaDoktoraRepository.findByPacijentAndDoktor(pacijent, doktor);
		if (ocenaDoktora != null) {
			throw new ValueException("Vec ste ocenili ovu kliniku");
		}
		this.napraviOcenuDoktora(pacijent, doktor, ocenaDoktoraDTO.getOcena());
		List<OcenaDoktora> oceneDoktora = ocenaDoktoraRepository.findByDoktor(doktor);
		Integer zbir=0;
		for(OcenaDoktora ocena : oceneDoktora ){
			zbir+=ocena.getOcena();
		}
		Double ocena = (double)zbir/(double)oceneDoktora.size();
		doktor.setOcena(ocena);
		repository.save(doktor);
		return new DoctorDTO(doktor);
	}


}

	
	
	

