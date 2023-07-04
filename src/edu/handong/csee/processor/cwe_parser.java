package edu.handong.csee.processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class cwe_parser {

    public static void main(String[] args) {
    	ArrayList<String> samples = new ArrayList<>();
        HashSet<ArrayList> extractedStrings = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USER\\git\\BKJ_Juliet\\javaList.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                int cweIndex = line.indexOf("CWE");
                if (cweIndex != -1 && cweIndex < line.length() - 1) {
                    String extractedString = line.substring(cweIndex + 3).replaceAll(".java$", "");
                    extractedStrings.add(extractedString);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 추출된 문자열 출력 또는 원하는 작업 수행
        for (String str : extractedStrings) {
            System.out.println(str);
        }
    }
}