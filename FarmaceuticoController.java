package com.projetojpa.Farmacia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.Farmacia.Entity.Farmaceutico;
import com.projetojpa.Farmacia.Service.FarmaceuticoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/farmaceuticos")
public class FarmaceuticoController {

    private final FarmaceuticoService farmaceuticoService;
    
    @Autowired
    public FarmaceuticoController(FarmaceuticoService farmaceuticoService) {
        this.farmaceuticoService = farmaceuticoService;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Farmaceutico> getFarmaceuticoById(@PathVariable Long id) {
    	Farmaceutico farmaceutico = farmaceuticoService.getFarmaceuticoById(id);
        if (farmaceutico != null) {
            return ResponseEntity.ok(farmaceutico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Farmaceutico>> getAllFarmaceuticos() {
        List<Farmaceutico> farmaceuticos = farmaceuticoService.getAllFarmaceutico();
        return ResponseEntity.ok(farmaceuticos);
    }
    
    @PostMapping("/")
    public ResponseEntity<Farmaceutico> criarFarmaceutico(@RequestBody @Valid Farmaceutico farmaceutico) {
    	Farmaceutico criarFarmaceutico = farmaceuticoService.salvarFarmaceutico(farmaceutico);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarFarmaceutico);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Farmaceutico> updateFarmaceutico(@PathVariable Long id, @RequestBody Farmaceutico farmaceutico) {
    	Farmaceutico updatedFarmaceutico = farmaceuticoService.updateFarmaceutico(id, farmaceutico);
        if (updatedFarmaceutico != null) {
            return ResponseEntity.ok(updatedFarmaceutico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Farmaceutico> deleteFarmaceutico(@PathVariable Long id) {
        boolean deleted = farmaceuticoService.deleteFarmaceutico(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
