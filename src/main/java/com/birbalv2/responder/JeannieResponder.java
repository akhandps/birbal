package com.birbalv2.responder;

import java.util.Map;

import org.apache.commons.httpclient.HttpsURL;

import com.birbalv2.utils.JSONUtils;
import com.birbalv2.utils.NetworkUtils;


public class JeannieResponder implements Responder {

	private static final String API_URI = "https://ask.pannous.com/api";
	@Override
	public String respond(String input, Map<String, String> context) throws Exception {
		HttpsURL httpsURL = new HttpsURL(API_URI);
		String key [] = {"input","timeZone","locale","id","clientFeatures"};
		String values[] = {input,"330","en_US","akhandpratap0503@gmail.com","say"};
		httpsURL.setQuery(key, values);
		System.out.println(httpsURL.toString());
		String output = NetworkUtils.responseContent(httpsURL.toString());
		return JSONUtils.getJSONObject(output, "output:actions:say:text");
	}

}
