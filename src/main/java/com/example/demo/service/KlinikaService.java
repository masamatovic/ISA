package com.example.demo.service;


import com.example.demo.dto.DoctorDTO;
import com.example.demo.dto.KlinikaDTO;
import com.example.demo.dto.OcenaKlinikeDTO;
import com.example.demo.dto.TipPregledaDTO;
import com.example.demo.model.*;
import com.example.demo.repository.KlinikaRepository;
import com.example.demo.repository.OcenaKlinikeRepository;
import com.example.demo.repository.PacijentRepository;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class KlinikaService {

    @Autowired
    private KlinikaRepository repository;

    @Autowired
    private PacijentRepository pacijentRepository;

    @Autowired
    private OcenaKlinikeRepository ocenaKlinikeRepository;

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

	public void napraviOcenuKlinike (Pacijent pacijent, Klinika klinika, Integer ocena ){
        OcenaKlinike ocenaKlinike = new OcenaKlinike();
        ocenaKlinike.setKlinika(klinika);
        ocenaKlinike.setOcena(ocena);
        ocenaKlinike.setPacijent(pacijent);
        ocenaKlinikeRepository.save(ocenaKlinike);
    }

	public KlinikaDTO oceniKliniku (OcenaKlinikeDTO ocenaKlinikeDTO){

        Pacijent pacijent = pacijentRepository.findById(ocenaKlinikeDTO.getPacijent()).orElse(null);
        if (pacijent == null){
            throw new NoSuchElementException();
        }
        Klinika klinika = repository.findById(ocenaKlinikeDTO.getKlinika()).orElse(null);
        if (klinika == null){
            throw new NoSuchElementException();
        }

        OcenaKlinike ocenaKlinike = ocenaKlinikeRepository.findByPacijentAndKlinika(pacijent, klinika);
        if (ocenaKlinike != null) {
            throw new ValueException("Vec ste ocenili ovu kliniku");
        }
        this.napraviOcenuKlinike(pacijent, klinika, ocenaKlinikeDTO.getOcena());
        List<OcenaKlinike> oceneKlinike = ocenaKlinikeRepository.findByKlinika(klinika);
        Integer zbir=0;
        for(OcenaKlinike ocena : oceneKlinike ){
            zbir+=ocena.getOcena();
        }
        Double ocena = (double)zbir/(double)oceneKlinike.size();
        klinika.setOcena(ocena);
        repository.save(klinika);
        return new KlinikaDTO(klinika);
    }

}
