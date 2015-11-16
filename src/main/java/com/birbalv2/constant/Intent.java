package com.birbalv2.constant;

import java.util.HashMap;

import com.birbalv2.intent.executor.BotsNameExecutor;
import com.birbalv2.intent.executor.IntentExecutor;

public enum Intent {
	BOTS_NAME("bots_name", BotsNameExecutor.class);

	private static HashMap<String, Intent> intentMap = new HashMap<String, Intent>();
	static {
		intentMap.put("bots_name", BOTS_NAME);
	}

	private String name;
	private Class<? extends IntentExecutor> executor;

	private Intent(String name, Class<? extends IntentExecutor> executor) {
		this.name = name;
		this.executor = executor;
	}

	public String getName() {
		return name;
	}

	public Class<? extends IntentExecutor> getExecutor() {
		return executor;
	}

	public static Intent getIntentByName(String name) {
		return intentMap.get(name);
	}

}
