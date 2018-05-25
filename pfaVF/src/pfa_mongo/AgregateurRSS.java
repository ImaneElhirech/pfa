package pfa_mongo;



	import java.io.BufferedReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.net.URL;
	import java.net.URLConnection;
	import java.nio.file.DirectoryStream;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;
	import java.util.List;

	public class AgregateurRSS {
		public AgregateurRSS() throws IOException {
			//"http://telquel.ma/feed",
			String urls[]= {"https://www.lepetitjournalmarocain.com/feed/",
"https://lematin.ma/feed-rss/articles.xml","http://www.marocwebo.com/feed",
"http://www.maroc-hebdo.press.ma/feed/","https://ahdath.info/feed",
"https://www.h24info.ma/feed/","http://www.lagazettedumaroc.com/feed/",
"https://lnt.ma/feed/","https://www.hespress.com/feed",
"https://www.lereporter.ma/feed/","http://lavieeco.com/feed",
"http://maghreb-observateur.com/?feed=rss2","http://www.it.ma/feed/",
"https://www.libe.ma/xml/syndication.rss","http://bayanealyaoume.press.ma/feed",
"https://ledesk.ma/feed/",
"http://www.leconomiste.com/rss-leconomiste","http://www.marocpress.com/fr/feed"


};
			
			
			Path jsonDocPath=Paths.get("/home/imane/FluxRSS");
			DirectoryStream<Path> stream2 = Files.newDirectoryStream(jsonDocPath);
			int i;
			 i=0;
			// Writer writer; 
			for (Path file2: stream2) {
				URL url = new URL(urls[i]);
				URLConnection spoof = url.openConnection();

				//Spoof the connection so we look like a web browser
				spoof.setRequestProperty( "User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0;    H010818)" );
				BufferedReader in = new BufferedReader(new InputStreamReader(spoof.getInputStream()));
				String strLine = "";
				String finalHTML = "";
				//Loop through every line in the source
				while ((strLine = in.readLine()) != null){
				   finalHTML += strLine; 
				}
			  
				PrintWriter PW=new PrintWriter(new FileWriter("/home/imane/FluxRSS/"+file2.getFileName()));
				PW.println(finalHTML);
				PW.close();

				    
				System.out.println("\n\n"+file2.getFileName().toString());
		        i++;
			}
		}

	}


