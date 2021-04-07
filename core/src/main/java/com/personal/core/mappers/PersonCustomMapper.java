package com.personal.core.mappers;

import java.util.function.Function;

import com.personal.core.models.Person;

public class PersonCustomMapper {
	public static Function<Person, String> mapToString(){
		return p -> String.format("The person with id %s is %s", p.getId(), p.toString());
	}
}