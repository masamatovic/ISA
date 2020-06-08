package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdminClinicDTO;
import com.example.demo.dto.DoctorDTO;
import com.example.demo.dto.SalaDTO;
import com.example.demo.dto.TipPregledaDTO;
import com.example.demo.model.Klinika;
import com.example.demo.model.Sala;
import com.example.demo.model.TipPregleda;
import com.example.demo.service.AdminClinicService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.KlinikaService;
import com.example.demo.service.SalaService;
import com.example.demo.service.TipPregledaService;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

@CrossOrigin
@RestController
@RequestMapping(value = "/adminKlinike")
public class AdminClinicController {
	@Autowired
	private AdminClinicService adminClinicService;
	@Autowired
	private KlinikaService clinicService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private SalaService salaService;
	@Autowired
	private TipPregledaService tipPService;
	
	@GetMapping(path = "/adminInfo/{id}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity adminInfo(@PathVariable Long id) {
		AdminClinicDTO acDTO = adminClinicService.findAdminClinic(id);
		if(acDTO != null) {
			try {
				return new ResponseEntity(acDTO,HttpStatus.OK);
			}
			catch(ValueException e) {
				return new ResponseEntity(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
			}
		}
		
		return new ResponseEntity("Pogresan zahtjev ", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping(path="/adminAzuriranje",consumes = "application/json", produces = "application/json")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity adminModify(@RequestBody AdminClinicDTO acDTO) {
		if(acDTO != null) {
			try {
				adminClinicService.modify(acDTO);
				return new ResponseEntity<>(acDTO,HttpStatus.OK);
			}
			catch(ValueException e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
			}
		}
		return new ResponseEntity("Admin klinike pogresan zahtev", HttpStatus.BAD_REQUEST); 
	}
	
//	dml operacije sa tipovima pregledima

	/**
	 * TODO:operacije sa tipovima pregledima
	 * */
	@GetMapping(path = "/sviTipoviPregleda/{clinicId}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<?> getAllTipPregleda(@PathVariable Long clinicId){
		ArrayList<TipPregledaDTO> listTPDTO = clinicService.getAllTP(clinicId);
		if(listTPDTO == null) {
			return new ResponseEntity<> ("GRESKA izlistavanje tipova pregleda",HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<> (listTPDTO,HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/unosTipaPregleda/{clinicId}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<?> createTipPregleda(@RequestBody TipPregledaDTO tpDTO, @PathVariable Long clinicId){
		Klinika klinika = clinicService.findClinic(clinicId);
		if(klinika != null && tpDTO != null) {
			try {
				tpDTO = tipPService.addTipPregleda(tpDTO, klinika);
				return new ResponseEntity<> (tpDTO,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<> ("GRESKA u kreiranju tipa pregleda", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<> ("GRESKA tip pregleda ne predvidjena greska",HttpStatus.BAD_REQUEST);
		
		
	}
	
	@PutMapping(path = "/izmjenaTipaPregleda")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<?> modifyTipPregleda(@RequestBody TipPregledaDTO tpDTO){
		TipPregleda tp = tipPService.modifyTipPregleda(tpDTO);
		if(tp == null) {
			return new ResponseEntity<> ("GRESKA tip pregleda ne postoji",HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<> (tpDTO, HttpStatus.OK);
		
		
	}
	
	@DeleteMapping(path = "/brisanjeTipZahtjeva/{id}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity<?> deleteTipPregleda(@PathVariable Long id){
		try {
			
			if(tipPService.deleteTipPregleda(id)) {
				return new ResponseEntity<> ("Uspjesno obirsan tip pregleda", HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<> ("Neuspjesno obirsan tip pregleda, izuzetak", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<> ("Tip pregleda nije obrisan, ima zauzet pregled", HttpStatus.FORBIDDEN);
	}
	
//	dml operacije sa salama
	/**
	 *  TODO:operacije sa salama
	 * */
	//listanje svih sala
	@GetMapping(path="/listanjeSala/{clinicId}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity getAllSale(@PathVariable Long clinicId ) {
		
		//Klinika klinika = clinicService.findClinic(clinicId);
		
		ArrayList<SalaDTO> listSalaDTO = (ArrayList<SalaDTO>) clinicService.getAllSala(clinicId);
		if(listSalaDTO == null) {
			return new ResponseEntity<>("Listanje sala pogresan zahtjev",HttpStatus.BAD_REQUEST);
 
		}
		return new ResponseEntity<>(listSalaDTO,HttpStatus.OK);	
	}
	
	//dodavanje sale
	@PostMapping(path="/dodajSalu/{clinicId}", consumes = "application/json", produces = "application/json")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity addSala(@RequestBody SalaDTO sDTO, @PathVariable Long clinicId){
		
		Klinika klinika = clinicService.findClinic(clinicId);
		Sala sala = new Sala();
		
		if(sDTO != null && klinika != null) {
				try {
					sDTO = salaService.addSala(sDTO,klinika);
					return new ResponseEntity<>(sDTO,HttpStatus.OK);
				}
				catch(Exception e) {
					return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
				}
			}
			
			return new ResponseEntity<>("Dodavanje sale pogresan zahtjev",HttpStatus.BAD_REQUEST);
		
	}
	
	//modifikacija sale
	@PutMapping(path="/modifikujeSalu/{clinicId}", consumes = "application/json", produces = "application/json")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity modifySala(@RequestBody SalaDTO sDTO, @PathVariable Long clinicId) {
		Klinika klinika = clinicService.findClinic(clinicId);
		
		if(sDTO.isZauzece()) {
			return new ResponseEntity<>("Sala je zauzeta i ne moze biti modifikovana", HttpStatus.BAD_REQUEST);
		}
		
		if(sDTO != null && klinika!=null) {
			try {
				salaService.modifySala(sDTO, klinika);
				return new ResponseEntity<>(sDTO,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);				
			}
		}
		return new ResponseEntity<>("Izmjena sale pogresan zahtjev",HttpStatus.BAD_REQUEST);

	}
	
	//brisanje sale
	@DeleteMapping(path="brisanjeSale/{clinicId}/{salaId}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity deleteSala(@PathVariable Long salaId,@PathVariable Long clinicId) {
		SalaDTO sDTO = salaService.findSala(salaId);
		Klinika klinika = clinicService.findClinic(clinicId);
		/**
		 * TODO: logicko ili fizicko brisanje
		 * */
		if( sDTO.isZauzece() || sDTO == null) {
			return new ResponseEntity ("Brisanje sale nije dozvoljeno jer je zauzeta", HttpStatus.METHOD_NOT_ALLOWED);
		}
		
		try {
			salaService.deleteSala(salaId, klinika);
		}
		catch(ValueException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return new ResponseEntity<>("Sala uspjesno obrisana",HttpStatus.OK);

		
	}

//	dml operacije sa doktorima
	@PostMapping(path="/dodajDoktora/{clinicId}", consumes = "application/json", produces = "application/json")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity addDoctor(@RequestBody DoctorDTO dDTO, @PathVariable Long clinicId) {
		
		Klinika klinika = clinicService.findClinic(clinicId);
		
		/**
		 @ TODO:Dodavanje doktora 
		 @ TODO: radno vrijeme definisati
		 * */
		if(dDTO !=null) {
			try {

				doctorService.addDoctor(dDTO,klinika);
				return new ResponseEntity<>(dDTO,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
			}
		}
		
		return new ResponseEntity<>("Dodavanje doktora pogresan zahtjev",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(path="/listaDoktoraKlinike/{id}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity listDoctors(@PathVariable Long clinicId){
		ArrayList<DoctorDTO> doctorList = clinicService.getAllDoctors(clinicId);
		
		if(doctorList == null) {
			return new ResponseEntity<>("Listanje doktora pogresan zahtjev",HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<>(doctorList,HttpStatus.OK);

	
	}
	
	
	
	
	
}
