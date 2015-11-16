package com.birbalv2.responder;

import java.util.Map;

import com.birbalv2.model.Answer;

public interface Responder {
	public Answer respond(String input, Map<String,String> context) throws Exception;
}
