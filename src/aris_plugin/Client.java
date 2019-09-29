package aris_plugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {
	public static void main(String[] args) throws IOException {
        System.out.println("ARIS plugin");
        URL url = new URL ("http://indieteam.online/api/v1/instructions");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        String jsonInputString = "{      \"name\": \"Инструкция по сбору X баннера\",\n" + 
        		"      \"details\": [\n" + 
        		"        {\n" + 
        		"          \"count\": 2,\n" + 
        		"          \"name\": \"Пластиковая ножка с держателем ролла\",\n" + 
        		"          \"shortName\": \"A\",\n" + 
        		"          \"link\": \"http://teamcenter.indieteam.ru/1.zip\"\n" + 
        		"        }\n" + 
        		"      ],\n" + 
        		"      \"steps\": [\n" + 
        		"        {\n" + 
        		"          \"description\": \"Взять деталь A\"\n" + 
        		"        }\n" + 
        		"      ]}";
        try(OutputStream os = (OutputStream) con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);           
        }
        try(BufferedReader br = new BufferedReader(
        		  new InputStreamReader(con.getInputStream(), "utf-8"))) {
        		    StringBuilder response = new StringBuilder();
        		    String responseLine = null;
        		    while ((responseLine = br.readLine()) != null) {
        		        response.append(responseLine.trim());
        		    }
        		    System.out.println(response.toString());
        		}
        
    }
}
