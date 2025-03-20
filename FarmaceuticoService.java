package com.projetojpa.Farmacia.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.Farmacia.Entity.Farmaceutico;
import com.projetojpa.Farmacia.Repository.FarmaceuticoRepository;

@Service
public class FarmaceuticoService {
	 private final FarmaceuticoRepository farmaceuticoRepository;
	 
	    @Autowired
	    public FarmaceuticoService(FarmaceuticoRepository farmaceuticoRepository) {
	        this.farmaceuticoRepository = farmaceuticoRepository;
	    }
	 
	    public List<Farmaceutico> getAllFarmaceutico() {
	        return farmaceuticoRepository.findAll();
	    }
	 
	    public Farmaceutico getFarmaceuticoById(Long id) {
	        Optional<Farmaceutico> farmaceutico = farmaceuticoRepository.findById(id);
	        return farmaceutico.orElse(null);
	    }
	 
	    public Farmaceutico salvarFarmaceutico(Farmaceutico farmaceutico) {
	        return farmaceuticoRepository.save(farmaceutico);
	    }
	 
	    public Farmaceutico updateFarmaceutico(Long id, Farmaceutico updatedFarmaceutico) {
	        Optional<Farmaceutico> existingFarmaceutico = farmaceuticoRepository.findById(id);
	        if (existingFarmaceutico.isPresent()) {
	            updatedFarmaceutico.setId(id);
	            return farmaceuticoRepository.save(updatedFarmaceutico);
	        }
	        return null;
	    }
	 
	    public boolean deleteFarmaceutico(Long id) {
	        Optional<Farmaceutico> existingFarmaceutico = farmaceuticoRepository.findById(id);
	        if (existingFarmaceutico.isPresent()) {
	        	farmaceuticoRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
}
