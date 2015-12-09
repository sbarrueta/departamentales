package com.tresct.departamentales.bo.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.tresct.departamentales.bo.PersonaBO;
import com.tresct.departamentales.dao.PersonaDAO;
import com.tresct.departamentales.hibernate.entities.Persona;;
public class PersonaBOImpl implements PersonaBO{
	
	private PersonaDAO personaDAO;
	private Persona persona;
	public String damePersonaJSON(Integer id) {
		Gson gson = new Gson();

		ObjectMapper objectMapper = new ObjectMapper();
		
		persona =personaDAO.damePersona(id);
		if (persona != null){
			System.out.println("<<<<<<<<<<<<<<<<<<<<<< nombre = "+persona.getNombres());
			
			StringBuilder stringBuilder = new StringBuilder("{code:");
			try{

				String cadena = objectMapper.writeValueAsString(persona);
				stringBuilder.append("0,data:");
				stringBuilder.append(cadena);
				stringBuilder.append("}");
			}catch(Exception e){
				System.out.println("<<<<<<<<< EROR al generar el String  : id=  "+persona.getId()+" "+persona.getNombres()+" "+e.getMessage());
				stringBuilder.append("1, message:'"+e.getMessage()+"'}");
			}
			return stringBuilder.toString();
			//return gson.toJson(persona);
		}
		System.out.println("<<<<<<<<<<<<<<<<<<<<<< fue null");
		return "{code:'0',message:'No se encontro persona'}";
	}

	
	
	public Persona getPersona() {
		return persona;
	}



	public void setPersona(Persona persona) {
		this.persona = persona;
	}



	public PersonaDAO getPersonaDAO() {
		return personaDAO;
	}

	public void setPersonaDAO(PersonaDAO personaDAO) {
		this.personaDAO = personaDAO;
	}

}
