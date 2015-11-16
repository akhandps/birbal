package com.birbalv2.nl.generation;

import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.realiser.english.Realiser;

public class NaturalLanguageGenerator {
	private static Lexicon lexicon = Lexicon.getDefaultLexicon();
	private static NLGFactory nlgFactory = new NLGFactory(lexicon);
	private static Realiser realiser = new Realiser(lexicon);

	public static String getSentence(String subject, String verb, String object) {
		SPhraseSpec p = nlgFactory.createClause();
		p.setSubject(subject);
		p.setVerb(verb);
		p.setObject(object);
		

		return realiser.realiseSentence(p);
	}
}
