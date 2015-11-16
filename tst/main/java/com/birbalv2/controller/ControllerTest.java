package com.birbalv2.controller;

import junit.framework.Assert;

import org.junit.Test;

import com.birbalv2.model.Output;

public class ControllerTest {

	Controller controller = new Controller();

	@Test
	public void testControllerWit() {
		Output out = controller.talk("Who are you");
		Assert.assertEquals(out.getValue(), "I am Birbal");
	}

	@Test
	public void testControllerPannous() {
		Output out = controller.talk("Who is Mahatma Gandhi");
		Assert.assertTrue(out.getValue().contains("Mohandas Karamchand Gandhi"));
	}
}
