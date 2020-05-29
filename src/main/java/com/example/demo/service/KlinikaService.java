package com.example.demo.service;


import com.example.demo.dto.DoctorDTO;
import com.example.demo.dto.KlinikaDTO;
import com.example.demo.dto.TipPregledaDTO;
import com.example.demo.model.Doktor;
import com.example.demo.model.Klinika;
import com.example.demo.model.TipPregleda;
import com.example.demo.repository.KlinikaRepository;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KlinikaService {

    @Autowired
    private KlinikaRepository repository;

    public KlinikaDTO izlistajKliniku (Long id){
        Klinika klinika = repository.findById(id).orElse(null);
        if (klinika ==null){
            throw new ValueException("Nije pronadjena klinika sa ovim idem");
        }
        return new KlinikaDTO(klinika);
    }

    public List<KlinikaDTO> izlistajKlinike(){

        List<KlinikaDTO> klinikaDTOS = new ArrayList<>();
        List<Klinika> klinike = repository.findAll();
        if(klinike.isEmpty()){
            throw new ValueException("U sistemu nema klinika");
        }

        for (Klinika k : klinike){
            klinikaDTOS.add(new KlinikaDTO(k));
        }
        return klinikaDTOS;
    }

    public List<Klinika> sortiraj (String vrednost){

         if (vrednost.equals("naziv"))
             return repository.findAllByOrderByNazivAsc();
         else if (vrednost.equals("grad"))
             return repository.findAllByOrderByGradAsc();
         else
             return repository.findAll();

    }

	public ArrayList<DoctorDTO> getAllDoctors(Long id) {
		// TODO Auto-generated method stub
		ArrayList<DoctorDTO> doctorDTOList = new ArrayList<>();
		Klinika klinika = repository.findById(id).orElse(null);
		
		if(klinika == null) {
            throw new ValueException("Nije pronadjena klinika sa ovim idem");
		}
		
		List<Doktor> doctorList = klinika.getDoktor();
		for(Doktor d : doctorList) {
			doctorDTOList.add(new DoctorDTO(d));
		}
		
		return doctorDTOList;
	}

	public ArrayList<TipPregledaDTO> izlistajTipovePregledaKlinike (Long id){
        Klinika klinika = repository.findById(id).orElse(null);

        if(klinika == null) {
            throw new ValueException("Nije pronadjena klinika sa ovim idem");
        }
        List<TipPregleda> tipoviPregleda = klinika.getTipPregleda();
        ArrayList <TipPregledaDTO> tipPregledaDTOS = new ArrayList<>();
        for (TipPregleda tipPregleda: tipoviPregleda) {
            tipPregledaDTOS.add(new TipPregledaDTO(tipPregleda));
        }
        return tipPregledaDTOS;
    }

	public Klinika findClinic(Long id) {
		Klinika k = repository.findById(id).orElse(null);
		
		return k;
		
	}

}
