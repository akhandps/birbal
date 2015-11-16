package com.birbalv2.helper;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

import com.birbalv2.constant.Intent;
import com.birbalv2.model.WitOutput;
import com.birbalv2.utils.JSONUtils;
import com.birbalv2.utils.NetworkUtils;

public class WitHelper {

	private static String AUTH_TOKEN = "Bearer 7SEU2FQWD474IJJWP75Z5FHUJVXWS2KJ";
	private static String URL = "https://api.wit.ai/message";

	public WitOutput getIntent(String msg) throws Exception {

		URIBuilder uriBuilder = new URIBuilder(URL);
		uriBuilder.addParameter("q", msg);
		System.out.println(uriBuilder.toString());
		
		HttpGet request = new HttpGet(uriBuilder.build());

		request.addHeader("Authorization", AUTH_TOKEN);

		String response = NetworkUtils.responseContent(request);
		String name = JSONUtils.getJSONString(response, "outcomes:intent");
		double confidence = JSONUtils.getJSONDouble(response,
				"outcomes:confidence");

		Intent intent = Intent.getIntentByName(name);
		WitOutput output = new WitOutput();
		output.setIntent(intent);
		output.setConfidence(confidence);

		return output;
	}
}
