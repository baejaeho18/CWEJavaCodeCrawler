package edu.handong.csee.cwe.crawler;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.handong.csee.cwe.value.CWE;

public class CWEInfoCrawler {
	
	public static CWE getCWE(String cweLink) throws IOException {
		// connect to each cwe info page
		Document doc = Jsoup.connect("https://cwe.mitre.org" + cweLink).get();
	//	System.out.println(doc);
	
		// id, name
		String id = "";
		String name = "";
		String idName = "";
		try{
			idName = doc.getElementsByAttributeValue("style", "overflow:auto;").text().split("CWE-")[1];
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Group link");
			return null;
		}
		System.out.println(idName);
		id = idName.substring(0, idName.indexOf(":"));
		name = idName.substring(idName.indexOf(":")+2);
		// id = idName.split(": ")[0];
		// name = idName.split(": ")[1];
//		System.out.println(id + " " + name);
		
	//	processor.getIDName(doc);
		
		// description
		String descript = "";
		descript = doc.getElementsByAttributeValue("name", "oc_" + id + "_Description").text();
		//extend description
		try {
			descript += " " + doc.getElementsByAttributeValue("name", "oc_"+id+"_Extended_Description").text();
//			System.out.println(descript);
		} catch (Exception e) {
			System.out.println(id+" : No extend_descript");
		}
	
		// applicable platform language
		String platformLanguage = "";
		try {
			String languages = doc.getElementById("oc_"+id+"_Applicable_Platforms").text();
			if(languages.contains("Not Language-Specific"))
				platformLanguage = "Not Language-Specific";
			else if(languages.contains("Java"))
				platformLanguage = "Java";
			else {
				System.out.println("No applicable language for java");
				return null;
			}
		} catch(NullPointerException e) {
			System.out.println("No applicable language");
		}
		System.out.println(platformLanguage);
		
		// examples
		ArrayList<String> exampleCode = new ArrayList<String>();
		String description = "";
		try {
			Element example = doc.getElementById("oc_"+id+"_Demonstrative_Examples");
			// description
			Elements ps = example.select("p");
			for(Element p : ps) {
				description += p.text() + "\n";
			}
			// bad code
			Elements badCodes = example.getElementsByAttributeValue("class", "indent Bad");
			for(Element bc : badCodes) {
				// null	is contained so that could see all cweIds in cweCode file.
				// exampleCode.add(CodeParser.parser(bc));	
				String badCode = CodeParser.parser(bc);
				if(badCode != null)
					exampleCode.add(badCode);
			}
		} catch(NullPointerException e) {
			System.out.println("No example");
		} 
//		System.out.println(description);
		
		// CVE-id
		ArrayList<String> cvelist = new ArrayList<String>();
		String cveIds = "";
		try {
			Element cveInfo = doc.getElementById("oc_"+id+"_Observed_Examples");
			Elements cves = cveInfo.getElementsByAttributeValue("valign", "top");
			for(Element cve : cves) {
				String cveText = cve.text();
				if(cveText.contains("CVE")) {
					cveIds = cveIds + cveText + ", ";
					cvelist.add(cveText);
				}
			}
		} catch(NullPointerException e) {
			System.out.println("No CVE Id");
		}
		return new CWE(id, name, descript, platformLanguage, exampleCode, description, cvelist);
	}
}
