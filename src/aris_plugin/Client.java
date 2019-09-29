package aris_plugin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.omg.CORBA.portable.OutputStream;

public class Client {
	public static void main(String[] args) {
        System.out.println("ARIS plugin");
        URL url = new URL ("http://indieteam.online/api/v1/instructions");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        String jsonInputString = "{}";
        try(OutputStream os = (OutputStream) con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);           
        }
        try(BufferedReader br = new BufferedReader(
        		  new InputStreamReader(con.getInputStream(), "utf-8"))) {
        		    StringBuilder response = new StringBuilder();
        		    String responseLine = null;
        		    
        		    
        		}))
    }
}
