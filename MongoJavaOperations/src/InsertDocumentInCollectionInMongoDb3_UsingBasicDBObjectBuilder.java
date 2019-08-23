import java.util.Arrays;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class InsertDocumentInCollectionInMongoDb3_UsingBasicDBObjectBuilder {

	public static void main(String[] args) {
		
		MongoClient mc=new MongoClient("localhost",27017);
		try {
		
		System.out.println("connting mongo database");
		DB db=mc.getDB("miracle");
		System.out.println("getting collections");
		DBCollection dbcoll=db.getCollection("employee");
		
		BasicDBObjectBuilder  bojb=new BasicDBObjectBuilder();
		bojb.add("id",37);
		bojb.add("name","vimalapoo");
		
		dbcoll.insert(bojb.get());
				
				BasicDBObjectBuilder  bojb1=new BasicDBObjectBuilder();
		bojb1.add("id",38);
		bojb1.add("name","vimalabhask");
				
		dbcoll.insert(bojb1.get());
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
