package com.birbalv2.responder;

import java.util.Map;

public interface Responder {
	public String respond(String input, Map<String,String> context) throws Exception;
}
