import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

public class SaveDisplayRetriveImageInMongoDb {

	public static void main(String[] args) {
		
		MongoClient mc=new MongoClient("localhost",27017);
		try {
		
		System.out.println("connting mongo database");
		DB db=mc.getDB("miracle");
		System.out.println("getting collections");
		DBCollection dbcoll=db.getCollection("imagecoll");
		//C:\Users\Administrator\eclipse-workspace5\MongoJavaOperations\mime.png
		
		System.out.println("Step 1- Create imageFile");
        File imageFile = new File("C:\\Users\\Administrator\\eclipse-workspace5\\MongoJavaOperations\\mime.png");

        System.out.println("Step 2- create gridFS object");
        GridFS gridFS = new GridFS(db);
        
        System.out.println("Step 3- Create GridFSInputFile object from imageFile");
        GridFSInputFile gridFSInputFile = gridFS.createFile(imageFile);
		
        System.out.println("Step 4- Set name for image in MongoDB");
        gridFSInputFile.setFilename("mime.png");
        
        System.out.println("\nStep 5- Save image in collection in MongoDB");
        gridFSInputFile.save();

        System.out.println("\nStep 6- Display Image document stored in collection in MongoDB");
        DBCursor cursor = gridFS.getFileList();
        while (cursor.hasNext()) {
               System.out.println(cursor.next());
        }

        System.out.println("\nStep 7- Retrieve image from collection in MongoDB");
        List<GridFSDBFile> imageForOutput = gridFS.find("mime.png");
        //C:\Users\Administrator\eclipse-workspace5\MongoJavaOperations\mime1.png
        System.out.println("\nStep 8- Save retrieved image into local drive (E: drive) ");
        imageForOutput.get(0).writeTo("C:\\Users\\Administrator\\eclipse-workspace5\\MongoJavaOperations\\mime1.png");

        System.out.println("retrieved image saved in C:\\Users\\Administrator\\eclipse-workspace5\\MongoJavaOperations\\mime1.png");
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
