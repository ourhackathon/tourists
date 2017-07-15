package com.cts.hackathon.tourist.model;


public class Attraction {

	private String speech;
	private String displayText;

	public Attraction() {}
	
	public Attraction(String speech, String displayText){
		this.speech = speech;
		this.displayText = displayText;
		
	}

	public String getSpeech() {
		return speech;
	}

	public void setSpeech(String speech) {
		this.speech = speech;
	}

	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

}
