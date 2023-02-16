package edu.handong.csee.cwe.crawler;

import java.io.IOException;
import java.util.ArrayList;


import edu.handong.csee.cwe.value.CWE;


public class Crawler {

	public static ArrayList<CWE> crawler(String url) throws IOException {
		ArrayList<String> cweLinks = new ArrayList<String>();
		ArrayList<CWE> cwes = new ArrayList<CWE>();
		
		cweLinks = CWELinkCrawler.getCWELinks(url);
		for(String cweLink : cweLinks) {
			CWE cwe = CWEInfoCrawler.getCWE(cweLink);
			if(cwe != null)
				cwes.add(cwe);
		}
		
		return cwes;
	}
	
	
}
