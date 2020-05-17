package connessione;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Connessione {
    Logger mongoLogger=null;
    MongoClient mongoClient=null;
    MongoDatabase database= null;
    
   public MongoDatabase conn() {
    this.mongoLogger = Logger.getLogger( "org.mongodb.driver" );
    this.mongoLogger.setLevel(Level.SEVERE);
    this.mongoClient = new MongoClient("localhost", 27017);
    this.database = mongoClient.getDatabase("ProjectBDII");
    return database;
  }
  
  public MongoClient closeDB() {
    return this.mongoClient;
  }

}
