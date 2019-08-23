import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class UpdateDocumentInCollectionInMongoDb1 {

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
		
		System.out.println("updating the record");
		BasicDBObject delobj = new BasicDBObject();
		delobj.put("id", 43);
		
		BasicDBObject upobj = new BasicDBObject();
		upobj.put("$set",new BasicDBObject().append("name","updatednitinpoosarl"));
		
		WriteResult wr=dbcoll.update(delobj,upobj);
		System.out.println("No of documents updated = " + wr.getN());
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
