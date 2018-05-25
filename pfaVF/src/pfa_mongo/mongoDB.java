package pfa_mongo;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.Document;
import org.json.JSONException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

public class mongoDB {
	public static void main(String[] args) throws Exception {
		new AgregateurRSS();
		JsonTransf jt=new JsonTransf();
		jt.stockage();
		new parserJson();
		System.out.println("termine");

	}
}
