package com.birbalv2.intent.executor;

import com.birbalv2.model.Answer;

public class BotsNameExecutor implements IntentExecutor {

	@Override
	public void execute(String[] entities) {
		// No-Op for now.

	}

	@Override
	public Answer getAnswer() {
		Answer answer = new Answer();
		answer.setOutputText("I am Birbal");
		return answer;
	}

}
