import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class CreateConnectionToMongoDbInJava {

	public static void main(String[] args) {
		MongoClient mc=new MongoClient("localhost",27017);
		try {
		
		System.out.println("connting mongo database");
		DB db=mc.getDB("miracle");
		System.out.println("getting collections");
		DBCollection dbcoll=db.getCollection("employee");
		
		String json1="{id:35,firstname:'poosarla'}";
		BasicDBObject boj=new BasicDBObject();
		
		DBObject dbobj=(DBObject)JSON.parse(json1);
		String json2="{id:36,firstname:'bhaskar'}";
		DBObject dbobj1=(DBObject)JSON.parse(json2);
		//boj.put("_id",32);
	//	boj.put("name","nitinpoo");
	//	boj.put("sal",50000);
		
		dbcoll.insert(dbobj);
		dbcoll.insert(dbobj1);
		System.out.println("insert done");
		
		DBCursor dbcur=dbcoll.find();
		while(dbcur.hasNext())
		{
			System.out.println(dbcur.next());
		}
			
		}
		catch(Exception e)
		{
			System.out.println(Arrays.asList(e.getStackTrace()));
		}
		finally
		{
		mc.close();	
		}

	}

}
