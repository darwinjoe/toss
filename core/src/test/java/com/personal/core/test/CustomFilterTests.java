package com.personal.core.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import com.personal.core.filters.PersonCustomFilter;
import com.personal.core.mappers.PersonCustomMapper;

public class CustomFilterTests extends BasePersonTest{
	public void printEveryone() {
		for(var entry : personHashtable.entrySet()) {
			System.out.println(String.format("%s %s", entry.getKey(), entry.getValue().toString()));
		}
	}
	
	@Test
	public void canRetrieveOnCustomFilterPrefix() {
		var personWithFirstNamePrefix = personHashtable.entrySet().stream()
			.map(entry -> entry.getValue())
			.filter(PersonCustomFilter.getFirstNameWithPrefix("a"))
			.findFirst().orElse(null);
		
		assertThat(personWithFirstNamePrefix, not(nullValue()));
		assertThat(personWithFirstNamePrefix.getFirstName(), is("Adam"));
	}
	
	@Test
	public void canRetrieveOnCustomFilterEquals() {
		var personWithEqualFirstAndLastName = personHashtable.entrySet().stream()
			.map(entry -> entry.getValue())
			.filter(PersonCustomFilter.getPersonWithEqualFirstNameAndLastName())
			.findFirst().orElse(null);
		
		assertThat(personWithEqualFirstAndLastName, not(nullValue()));
		assertThat(personWithEqualFirstAndLastName.getFirstName(), is("Greg"));
	}
	
	@Test
	public void canGetDetailsOnCustomMapper() {
		personHashtable.entrySet().stream()
			.map(entry -> entry.getValue())
			.map(PersonCustomMapper.mapToString())
			.forEach(System.out::println);
	}
}