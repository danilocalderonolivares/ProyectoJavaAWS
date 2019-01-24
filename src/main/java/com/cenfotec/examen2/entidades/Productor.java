package com.cenfotec.examen2.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "productores")
public class Productor {
	@Id
	private long cedula;

	@NotNull
	@Column(name = "nombre_productor")
	private String nombreProductor;

	@NotNull
	@Column(name = "nombre_empresa")
	private String nombreEmpresa;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "direccion_id")
	private Direccion direccion;

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@OneToMany(mappedBy = "productor", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<Finca> fincas = new ArrayList<Finca>();

	

	public Productor() {

	}

	public Productor(long cedula, String nombreCompleto, String direccion, String provincia, String nombreEmpresa) {
		this.cedula = cedula;
		this.nombreProductor = nombreCompleto;
		this.nombreEmpresa = nombreEmpresa;

	}
	public List<Finca> getFincas() {
		return fincas;
	}

	public void setFincas(List<Finca> fincas) {
		this.fincas = fincas;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getNombreProductor() {
		return nombreProductor;
	}

	public void setNombreProductor(String nombreProductor) {
		this.nombreProductor = nombreProductor;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

}
