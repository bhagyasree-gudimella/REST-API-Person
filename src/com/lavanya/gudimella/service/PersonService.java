package com.lavanya.gudimella.service;

import java.sql.SQLException;
import java.util.List;

import com.lavanya.gudimella.dao.PersonDao;
import com.lavanya.gudimella.vo.Person;

public class PersonService {
	
	public void addPerson(Person person) throws SQLException {
		PersonDao personDao= new PersonDao();
		personDao.savePerson(person);
	}
	
	public List<Person> getAllPersons() {
		PersonDao personDao= new PersonDao();
		List<Person> personsList = personDao.getAllPersons();
		System.out.println(personsList);
		return personsList;
	}

	public Person getPerson(String person_id) throws SQLException {
		PersonDao personDao= new PersonDao();
		return personDao.getPerson(Integer.parseInt(person_id));
	}

	public void updatePerson(Person person) throws SQLException {
		PersonDao personDao= new PersonDao();
		personDao.updatePerson(person);
	}

	public void deletePerson(Person person) throws SQLException {
		System.out.println("here 1");
		PersonDao personDao= new PersonDao();
		personDao.deletePerson(person);
	}
}
