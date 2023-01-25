package crawler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cwe.CWE;

public class Crawler {

	public static void main(String[] args) throws IOException {
		
		ArrayList<CWE> cwes = new ArrayList<CWE>();
		Element a;
		
		// connect to CWE homepage
		String cweByJavaLink = "https://cwe.mitre.org/data/definitions/660.html";
		Document doc = Jsoup.connect(cweByJavaLink).get();
		
		// get each cwe links
		Elements cweByJavaList = doc.getElementsByAttributeValueContaining("href", "/data/definitions/");
		for(Element cweByJava : cweByJavaList) {
			// get cwe info by link
			cwes.add(GetCWE.getCWE(cweByJava.attr("href")));
		}
		
		// save cwe info as json format
		JSONArray cweJson = SaveCWE.saveCWEAsJson(cwes);
	//	String json = SaveCWE.saveCWEASJson(cwes);
		
		// write json format to file
		try {
			FileWriter file = new FileWriter("./cwe.json");
			file.write(cweJson.toJSONString());
		//	file.write(json);
			file.flush();
			file.close();
		} catch (IOException e) {
			System.out.println("File Error");
		}

	}

}