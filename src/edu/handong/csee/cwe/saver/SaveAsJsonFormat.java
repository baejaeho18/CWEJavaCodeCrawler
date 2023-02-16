package edu.handong.csee.cwe.saver;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import edu.handong.csee.cwe.value.CWE;
import edu.handong.csee.cwe.value.JsonFormat;

public class SaveAsJsonFormat {
	
//	@SuppressWarnings("unchecked")
//	public static JSONArray saveCWEAsJson(ArrayList<CWE> cweList) {
//		
//		JSONArray cweJson = new JSONArray();
//		for(CWE cwe : cweList) {
//			JSONObject obj = new JSONObject();
//			
//			obj.put("id", cwe.getId());	
//			obj.put("name", cwe.getName());
//			obj.put("description", cwe.getDescription());
//			obj.put("exampleCode", cwe.getExampleCode());
//			obj.put("exampleDescription", cwe.getExampleDescription());
//			obj.put("cveList", cwe.getCveList());
//			
//			cweJson.add(obj);
//		}
//		return cweJson;
//	}

	public static JsonFormat saveAsJson(ArrayList<CWE> cweList) {

		JsonFormat jsonFormat = new JsonFormat();
		jsonFormat.setCweInfo(saveCWEInfoAsJson(cweList));
		jsonFormat.setCweCode(saveCWECodeAsJson(cweList));
		jsonFormat.setCweCVE(saveCWECVEAsJson(cweList));
		
		return jsonFormat;
	}
	
	@SuppressWarnings("unchecked")
	public static JSONArray saveCWEInfoAsJson(ArrayList<CWE> cweList) {
		
		JSONArray cweInfoJson = new JSONArray();
		for(CWE cwe : cweList) {
			JSONObject obj = new JSONObject();
			
			obj.put("id", cwe.getId());	
			obj.put("name", cwe.getName());
			obj.put("description", cwe.getDescription());
			obj.put("exampleDescription", cwe.getExampleDescription());
			obj.put("cveList", cwe.getCveList());
			
			cweInfoJson.add(obj);
		}
		return cweInfoJson;
	}
	@SuppressWarnings("unchecked")
	public static JSONArray saveCWECodeAsJson(ArrayList<CWE> cweList) {
		
		JSONArray cweCodeJson = new JSONArray();
		for(CWE cwe : cweList) {
			for(String code : cwe.getExampleCode()) {
				JSONObject obj = new JSONObject();
				obj.put("id", cwe.getId());	
				obj.put("exampleCode", code);
				cweCodeJson.add(obj);
			}
		}
		return cweCodeJson;
	}
	@SuppressWarnings("unchecked")
	public static JSONArray saveCWECVEAsJson(ArrayList<CWE> cweList) {
		
		JSONArray cweCVEJson = new JSONArray();
		for(CWE cwe : cweList) {
			for(String cve : cwe.getCveList()) {
				JSONObject obj = new JSONObject();
				obj.put("id", cwe.getId());	
				obj.put("cveId", cve);
				cweCVEJson.add(obj);
			}
		}		
		return cweCVEJson;
	}
}
