package edu.handong.csee.cwe.saver;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;


public class SaveAsFile {
	
// 	static String cweInfo = "./cweInfo.csv";
//	static String cweCode = "./cweCode.csv";

	public static void saveFileAsWorkSheet() {

	}
	
	public static void saveFileAsJson(JSONArray json, String fileName) {
		try {
			FileWriter file = new FileWriter(fileName);
			file.write(json.toJSONString());
			file.flush();
			file.close();
		} catch (IOException e) {
			System.out.println("File Error");
		}
	}
//	public static void saveAsCSV(ArrayList<CWE> cweList) {
//		
//		try {
//			FileOutputStream infoFOS = new FileOutputStream(cweInfo);
//			OutputStreamWriter infoOSW = new OutputStreamWriter(infoFOS, "EUC-KR");
//			BufferedWriter infoWriter = new BufferedWriter(infoOSW);
//
//			FileOutputStream codeFOS = new FileOutputStream(cweCode);
//			OutputStreamWriter codeOSW = new OutputStreamWriter(codeFOS, "EUC-KR");
//			BufferedWriter codeWriter = new BufferedWriter(codeOSW);
//			
//			for(CWE cwe : cweList) {				
//				infoWriter.write(cwe.getId()+"\t"+cwe.getName()+"\t"+cwe.getPlatformLanguage()+"\t"+cwe.getDescription()+"\t"+cwe.getCveList().toString());
//				infoWriter.newLine();
//				
//				for(String code : cwe.getExampleCode()) {
//					codeWriter.write(cwe.getId()+"\t"+code);
//					codeWriter.newLine();
//				}
//			}
//			infoWriter.flush();
//			infoWriter.close();
//			codeWriter.flush();
//			codeWriter.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
}
