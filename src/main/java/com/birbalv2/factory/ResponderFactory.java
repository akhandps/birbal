package com.birbalv2.factory;

import java.util.Arrays;
import java.util.List;

import com.birbalv2.responder.JeannieResponder;
import com.birbalv2.responder.Responder;
import com.birbalv2.responder.WitResponder;

public class ResponderFactory {
	private static JeannieResponder jeannieResponder = new JeannieResponder();
	private static WitResponder witResponder = new WitResponder();

	public static List<Responder> getAllResponder() {
		Responder[] responders = { jeannieResponder, witResponder };
		return Arrays.asList(responders);
	}
}
