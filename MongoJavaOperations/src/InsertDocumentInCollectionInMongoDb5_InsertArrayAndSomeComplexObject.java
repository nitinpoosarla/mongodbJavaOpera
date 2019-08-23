import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class InsertDocumentInCollectionInMongoDb5_InsertArrayAndSomeComplexObject {

	public static void main(String[] args) {
		/* 
		 * { "_id" : { "$oid" : "585c104d7dbba63d58361eab"} , 
		 * "id" : 1 , "name" : "Ankit" ,
		 *  "address" : { "city" : "Delhi" , "Country" : "India"} ,
		 *   "Phone" : [ 9899 , 1234]}
		 * */
		MongoClient mc=new MongoClient("localhost",27017);
		try {
		
		System.out.println("connting mongo database");
		DB db=mc.getDB("miracle");
		System.out.println("getting collections");
		DBCollection dbcoll=db.getCollection("employee");
			
		BasicDBObject basicDBObjectMain = new BasicDBObject();
        basicDBObjectMain.put("id", 42);
        basicDBObjectMain.put("name", "nitinindia");
        
		BasicDBObject addr = new BasicDBObject();
		addr.put("city","Delhi");
		addr.put("Country","India");
		basicDBObjectMain.put("address",addr);
		
        
		List<Integer> l=new ArrayList<Integer>();
		l.add(123);
		l.add(456);
		basicDBObjectMain.put("Phone",l);
	//	dbcoll.insert(new BasicDBObject(mp));
		dbcoll.insert(basicDBObjectMain);
		System.out.println("inserted succes"+ "");
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
