package com.cenfotec.examen2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cenfotec.examen2.entidades.Productor;

public interface ProductorRepository extends JpaRepository<Productor, Long> {

	public List<Productor> findBynombreProductorContaining(String nombreProductor);
    
}
