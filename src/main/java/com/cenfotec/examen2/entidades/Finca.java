 package com.cenfotec.examen2.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "fincas")
public class Finca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String nombre;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "productor_id")
	private Productor productor;

	

	@NotNull
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "fincas_x_tipos_cafes", joinColumns = { @JoinColumn(name = "finca_id") }, inverseJoinColumns = {
			@JoinColumn(name = "tipo_cafe_id") })
	private List<Cafe> tiposCafe = new ArrayList<Cafe>();

	public Finca() {

	}

	public Finca(String nombreFinca) {
		this.nombre = nombreFinca;
	}
	public Productor getProductor() {
		return productor;
	}

	public void setProductor(Productor productor) {
		this.productor = productor;
	}

	public List<Cafe> getTiposCafe() {
		return tiposCafe;
	}

	public void setTiposCafe(List<Cafe> tiposCafe) {
		this.tiposCafe = tiposCafe;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
