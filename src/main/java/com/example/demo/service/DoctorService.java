package com.example.demo.service;


import java.util.ArrayList;
import java.util.NoSuchElementException;


import com.example.demo.dto.KlinikaDTO;
import com.example.demo.dto.PregledDTO;
import com.example.demo.model.Klinika;
import com.example.demo.model.Pregled;
import com.example.demo.repository.KlinikaRepository;
import com.example.demo.repository.PregledRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.model.Doktor;
import com.example.demo.repository.DoktorRepository;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;



@Service
public class DoctorService {

	@Autowired
	private DoktorRepository repository;
	@Autowired
	private KlinikaRepository klinikaRepository;
	@Autowired
	private PregledRepository pregledRepository;


//<<<<<<< HEAD
	public void addDoctor(DoctorDTO dDTO,Klinika klinika) {
//=======
	
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
			if(klinika != null) {
				d.setKlinika(klinika);
			}
			
			repository.save(d);
			
		}
		catch(IllegalArgumentException e) {
			throw new ValueException("Nije uspjesno dodati doktor");

		}

	}
	

	
	
	public ArrayList<DoctorDTO> izlistajDoktore (Long id){

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
				doktoroviPregledi = pregledRepository.getByDoktor(doktor);
				if (!doktoroviPregledi.isEmpty()) {
					//-------prolazi kroz sve preglede zadatog doktora i racuna njegovo zauzece za taj dan--------
					for (Pregled pregled : doktoroviPregledi) {
						Date datumPregleda = formatter.parse(pregled.getDatum());
						if (formatter.format(izabraniDatum).equals(formatter.format(datumPregleda))) {
							radniBrSati += Float.parseFloat(pregled.getTrajanje());
							//------------belezi broj zaizetih sati----------
							doctorDTO.getZauzetiSati().add(pregled.getVreme());
							if (Integer.parseInt(pregled.getTrajanje()) > 1) {
								Integer pocetakPregleda = Integer.parseInt(pregled.getVreme());
								for (int i = 1; i < Integer.parseInt(pregled.getTrajanje()); i++) {
									Integer vreme = pocetakPregleda + i;
									doctorDTO.getZauzetiSati().add(vreme.toString());
								}
							}
						}

					}
					if (radnoVremeDoktora - radniBrSati >= 1) {
						doctorDTOS.add(doctorDTO);
					}
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


}

	
	

	
	

