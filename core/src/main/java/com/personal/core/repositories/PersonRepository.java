package com.personal.core.repositories;

import java.util.ArrayList;
import java.util.List;

import com.personal.core.models.Person;

public class PersonRepository {
	private List<Person> data;
	private int lastId;
	
	public PersonRepository() {
		data = new ArrayList<>();
		lastId = 0;
	}
	
	public Person addUpdate(Person person) throws Exception {
		if (person.getId() == 0) {
			person.setId(getAndIncrementLastId());
		}
		else {
			var existingPerson = getById(person.getId());
			
			if (existingPerson != null) {
				data.remove(existingPerson);
			}
			else {
				throw new Exception("Unable to find person with id " + person.getId());
			}
		}
		
		data.add(person);
		
		return person;
	}
	
	public void remove(int id) {
		var existingPerson = getById(id);
		
		if (existingPerson != null) {
			data.remove(existingPerson.getId());
		}
	}
	
	private int getAndIncrementLastId() {
		lastId++;
		return lastId;
	}
	
	public List<Person> getAll(){
		return this.data;
	}
	
	public Person getById(int id) {
		return data.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
	}
}