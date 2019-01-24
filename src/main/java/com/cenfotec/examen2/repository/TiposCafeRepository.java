package com.cenfotec.examen2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cenfotec.examen2.entidades.Cafe;

public interface TiposCafeRepository extends JpaRepository<Cafe, Long> {

}
