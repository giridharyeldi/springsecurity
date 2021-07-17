package com.example.demo.utility;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class ObjectConverter {
	
	public String objToJson(Object obj){
		Gson gson = new Gson();
		String strJson = gson.toJson(obj);
		return strJson;
	}

}
