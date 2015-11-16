package com.birbalv2.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.birbalv2.factory.ResponderFactory;
import com.birbalv2.model.Answer;
import com.birbalv2.model.Output;
import com.birbalv2.responder.Responder;

@Path("/talk")
public class Controller {

	private static ExecutorService executorService = Executors
			.newFixedThreadPool(2);

	@GET
	@Path("/{param}")
	@Produces("application/json")
	public Output talk(@PathParam("param") String msg) {
		Output out = new Output();
		try {
			out = decideOutput(executeResponders(msg));
		} catch (Exception e) {
			out.setValue(e.getMessage());
			e.printStackTrace();
		}
		return out;
	}

	private List<Future<Answer>> executeResponders(final String msg)
			throws Exception {
		Set<Callable<Answer>> callables = new HashSet<Callable<Answer>>();
		List<Responder> responders = ResponderFactory.getAllResponder();

		for (final Responder responder : responders) {
			callables.add(new Callable<Answer>() {
				@Override
				public Answer call() throws Exception {
					return responder.respond(msg, null);
				}
			});
		}

		List<Future<Answer>> futures = executorService.invokeAll(callables);
		return futures;
	}

	private Output decideOutput(List<Future<Answer>> futureAnswers)
			throws Exception {
		Output out = new Output();
		for (Future<Answer> futureAnswer : futureAnswers) {
			Answer answer = futureAnswer.get();
			if (answer != null && answer.getConfidence() > out.getConfidence()) {
				out.setValue(answer.getOutputText());
				out.setConfidence(answer.getConfidence());
			}
		}

		return out;
	}

}