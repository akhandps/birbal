package com.birbalv2.nl.generation;

import junit.framework.Assert;

import org.junit.Test;

public class NaturalLanguageGeneratorTest {

	@Test
	public void testSimpleGeneration() {
		String out = NaturalLanguageGenerator.getSentence("Mary", "chase", "the monkey");
		Assert.assertEquals("Mary chases the monkey.", out);
	}
	
	@Test
	public void testBotName() {
		String out = NaturalLanguageGenerator.getSentence("My name", "is", "Birbal");
		Assert.assertEquals("My name is Birbal.", out);
	}
}
