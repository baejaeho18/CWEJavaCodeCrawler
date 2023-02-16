package edu.handong.csee.cwe.value;

import org.json.simple.JSONArray;

public class JsonFormat {
	JSONArray cweInfo;
	JSONArray cweCode;
	JSONArray cweCVE;
	
	public JSONArray getCweInfo() {
		return cweInfo;
	}
	public void setCweInfo(JSONArray cweInfo) {
		this.cweInfo = cweInfo;
	}
	public JSONArray getCweCode() {
		return cweCode;
	}
	public void setCweCode(JSONArray cweCode) {
		this.cweCode = cweCode;
	}
	public JSONArray getCweCVE() {
		return cweCVE;
	}
	public void setCweCVE(JSONArray cweCVE) {
		this.cweCVE = cweCVE;
	}
	
	
	
}
