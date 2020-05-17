package test;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import connessione.Connessione;
public class MongoClientTest {
    public static void main(String[] args) {
       
      Connessione c= new Connessione();
      
      for (String name : c.conn().listCollectionNames()) {
            System.out.println(name);
        }
        
        //interrogare collezione
        MongoCollection<Document> NetflixCollection = c.conn().getCollection("Netflix");
        for(Document document : NetflixCollection.find()){
          System.out.println(document.getString("cast"));
      }
      /*  
        //creare collezione
        boolean exists = false;
        for (String name : database.listCollectionNames()) {
            System.out.println(name);
            if(name.equals("Persona")) exists=true;
        }
        if(!exists) database.createCollection("Persona");
        //fine creazione
        
        for (String name : database.listCollectionNames()) {
          System.out.println(name);
      }
        
        //inserire documenti in collezione
        if(!exists) database.createCollection("Persona");
        MongoCollection<Document> personaCollection =
                database.getCollection("Persona");
        if(personaCollection.count()==0) {
            Document document = new Document();
            document.put("Nome", "Mario");
            document.put("Cognome", "Rossi");
            document.put("Età", "34");
            document.put("Lavoro", "Impiegato");
            personaCollection.insertOne(document);
        }
        for(Document document : personaCollection.find()){
            System.out.println(document);
        }
        */
        c.closeDB().close();;
    }
}