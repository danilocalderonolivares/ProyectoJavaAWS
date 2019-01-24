package com.cenfotec.examen2.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tipos_Cafe")
public class Cafe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String nombreTipo;
	
	@NotNull
	@ManyToMany(mappedBy = "tiposCafe")
	private List<Finca> fincas = new ArrayList<Finca>();

	
	
	
	public Cafe() {
		
	}
	public Cafe(String nombreCafe) {
		this.nombreTipo = nombreCafe;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	
	
	public List<Finca> getFincas() {
		return fincas;
	}
	public void setFincas(List<Finca> fincas) {
		this.fincas = fincas;
	}
	
	

}
