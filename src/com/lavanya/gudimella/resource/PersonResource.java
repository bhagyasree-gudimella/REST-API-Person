package com.lavanya.gudimella.resource;

import java.sql.SQLException;  
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.lavanya.gudimella.dto.PersonResponse;
import com.lavanya.gudimella.service.PersonService;
import com.lavanya.gudimella.vo.Person;

@Path("/person")
public class PersonResource {
	
	@GET
	@Path("/sayHello")
	@Consumes({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
	public String sayHello() {
		return "Hello Jersey REST";
	}
	
	@POST
	@Path("/addPerson")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public PersonResponse addPerson(Person person) throws SQLException {
		PersonResponse personResponse = new PersonResponse();
		PersonService personService = new PersonService();
		personService.addPerson(person);
		personResponse.setResponse("Person has been added successfully");
		personResponse.setPerson(person);
		return personResponse;
	}
	
	@GET
	@Path("/persons")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Person> getAllPersons() {
		System.out.println("here");
		PersonService personService = new PersonService();
		return personService.getAllPersons();
	}
	
	@GET
	@Path("/{person_id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public PersonResponse getPerson(@PathParam("person_id") String person_id) throws SQLException  {
		PersonResponse personResponse = new PersonResponse();
		PersonService personService = new PersonService();
		Person person = personService.getPerson(person_id);
		personResponse.setResponse("Person found");
		personResponse.setPerson(person);
		return personResponse;
	}
	
	@PUT
	@Path("/updatePerson")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updatePerson(Person person) throws SQLException {
		PersonService personService = new PersonService();
		personService.updatePerson(person);
	}
	
	@DELETE
	@Path("/deletePerson")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void deletePerson(Person person) throws SQLException {
		PersonService personService = new PersonService();
		personService.deletePerson(person);
	}
}
