package com.birbalv2.utils;


import junit.framework.Assert;

import org.junit.Test;

public class NetworkUtilsTest {
	
	
	@Test
	public void testSuccessfullConnection() throws Exception {
		String content = NetworkUtils.responseContent("https://ask.pannous.com/api?input=India&timeZone=330");
		Assert.assertTrue(content.contains("India is a giant country in southern Asia."));
	}
	
}
