package edu.handong.csee.cwe;

import java.io.IOException;
import java.util.ArrayList;

import edu.handong.csee.cwe.crawler.Crawler;
import edu.handong.csee.cwe.saver.SaveAsFile;
import edu.handong.csee.cwe.saver.SaveAsJsonFormat;
import edu.handong.csee.cwe.value.CWE;
import edu.handong.csee.cwe.value.JsonFormat;

public class Main {

	public static void main(String[] args) throws IOException {
		
		ArrayList<CWE> cwes = new ArrayList<CWE>();
		
		// crawling
		String url = "https://cwe.mitre.org/data/definitions/";
		cwes = Crawler.crawler(url+"699.html");
		cwes.addAll(Crawler.crawler(url+"1194.html"));
		cwes.addAll(Crawler.crawler(url+"1000.html"));
		
		// connect to CWE homepage // only for java
		String cweByJavaLink = "https://cwe.mitre.org/data/definitions/660.html";
	
		JsonFormat jsonFormat = SaveAsJsonFormat.saveAsJson(cwes);
		SaveAsFile.saveFileAsJson(jsonFormat.getCweInfo(), "cweInfo.json");
		SaveAsFile.saveFileAsJson(jsonFormat.getCweCode(), "cweCode.json");
		SaveAsFile.saveFileAsJson(jsonFormat.getCweCVE(), "cweCVE.json");
		
		SaveAsFile.saveFileAsWorkSheet();
	}

}