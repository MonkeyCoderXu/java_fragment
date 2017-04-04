package com.xulu.fragment.json;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
/**
 * 
 * java½âÎöjson
 * @author Administrator
 *
 */
public class HandleJsonByGson {

	void method1()
	{
		JsonParser parser = new JsonParser();
		try {
			JsonObject json = (JsonObject)parser.parse(new FileReader("resource/json/weather.json"));
			int result_code = json.get("result_code").getAsInt();
			String reason = json.get("reason").getAsString();
			JsonObject result = json.get("result").getAsJsonObject();
			JsonObject today = result.get("today").getAsJsonObject();
			String temperature = today.get("temperature").getAsString();
			String weather = today.get("weather").getAsString();
			
			JsonArray array = result.get("feature").getAsJsonArray();
			for(int i=0; i<array.size(); i++)
			{
				JsonObject jsonObject = array.get(i).getAsJsonObject();
				String weather2 = jsonObject.get("weather").getAsString();
				String week = jsonObject.get("week").getAsString();
			}
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
