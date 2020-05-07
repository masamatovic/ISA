package com.example.demo.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminClinicDTO;
import com.example.demo.model.AdministratorKlinickogCentra;
import com.example.demo.model.AdministratorKlinike;
import com.example.demo.repository.AdminKlinikeRepository;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

@Service
public class AdminClinicService {

	@Autowired
	private AdminKlinikeRepository repository;
	
	//findAdminClincByID
	public AdminClinicDTO findAdminClinic(Long id) {
		AdministratorKlinike adminClinic = repository.findById(id).orElse(null);
		if (adminClinic == null) {
			throw new ValueException("Administrator klinike sa datim id-em ne postoji");
		
		}
		return new AdminClinicDTO(adminClinic);
	}
	
	//modifikacija podataka AdminClinic
	public AdministratorKlinike modify(AdminClinicDTO acDTO) {
		AdministratorKlinike ac = repository.findById(acDTO.getId()).orElse(null);
		if (ac == null) {
			throw new ValueException("Administrator klinike sa datim id-em ne postoji");
		
		}
		 
		try {
			ac.setIme(acDTO.getIme());
			ac.setPrezime(acDTO.getPrezime());
			ac.setAdresa(acDTO.getAdresa());
			ac.setDrzava(acDTO.getDrzava());
			ac.setGrad(acDTO.getGrad());
			ac.setTelefon(acDTO.getTelefon());
			ac.setKlinika(acDTO.getKlinika());
			this.repository.save(ac);
		}
		catch(EntityNotFoundException e) {
			throw new ValueException("Izmjene administratora klinike nisu uspjesne");
		}
		
		return ac;
	}
	
	
	
	
}
