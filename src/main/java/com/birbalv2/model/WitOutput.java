package com.birbalv2.model;

import com.birbalv2.constant.Intent;

public class WitOutput {
	private Intent intent;
	private double confidence;
	public Intent getIntent() {
		return intent;
	}
	public void setIntent(Intent intent) {
		this.intent = intent;
	}
	public double getConfidence() {
		return confidence;
	}
	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}
	
	
}
