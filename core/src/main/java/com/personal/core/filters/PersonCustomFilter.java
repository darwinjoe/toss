package com.personal.core.filters;

import java.util.function.Predicate;

import com.personal.core.models.Person;

public class PersonCustomFilter {
	public static Predicate<Person> getFirstNameWithPrefix(String prefix){
		return p -> p.getFirstName() != null && 
				p.getFirstName().toLowerCase().startsWith(prefix.toLowerCase());
	}
	
	public static Predicate<Person> getLastNameWithPrefix(String prefix){
		return p -> p.getLastName() != null && 
				p.getLastName().toLowerCase().startsWith(prefix.toLowerCase());
	}
	
	public static Predicate<Person> getPersonWithEqualFirstNameAndLastName(){
		return p -> p.getFirstName() != null && p.getLastName() != null &&
				p.getFirstName().toLowerCase().equals(p.getLastName().toLowerCase());
	}
}