package com.birbalv2.responder;

import java.util.Map;

import org.apache.http.client.utils.URIBuilder;

import com.birbalv2.utils.JSONUtils;
import com.birbalv2.utils.NetworkUtils;


public class JeannieResponder implements Responder {

	private static final String API_URI = "https://ask.pannous.com/api";
	@Override
	public String respond(String input, Map<String, String> context) throws Exception {
		URIBuilder uriBuilder = new URIBuilder(API_URI);
		uriBuilder.addParameter("input", input);
		uriBuilder.addParameter("timeZone", "330");
		uriBuilder.addParameter("locale", "en_US");
		uriBuilder.addParameter("id", "akhandpratap0503@gmail.com");
		uriBuilder.addParameter("clientFeatures", "say");


		System.out.println(uriBuilder.toString());
		String output = NetworkUtils.responseContent(uriBuilder.build().toString());
		return JSONUtils.getJSONObject(output, "output:actions:say:text");
	}

}
