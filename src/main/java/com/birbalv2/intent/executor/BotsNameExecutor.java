package com.birbalv2.intent.executor;

import com.birbalv2.dal.ConceptDAO;
import com.birbalv2.model.Answer;
import com.birbalv2.model.Concept;
import com.birbalv2.nl.generation.NaturalLanguageGenerator;

public class BotsNameExecutor implements IntentExecutor {

	Answer answer;

	@Override
	public void execute(String[] entities) {
		ConceptDAO conceptDAO = new ConceptDAO();
		Concept concept = conceptDAO.get("selfName");
		String text = NaturalLanguageGenerator.getSentence("My name", "is",
				concept.getConceptValue());
		Answer answer = new Answer();
		answer.setOutputText(text);
	}

	@Override
	public Answer getAnswer() {
		return answer;
	}

}
