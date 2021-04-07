package com.personal.core.test;

import java.util.Hashtable;

import org.junit.jupiter.api.BeforeEach;

import com.personal.core.models.Person;

public class BasePersonTest {
	protected Hashtable<Integer, Person> personHashtable;
	
	@BeforeEach
	public void init() {
		personHashtable = new Hashtable<Integer, Person>();
		
		var person1 = new Person(1, "Adam", "Citizen");
		personHashtable.put(person1.getId(), person1);
		
		var person2 = new Person(2, "Ronald", "McDonald");
		personHashtable.put(person2.getId(), person2);
		
		var person3 = new Person(3, "Jane", "Doe");
		personHashtable.put(person3.getId(), person3);
		
		var person4 = new Person(4, "Greg", "Greg");
		personHashtable.put(person4.getId(), person4);
	}
}