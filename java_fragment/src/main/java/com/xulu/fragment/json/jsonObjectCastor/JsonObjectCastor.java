package com.xulu.fragment.json.jsonObjectCastor;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xulu.fragment.bean.jsonObjectCastor.Person;

public class JsonObjectCastor 
{
	public static String castObjectToJson(List<Person> persons)
	{
		Gson gson = new Gson();
		return gson.toJson(persons);
	}
	
	public static List castJsonToObject(String json)
	{
		Gson gson = new Gson();
		List list = gson.fromJson(json, List.class);
		
		//get the actual type
		Type type = new TypeToken<List<Person>>(){}.getType();
		list = gson.fromJson(json, type);
		return list;
	}
}
