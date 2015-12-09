package com.tresct.departamentales.hibernate.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="personas")
public class Persona {
	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Persona(Integer id, String nombres, String paterno, String materno, Integer homonimo, String clave,
			Character sexo) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.paterno = paterno;
		this.materno = materno;
		this.homonimo = homonimo;
		this.clave = clave;
		this.sexo = sexo;
	}



	@Id
	@GeneratedValue
	private Integer id;
	private String nombres;
	private String paterno;
	private String materno;
	private Integer homonimo;
	private String clave;
	private Character sexo;
	
	
	
	// Notacion para evitar referencia circular JSON
	@JsonBackReference
	@OneToMany(mappedBy="persona",cascade=CascadeType.ALL)
	private Collection<PersonaCorreos> correos = new ArrayList<PersonaCorreos>();
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public Integer getHomonimo() {
		return homonimo;
	}
	public void setHomonimo(Integer homonimo) {
		this.homonimo = homonimo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Character getSexo() {
		return sexo;
	}
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public Collection<PersonaCorreos> getCorreos() {
		return correos;
	}
	public void setCorreos(Collection<PersonaCorreos> correos) {
		this.correos = correos;
	}
	
	
	
	
}
