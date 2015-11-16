package com.birbalv2.intent.executor;

import com.birbalv2.model.Answer;

public interface IntentExecutor {

	public void execute(String entities[]);
	public Answer getAnswer();
}
