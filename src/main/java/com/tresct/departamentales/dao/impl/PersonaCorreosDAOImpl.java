package com.tresct.departamentales.dao.impl;

import org.hibernate.Session;

import com.tresct.departamentales.dao.PersonaCorreosDAO;
import com.tresct.departamentales.hibernate.HibernateUtil;
import com.tresct.departamentales.hibernate.entities.PersonaCorreos;

public class PersonaCorreosDAOImpl implements PersonaCorreosDAO {
	private PersonaCorreos personaCorreos;
	public PersonaCorreosDAOImpl() {
	}

	public PersonaCorreosDAOImpl(PersonaCorreos personaCorreos) {
		this.personaCorreos = personaCorreos;
	}

	public PersonaCorreos damePersonaCorreos(Integer id) {
		Session hibernateSession = HibernateUtil
        		.getSessionfactory()
				.openSession();
		personaCorreos = (PersonaCorreos)hibernateSession.get(PersonaCorreos.class, id);
		return personaCorreos;
	}

	public PersonaCorreos getPersonaCorreos() {
		return personaCorreos;
	}

	public void setPersonaCorreos(PersonaCorreos personaCorreos) {
		this.personaCorreos = personaCorreos;
	}

	@Override
	public String toString() {
		return "PersonaCorreosDAOImpl [personaCorreos=" + personaCorreos + "]";
	}

}
