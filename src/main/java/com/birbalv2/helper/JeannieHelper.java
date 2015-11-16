package com.birbalv2.helper;

import org.apache.http.client.utils.URIBuilder;

import com.birbalv2.utils.NetworkUtils;

public class JeannieHelper {

	private static final String API_URI = "https://ask.pannous.com/api";

	public String getAnswer(String msg) throws Exception {
		URIBuilder uriBuilder = new URIBuilder(API_URI);
		uriBuilder.addParameter("input", msg);
		uriBuilder.addParameter("timeZone", "330");
		uriBuilder.addParameter("locale", "en_US");
		uriBuilder.addParameter("id", "akhandpratap0503@gmail.com");
		uriBuilder.addParameter("clientFeatures", "say");
		System.out.println(uriBuilder.toString());

		String output = NetworkUtils.responseContent(uriBuilder.build()
				.toString());
		return output;
	}
}
