import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class DeleteDocumentFromCollectionInMongoDb1_specificDocument {

	public static void main(String[] args) {
		

		MongoClient mc=new MongoClient("localhost",27017);
		try {
		
		System.out.println("connting mongo database");
		DB db=mc.getDB("miracle");
		System.out.println("getting collections");
		DBCollection dbcoll=db.getCollection("employee");
			
		BasicDBObject basicDBObjectMain = new BasicDBObject();
        basicDBObjectMain.put("id", 43);
        basicDBObjectMain.put("name", "ankit");
        

		dbcoll.insert(basicDBObjectMain);
		System.out.println("inserted succes"+ "");
		DBCursor dbcur=dbcoll.find();
		while(dbcur.hasNext())
		{
			System.out.println(dbcur.next());
		}
		
		System.out.println("deleting the record");
		BasicDBObject delobj = new BasicDBObject();
		delobj.put("id", 43);
		
		WriteResult wr=dbcoll.remove(delobj);
		System.out.println("No of documents deleted = " + wr.getN());
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
