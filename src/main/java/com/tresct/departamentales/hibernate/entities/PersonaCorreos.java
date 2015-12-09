package com.tresct.departamentales.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="personacorreos")
public class PersonaCorreos {

	@Id
	@GeneratedValue
	private Integer id;
	
	// Notacion para evitar referencia circular JSON
	@JsonManagedReference
	
	@ManyToOne
	@JoinColumn(name="idpersona")
	private Persona persona;
	
	@Column(unique=true)
	private String correo;
	
	public PersonaCorreos() {
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
}
