package com.jdcasas.mongodb.moneda.app.utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Utility {
	
	private Utility() {
		super();
	}
	
	public static ObjectMapper getObjectMapper() {
		ObjectMapper om = new ObjectMapper();
		om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		om.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
		om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		return om;
	}
	
	public static String objectToJson(Object o) {
		try {
			ObjectMapper om = getObjectMapper();
			om.registerModule(new JavaTimeModule());
			return om.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			return null;
		}
}
	
}
