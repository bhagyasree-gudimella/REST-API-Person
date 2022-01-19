package com.lavanya.gudimella.client;

import java.sql.SQLException; 

import com.lavanya.gudimella.resource.PersonResource;

public class PersonClient {
	public static void main(String[] args) throws SQLException {
	
		PersonResource personResource = new PersonResource();
		System.out.println(personResource.getAllPersons());
	}
}
