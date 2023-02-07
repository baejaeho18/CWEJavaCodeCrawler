package edu.handong.csee.cwe.value;

import java.util.ArrayList;

public class CWE {
	public String id;
	public String name;
	public String description;
	
	public String platformLanguage;
//	public ArrayList<Integer> childOf = new ArrayList<Integer>();
//	public ArrayList<Integer> parentOf = new ArrayList<Integer>();
//	public ArrayList<Integer> memberOf = new ArrayList<Integer>();
	public ArrayList<String> cveList = new ArrayList<String>();
	
	public ArrayList<String> exampleCode = new ArrayList<String>();
	public String exampleDescription;
	
	public CWE(String id, String name, String description, String platformLanguage,
			ArrayList<String> exampleCode, String exampleDescription, ArrayList<String> cveList) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.platformLanguage = platformLanguage;
//		this.childOf = childOf;
//		this.parentOf = parentOf;
//		this.memberOf = memberOf;
		this.exampleCode = exampleCode;
		this.exampleDescription = exampleDescription;
		this.cveList = cveList;
	}

	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getPlatformLanguage() {
		return platformLanguage;
	}
//	public ArrayList<Integer> getChildOf() {
//		return childOf;
//	}
//	public ArrayList<Integer> getParentOf() {
//		return parentOf;
//	}
//	public ArrayList<Integer> getMemberOf() {
//		return memberOf;
//	}
	public ArrayList<String> getExampleCode() {
		return exampleCode;
	}
	public String getExampleDescription() {
		return exampleDescription;
	}

	public ArrayList<String> getCveList() {
		return cveList;
	}
	
}
