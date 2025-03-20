package com.projetojpa.Farmacia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpa.Farmacia.Entity.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

}
