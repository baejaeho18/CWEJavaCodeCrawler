package edu.handong.csee.cwe;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.handong.csee.cwe.crawler.Crawler;
import edu.handong.csee.cwe.saver.SaveAsCSV;
import edu.handong.csee.cwe.saver.SaveAsJson;
import edu.handong.csee.cwe.value.CWE;

public class Main {

	public static void main(String[] args) throws IOException {
		
		ArrayList<CWE> cwes = new ArrayList<CWE>();
		
		// crawling
		String url = "https://cwe.mitre.org/data/definitions/";
		cwes = Crawler.crawler(url+"699.html");
		cwes.addAll(Crawler.crawler(url+"1194.html"));
		cwes.addAll(Crawler.crawler(url+"1000.html"));
		
		// connect to CWE homepage
		String cweByJavaLink = "https://cwe.mitre.org/data/definitions/660.html";
		
		SaveAsCSV.saveAsCSV(cwes);
		
		
//		// save cwe info as json format
//		JSONArray cweJson = SaveAsJson.saveCWEAsJson(cwes);
//	//	String json = SaveCWE.saveCWEASJson(cwes);
//		// write json format to file
//		try {
//			FileWriter file = new FileWriter("./cwe.json");
//			file.write(cweJson.toJSONString());
//		//	file.write(json);
//			file.flush();
//			file.close();
//		} catch (IOException e) {
//			System.out.println("File Error");
//		}

	}

}