package com.birbalv2.responder;

import java.util.Map;

import com.birbalv2.helper.WitHelper;
import com.birbalv2.intent.executor.IntentExecutor;
import com.birbalv2.model.Answer;
import com.birbalv2.model.WitOutput;

public class WitResponder implements Responder {

	WitHelper witHelper = new WitHelper();

	@Override
	public Answer respond(String input, Map<String, String> context)
			throws Exception {
		WitOutput witOutput = witHelper.getIntent(input);
		Answer answer = null;

		if (witOutput.getIntent() != null) {
			IntentExecutor executor = witOutput.getIntent().getExecutor()
					.newInstance();

			executor.execute(null);

			if (witOutput.getConfidence() >= 0.5) {
				answer = executor.getAnswer();
				answer.setConfidence(2);
			}
		}
		return answer;
	}

}
