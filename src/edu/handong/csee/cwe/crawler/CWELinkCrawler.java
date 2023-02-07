package edu.handong.csee.cwe.crawler;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CWELinkCrawler {

	public static ArrayList<String> getCWELinks(String url) throws IOException {
		ArrayList<String> links = new ArrayList<String>();
		
		Document doc = Jsoup.connect(url).get();
//		Elements groups = doc.getElementsByAttributeValue("class", "group");
//		for(Element group : groups) {
//			Elements cweList = group.getElementsByAttributeValueNot("class", "graph_title");
//			for(Element cwe : cweList) {
//				cwe.getElementsByAttributeValueContaining("href", "/data/definitions/");
//				
//			}
//		}
		
		Elements cweLinkList = doc.getElementsByAttributeValueContaining("href", "/data/definitions/");
		for(Element cweLink : cweLinkList) {
			links.add(cweLink.attr("href"));
			
		}
		return links;
	}
	
// 1안. title link 빼고 모든 list link 읽기
// 2안. title에서 각 link 얻어오기	
//	public static ArrayList<String> getlinks(String url) throws IOException{
//		ArrayList<String> links = new ArrayList<String>();
//		
//		Document doc = Jsoup.connect(url).get();
//		Elements cweList = doc.getElementsByAttributeValue("class", "primary key");
//		for(Element cwe : cweList) {
//			// cwe.getElementsByAttributeValue("href", "/data/definitions/");
//			links.add(cwe.attr("href"));
//		}
//		
//		return links;
//	}

}
