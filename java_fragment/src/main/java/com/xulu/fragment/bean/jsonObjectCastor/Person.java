package com.xulu.fragment.bean.jsonObjectCastor;

import java.util.LinkedList;
import java.util.List;

public class Person {

	private int id;
	private String name;
	private List<String> hobbies;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	
	public void addHobby(String hobby){
		if(this.hobbies == null)
			this.hobbies =  new LinkedList<String>();
		this.hobbies.add(hobby);
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", hobbies=" + hobbies
				+ "]";
	}
}
