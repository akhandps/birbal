package com.birbalv2.utils;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONUtils {

	public static String getJSONString(String jsonString, String key)
			throws Exception {
		JSONObject jsonObject = new JSONObject(jsonString);
		String keys[] = key.split(":");
		JSONObject currObject = getLastObjectInPath(jsonObject, keys);
		
		return currObject.getString(keys[keys.length - 1]);
	}

	public static int getJSONInteger(String jsonString, String key)
			throws Exception {
		JSONObject jsonObject = new JSONObject(jsonString);
		String keys[] = key.split(":");
		JSONObject currObject = getLastObjectInPath(jsonObject, keys);

		return currObject.getInt(keys[keys.length - 1]);
	}
	
	public static double getJSONDouble(String jsonString, String key)
			throws Exception {
		JSONObject jsonObject = new JSONObject(jsonString);
		String keys[] = key.split(":");
		JSONObject currObject = getLastObjectInPath(jsonObject, keys);

		return currObject.getDouble(keys[keys.length - 1]);
	}

	private static JSONObject getLastObjectInPath(JSONObject jsonObject,
			String[] keys) {
		JSONObject currObject = jsonObject;

		for (int i = 0; i < keys.length - 1; i++) {
			if (currObject.get(keys[i]) instanceof JSONArray) {
				currObject = currObject.getJSONArray(keys[i]).getJSONObject(0);
			} else {
				currObject = currObject.getJSONObject(keys[i]);
			}
		}

		return currObject;
	}
}
