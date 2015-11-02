package com.birbalv2.utils;

import org.junit.Assert;
import org.junit.Test;

public class JSONUtilTest {
	
	@Test
	public void testJSONGet() {
		String str = "{ \"name\": {\"firstName\":\"Alice\"}, \"age\": 20 }";
		String out = JSONUtils.getJSONObject(str, "name:firstName");
		Assert.assertEquals("Alice", out);
	}
}
