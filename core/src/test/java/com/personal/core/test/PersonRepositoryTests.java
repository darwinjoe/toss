package com.personal.core.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.personal.core.models.Person;
import com.personal.core.repositories.PersonRepository;

public class PersonRepositoryTests {
	private PersonRepository repository;
	
	@BeforeEach
	public void init() {
		repository = new PersonRepository();
	}
	
	@Test
	public void canAddPerson() throws Exception {
		var person = new Person();
		person.setFirstName("John");
		person.setLastName("Smith");
		
		var savedPerson = repository.addUpdate(person);
		
		assertThat(savedPerson, not(nullValue()));
		assertThat(savedPerson.getFirstName(), is("John"));
		assertThat(savedPerson.getLastName(), is("Smith"));
		assertThat(savedPerson.getId(), is(1));
	}
	
	@Test
	public void canAddMultiplePersons() throws Exception {
		var person1 = new Person();
		person1.setFirstName("John");
		person1.setLastName("Smith");
		
		var savedPerson1 = repository.addUpdate(person1);
		
		assertThat(savedPerson1, not(nullValue()));
		assertThat(savedPerson1.getFirstName(), is("John"));
		assertThat(savedPerson1.getLastName(), is("Smith"));
		assertThat(savedPerson1.getId(), is(1));
		
		var person2 = new Person();
		person2.setFirstName("Ronald");
		person2.setLastName("Brown");
		
		var savedPerson2 = repository.addUpdate(person2);
		
		assertThat(savedPerson2, not(nullValue()));
		assertThat(savedPerson2.getFirstName(), is("Ronald"));
		assertThat(savedPerson2.getLastName(), is("Brown"));
		assertThat(savedPerson2.getId(), is(2));
		
		var allRecords = this.repository.getAll();
		
		assertThat(allRecords, not(nullValue()));
		assertThat(allRecords.size(), is(2));
	}
	
	@Test
	public void canUpdateExistingPerson() throws Exception {
		var person = new Person();
		person.setFirstName("John");
		person.setLastName("Smith");
		
		var savedPerson = repository.addUpdate(person);
		
		assertThat(savedPerson, not(nullValue()));
		assertThat(savedPerson.getFirstName(), is("John"));
		assertThat(savedPerson.getLastName(), is("Smith"));
		assertThat(savedPerson.getId(), is(1));
		
		savedPerson.setFirstName("Rony");
		
		var updatedPerson = repository.addUpdate(savedPerson);
		
		assertThat(updatedPerson, not(nullValue()));
		assertThat(updatedPerson.getFirstName(), is("John"));
		assertThat(updatedPerson.getLastName(), is("Smith"));
		assertThat(updatedPerson.getId(), is(1));
	}
}