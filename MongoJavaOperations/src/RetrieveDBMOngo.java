import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class RetrieveDBMOngo {

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
	
		//Display data using single query
		/*		
		BasicDBObject bo=new BasicDBObject();
		bo.append("id",35).append("firstname","poosarla");
		
		System.out.println("\nExecute FIND/SEARCH query - "
                + "To FIND DOCUMENT where id = 1 and name = 'Ankit'");
   DBCursor cursor = dbcoll.find(bo);
   
  
   System.out.println("\nDisplay documents of collection after QUERING collection in MongoDB ");
   while (cursor.hasNext()) {
          System.out.println(cursor.next());
   }*/
		
		//Diaply data basedon gt  > 2
		BasicDBObject bo=new BasicDBObject();
		//lt and lte
		//eq
		//ne
		//gt and lt
		//put("id",new BasicDBObject("$eq", 2));
		//bo.put("id",new BasicDBObject().append("$gt",35).append("$lt",37));
        
		bo.put("$and", new BasicDBObject[]{
                new BasicDBObject("id",35),
                new BasicDBObject("firstname", "bhaskar")
                                         }                                                                    
             );
		
		DBCursor cursor = dbcoll.find(bo);
        System.out.println("\nDisplay documents of collection "
                     + "after QUERING collection in MongoDB ");
        while (cursor.hasNext()) {
               System.out.println(cursor.next());
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
