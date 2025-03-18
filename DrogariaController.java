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
import com.projetojpa.Farmacia.Service.DrogariaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/drogarias")
public class DrogariaController {
    
    private final DrogariaService drogariaService;
    
    @Autowired
    public DrogariaController(DrogariaService drogariaService) {
        this.drogariaService = drogariaService;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Drogaria> getDrogariaById(@PathVariable Long id) {
        Drogaria drogaria = drogariaService.getDrogariaById(id);
        if (drogaria != null) {
            return ResponseEntity.ok(drogaria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Drogaria>> getAllDrogarias() {
        List<Drogaria> drogarias = drogariaService.getAllDrogarias();
        return ResponseEntity.ok(drogarias);
    }
    
    @PostMapping("/")
    public ResponseEntity<Drogaria> criarDrogaria(@RequestBody @Valid Drogaria drogaria) {
        Drogaria criarDrogaria = drogariaService.salvarDrogaria(drogaria);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarDrogaria);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Drogaria> updateDrogaria(@PathVariable Long id, @RequestBody Drogaria drogaria) {
        Drogaria updatedDrogaria = drogariaService.updateDrogaria(id, drogaria);
        if (updatedDrogaria != null) {
            return ResponseEntity.ok(updatedDrogaria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Drogaria> deleteDrogaria(@PathVariable Long id) {
        boolean deleted = drogariaService.deleteDrogaria(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}