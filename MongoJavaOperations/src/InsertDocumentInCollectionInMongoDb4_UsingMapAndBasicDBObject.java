import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class InsertDocumentInCollectionInMongoDb4_UsingMapAndBasicDBObject {

	public static void main(String[] args) {
		
		MongoClient mc=new MongoClient("localhost",27017);
		try {
		
		System.out.println("connting mongo database");
		DB db=mc.getDB("miracle");
		System.out.println("getting collections");
		DBCollection dbcoll=db.getCollection("employee");
		
		Map<String,Object> mp=new HashMap<String,Object>();
		mp.put("id",39);
		mp.put("firstname","india");
		
		dbcoll.insert(new BasicDBObject(mp));
		Map<String,Object> mp1=new HashMap<String,Object>();
		mp1.put("id",40);
		mp1.put("firstname","indiano1");
		
		dbcoll.insert(new BasicDBObject(mp));
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
