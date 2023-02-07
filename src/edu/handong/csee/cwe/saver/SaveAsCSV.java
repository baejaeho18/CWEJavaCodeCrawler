package edu.handong.csee.cwe.saver;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import edu.handong.csee.cwe.value.CWE;

public class SaveAsCSV {
	
	static String cweInfo = "./cweInfo.csv";
	static String cweCode = "./cweCode.csv";
	
	public static void saveAsCSV(ArrayList<CWE> cweList) {
		
		try {
			FileOutputStream infoFOS = new FileOutputStream(cweInfo);
			OutputStreamWriter infoOSW = new OutputStreamWriter(infoFOS, "EUC-KR");
			BufferedWriter infoWriter = new BufferedWriter(infoOSW);

			FileOutputStream codeFOS = new FileOutputStream(cweCode);
			OutputStreamWriter codeOSW = new OutputStreamWriter(codeFOS, "EUC-KR");
			BufferedWriter codeWriter = new BufferedWriter(codeOSW);
			
			for(CWE cwe : cweList) {				
				infoWriter.write(cwe.getId()+","+cwe.getName()+","+cwe.getPlatformLanguage()+","+cwe.getDescription()+","+cwe.getCveList().toString());
				infoWriter.newLine();
				
				for(String code : cwe.getExampleCode()) {
					codeWriter.write(cwe.getId()+","+code);
					codeWriter.newLine();
				}
			}
			infoWriter.flush();
			infoWriter.close();
			codeWriter.flush();
			codeWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
