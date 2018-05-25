package pfa_mongo;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.*;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
public class parserJson {
	
	public parserJson() throws Exception {
		
		
		
		MongoClient mongoClient = new MongoClient("localhost",27017);
		
		
	      System.out.println("Connected to the database successfully");
		                        
		// Notre base de données
		
	        DB db = mongoClient.getDB("pfa");
		


		
		
	Path xmlDocPath=Paths.get("/home/imane/FluxRSSJSON");

	try (DirectoryStream<Path> stream = Files.newDirectoryStream(xmlDocPath)) {
		
		
	    for (Path file: stream) {
	        System.out.println("\n\n"+file.getFileName());
	        String s="/home/imane/FluxRSSJSONF2/"+file.getFileName();
	        Path p=Paths.get(s);
	         String filename=file.getFileName().toString();
	         filename=filename.substring(0, filename.length()-5);
	        DBCollection collection = db.getCollection(filename);

	        String XML_STRING = null;
	        String Json_STRING=null;
	        
	       
	        InputStream flux=new FileInputStream("/home/imane/FluxRSSJSON/"+file.getFileName().toString()); 
	        InputStreamReader lecture=new InputStreamReader(flux);
	        BufferedReader buff=new BufferedReader(lecture);
	        
		    try {
		    	   System.out.println("**********");
		      
		    	   Writer w;
              		w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/home/imane/FluxRSSJSONF2/"+file.getFileName()), "utf-8"));
       			
		    	   while ((XML_STRING=buff.readLine())!=null){
		               System.out.println(XML_STRING);

		    		   System.out.println("**********");
		    		   
//		    		      // On récupère le JSON complet
		               JSONObject jsonObject = new JSONObject(XML_STRING);
	            	   System.out.println("111111111111111111111");

		               // On récupère le tableau d'objets qui nous concernent
		               JSONObject object2=new JSONObject(jsonObject.getString("rss"));
		               JSONObject object3=new JSONObject(object2.getString("channel"));

		               JSONArray array = new JSONArray(object3.getString("item"));

	                   List<DBObject> documents = new ArrayList<>();

		               // Pour tous les objets on récupère les infos
		               for (int i = 0; i < array.length(); i++) {
		                   // On récupère un objet JSON du tableau
		                   JSONObject obj = new JSONObject(array.getString(i));
		                   DBObject document1 = new BasicDBObject();

		                   document1.put("title", obj.getString("title"));
		                   document1.put("link", obj.getString("link"));
		                   document1.put("description", obj.getString("description"));
		                   document1.put("pubDate", obj.getString("pubDate"));
		                   
			               documents.add(document1);
		            	   System.out.println("111111111111111111111"+documents.size());



		                   
		                   // On fait le lien Personne - Objet JSON
		                   System.out.println("{");
		                   System.out.println("title:");
		                   System.out.println(obj.getString("title"));
		                   System.out.println(",link:");
		                   System.out.println(obj.getString("link"));
		                   System.out.println(",description:");
		                   System.out.println(obj.getString("description"));
		                   System.out.println(",pubDate:");
		                   System.out.println(obj.getString("pubDate"));
		                   System.out.println("{");
		                   
		                   JSONObject test = new JSONObject();

		                   test.put("title",obj.getString("title"));
		               		test.put("link",obj.getString("link"));
		               		test.put("description", obj.getString("description"));
		               		
		               		test.put("pubDate", obj.getString("pubDate"));
		                   
		                   
		           
		               		
		        			    w.write(test.toString());
		        			   
			        			

		               		
		               	

		                  
		               }
	                   collection.insert(documents);

		               for(DBObject doc:documents) {
		            	   System.out.println(doc.toString());
		               }

		    		  
		    		}
		    	   w.close();
		       
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		   
		  
	    }
	} catch (DirectoryIteratorException x) {
	    // IOException can never be thrown by the iteration.
	    // In this snippet, it can only be thrown by newDirectoryStream.
	    System.err.println(x);
	}
	    }

}