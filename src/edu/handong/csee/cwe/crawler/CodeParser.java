package edu.handong.csee.cwe.crawler;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CodeParser {
	public static String parser(String html) {
		
		String badCode = "";
		
//		System.out.println(html);
		badCode = html.replace("<br>", "\n");
		badCode = badCode.replaceAll("<[^<>]*>", "");
		badCode = badCode.replace("&lt;","<");
		badCode = badCode.replace("&gt;",">");
		badCode = badCode.replace("&nbsp;","");

		badCode = badCode.replace("\n", "");
//		badCode = badCode.replace("{", "{\n");
//		badCode = badCode.replace("}", "}\n");
//		badCode = badCode.replace(";", ";\n");
//		badCode = badCode.replace("...", "...\n");
//		badCode = badCode.replace("*/", "*/n");

//		badCode = badCode.replace("<", "\n<");
//		badCode = badCode.replace(">", ">\n");
//		badCode = badCode.replace("  ", " ");
		// html = html.replace("\n\n", "\n");
		
		System.out.println("badCode: "+badCode);
		
		return badCode;
	}
	
	public static String parser(Element html) {
		
		Elements header = html.getElementsByAttributeValue("class", "CodeHead");
		Boolean isJava = header.text().contains("Java");
		
		if(isJava) {
			Elements contents = html.getElementsByAttributeValue("class", "top");
			return parser(contents.html());
		}
		System.out.println("Not java code");
		return null;
	}
}
