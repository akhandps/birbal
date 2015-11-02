package com.birbalv2.utils;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONUtils {

	public static String getJSONObject(String jsonString, String key) throws Exception {
		JSONObject jsonObject = new JSONObject(jsonString);
		JSONObject currObject = jsonObject;
		String keys[] = key.split(":");
		for (int i = 0; i < keys.length - 1; i++) {
			if(currObject.get(keys[i]) instanceof JSONArray) {
				currObject = currObject.getJSONArray(keys[i]).getJSONObject(0);
			} else {
				currObject = currObject.getJSONObject(keys[i]);
			}
		}
		return currObject.getString(keys[keys.length - 1]);
	}
}
