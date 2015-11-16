package com.birbalv2.utils;

import org.junit.Assert;
import org.junit.Test;

public class JSONUtilTest {
	
	@Test
	public void testJSONGet() throws Exception {
		String str = "{ \"name\": {\"firstName\":\"Alice\"}, \"age\": 20 }";
		String out = JSONUtils.getJSONString(str, "name:firstName");
		Assert.assertEquals("Alice", out);
	}
}
