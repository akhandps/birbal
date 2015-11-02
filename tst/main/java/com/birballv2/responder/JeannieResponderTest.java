package com.birballv2.responder;

import org.junit.Assert;
import org.junit.Test;

import com.birbalv2.responder.JeannieResponder;

public class JeannieResponderTest {

	@Test
	public void testBasic() throws Exception {
		String input = "Hello";
		JeannieResponder responder = new JeannieResponder();
		Assert.assertNotNull(responder.respond(input, null));
	}

	@Test
	public void testAdvanced() throws Exception {
		JeannieResponder responder = new JeannieResponder();
		String input1 = "My Name is Akhand";
		Assert.assertNotNull(responder.respond(input1, null));
		String input2 = "What is My name";
		Assert.assertEquals("Akhand", responder.respond(input2, null));
	}
}
