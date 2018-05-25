package pfa_mongo;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.json.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;


public class JsonTransf {
	
	

	public static  List processXML2JSON() throws JSONException, IOException {
	    
		List  jsonPrettyPrintString= new ArrayList();
		
		Path xmlDocPath=Paths.get("/home/imane/FluxRSS");

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(xmlDocPath)) {
			
			
		    for (Path file: stream) {
		        String XML_STRING = null;
		        String s="/home/imane/FluxRSS/"+file.getFileName();
		        Path p=Paths.get(s);
		        
			    try {
			        XML_STRING = Files.lines(p).collect(Collectors.joining("\n"));
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			    System.out.println(s);
			    JSONObject xmlJSONObj = XML.toJSONObject(XML_STRING);
			    System.out.println("************************");
			   
			 
			    jsonPrettyPrintString.add(xmlJSONObj.toString());
		    
			    
		}
			

		} catch (DirectoryIteratorException x) {
		    // IOException can never be thrown by the iteration.
		    // In this snippet, it can only be thrown by newDirectoryStream.
		    System.err.println(x);
		}
		
	    
	   return jsonPrettyPrintString;
	}
	
	
	

	
	
	public static void stockage() throws JSONException, IOException {
		int i;
		Path jsonDocPath=Paths.get("/home/imane/FluxRSSJSON");
		DirectoryStream<Path> stream2 = Files.newDirectoryStream(jsonDocPath);
		List json=processXML2JSON();
		
		 i=-1;
		// Writer writer; 
		for (Path file2: stream2) {
			
			PrintWriter PW=new PrintWriter(new FileWriter("/home/imane/FluxRSSJSON/"+file2.getFileName()));
			PW.println(json.get(i+1));
			PW.close();

			System.out.println("***************************");    
			System.out.println("\n\n"+file2.getFileName());
			System.out.println("............................");
			
	        i++;
		}
	}
	
	
	
	
	
//	public static void main(String[] args) throws JSONException, IOException {
//		stockage();
//	}
	
}