package com.xulu.fragment.json.jsonObjectCastor;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.xulu.fragment.bean.jsonObjectCastor.Person;

public class JsonObjectCastorTest {

	@Test
	public void testCastObjectToJson() {
		Person person1 = new Person();
			person1.setId(001);
			person1.setName("abc");
			person1.addHobby("running");
			person1.addHobby("boxing");
		Person person2 = new Person();
			person2.setId(002);
			person2.setName("abd");
			person2.addHobby("yoga");
			person2.addHobby("kufu");
		List<Person> persons = new LinkedList<Person>();
		persons.add(person1);
		persons.add(person2);
		String result = JsonObjectCastor.castObjectToJson(persons);
		System.out.println(result);
	}

	@Test
	public void testCastJsonToObject() {
		String json = "[{\"id\":1,\"name\":\"abc\",\"hobbies\":[\"running\",\"boxing\"]},{\"id\":2,\"name\":\"abd\",\"hobbies\":[\"eating\",\"boxing\"]}]";
		List list = JsonObjectCastor.castJsonToObject(json);
		System.out.println(list.get(0).getClass());
	}

}
