package com.cenfotec.examen2.entidades;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "direcciones")
public class Direccion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String direccionDominal;
	
	@NotNull
	private String provincia;
	
	
	
	
	public Direccion() {

	}

	public Direccion(String direccionDominal,String provincia) {
		
		this.direccionDominal = direccionDominal;
		this.provincia = provincia;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDireccionDominal() {
		return direccionDominal;
	}

	public void setDireccionDominal(String direccionDominal) {
		this.direccionDominal = direccionDominal;
	}

	

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	
	
	

}
