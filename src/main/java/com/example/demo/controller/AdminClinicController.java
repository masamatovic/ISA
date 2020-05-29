package com.example.demo.controller;

import java.util.ArrayList;

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
import com.example.demo.model.Klinika;
import com.example.demo.model.Sala;
import com.example.demo.service.AdminClinicService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.KlinikaService;
import com.example.demo.service.SalaService;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

@CrossOrigin
@RestController
@RequestMapping(value = "/adminKlinike")
public class AdminClinicController {

	private AdminClinicService adminClinicService;
	private KlinikaService clinicService;
	private DoctorService doctorService;
	private SalaService salaService;
	
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
	
//	dml operacije sa pregledima

	/**
	 * TODO:operacije sa pregledima
	 * */
//	dml operacije sa salama
	/**
	 *  TODO:operacije sa salama
	 * */
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
	
	@DeleteMapping(path="brisanjeSale/{id}")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity deleteSala(@PathVariable Long id) {
		SalaDTO sDTO = salaService.findSala(id);
		/**
		 * TODO: provjera da li je zazueta*/
		return new ResponseEntity<>("Izmjena sale pogresan zahtjev",HttpStatus.BAD_REQUEST);

		
	}

	
	
	
//	dml operacije sa doktorima
	@PostMapping(path="/dodajDoktora", consumes = "application/json", produces = "application/json")
	@PreAuthorize("hasAuthority('ADMIN_KLINIKE')")
	public ResponseEntity addDoctor(@RequestBody DoctorDTO dDTO) {
		
		/**
		 @ TODO:Dodavanje doktora 
		 @ TODO: radno vrijeme definisati
		 * */
		if(dDTO !=null) {
			try {

				doctorService.addDoctor(dDTO);
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
