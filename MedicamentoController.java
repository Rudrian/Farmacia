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

import com.projetojpa.Farmacia.Entity.Drogaria;
import com.projetojpa.Farmacia.Entity.Medicamento;
import com.projetojpa.Farmacia.Service.MedicamentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;
    
    @Autowired
    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> getMedicamentoById(@PathVariable Long id) {
    	Medicamento medicamento = medicamentoService.getMedicamentoById(id);
        if (medicamento != null) {
            return ResponseEntity.ok(medicamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Medicamento>> getAllMedicamento() {
        List<Medicamento> medicamento = medicamentoService.getAllMedicamentos();
        return ResponseEntity.ok(medicamento);
    }
    
    @PostMapping("/")
    public ResponseEntity<Medicamento> criarMedicamento(@RequestBody @Valid Medicamento medicamento) {
    	Medicamento criarMedicamento = medicamentoService.salvarMedicamento(medicamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarMedicamento);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> updateMedicamento(@PathVariable Long id, @RequestBody Medicamento medicamento) {
    	Medicamento updatedMedicamento = medicamentoService.updateMedicamento(id, medicamento);
        if (updatedMedicamento != null) {
            return ResponseEntity.ok(updatedMedicamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Medicamento> deleteMedicamento(@PathVariable Long id) {
        boolean deleted = medicamentoService.deleteMedicamento(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
