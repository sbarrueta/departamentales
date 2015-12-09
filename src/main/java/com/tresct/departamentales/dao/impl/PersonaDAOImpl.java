package com.tresct.departamentales.dao.impl;

import org.hibernate.Session;

import com.tresct.departamentales.dao.PersonaDAO;
import com.tresct.departamentales.hibernate.HibernateUtil;
import com.tresct.departamentales.hibernate.entities.Persona;

public class PersonaDAOImpl implements PersonaDAO {

	private Persona persona;
	
	public PersonaDAOImpl() {
	}
	public PersonaDAOImpl(Persona persona) {
		
		this.persona = persona;
	}
	public Persona damePersona(Integer id) {
		Session session = HibernateUtil
				.getSessionfactory()
				.openSession();
		if (session != null){
			Persona persona =  (Persona)session.get(Persona.class, id);
			return persona;
			
		}
		System.out.println("No se establecion la conexion");
		return null;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
