package com.birbalv2.responder;

import java.util.Map;

import com.birbalv2.helper.JeannieHelper;
import com.birbalv2.model.Answer;
import com.birbalv2.utils.JSONUtils;

public class JeannieResponder implements Responder {

	JeannieHelper helper = new JeannieHelper();

	@Override
	public Answer respond(String input, Map<String, String> context)
			throws Exception {

		String output = helper.getAnswer(input);
		String answerText = JSONUtils.getJSONString(output,
				"output:actions:say:text");
		double answerConfidence = 1;
		Answer answer = new Answer();
		answer.setOutputText(answerText);
		answer.setConfidence(answerConfidence);

		return answer;
	}

}
