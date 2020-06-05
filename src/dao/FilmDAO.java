package dao;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

import model.Film;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
public class FilmDAO {

    public ArrayList<String> doRetrieve(List<Film> f, MongoCollection<Document> collection){
    	MongoCollection<Document> coll = collection;
        Bson filters= Filters.nin("title",f.get(0).getTitle(),f.get(1).getTitle());
    	MongoCursor<Document> bd = coll.find(filters).iterator();
    	//DBCursor bd = collection.find(new BasicDBObject().append("title", f.getTitle()).append("director", f.getDirector()));
        ArrayList<String> result_list= new ArrayList<String>();
        while(bd.hasNext()){
            result_list.add(bd.next().toString());
        }
        return result_list;
    }
    
    
    public ArrayList<String> findBy(Film f, MongoCollection<Document> collection){
      
      MongoCollection<Document> coll= collection;
      ArrayList<Bson> listBson= new ArrayList<Bson>();
      ArrayList<String> listaS= new ArrayList<String>();
      if(f.getType()!=null) {
        Bson type= Filters.eq("type", f.getType());
        listBson.add(type);
      }
      if(f.getTitle()!=null) {
        Bson title= Filters.regex("title", f.getTitle());
        listBson.add(title);
      }
      if(f.getDirector()!=null) {
        Bson director= Filters.regex("director", f.getDirector());
        listBson.add(director);
      }
      if(f.getCast()!=null) {
        Bson cast = Filters.regex("cast", f.getCast());
        listBson.add(cast);
      }
      if(f.getCountry()!=null) {
        Bson country= Filters.regex("country", f.getCountry());
        listBson.add(country);
      }
      if(f.getDate()!=null) {
        Bson date= Filters.regex("date_added", f.getDate());
        listBson.add(date);
      }
      if(f.getRelease_year()!=0) {
        Bson release_year= Filters.eq("release_year", f.getRelease_year());
        listBson.add(release_year);
      }
      if(f.getRating()!=null) {
        Bson rating= Filters.eq("rating", f.getRating());
        listBson.add(rating);
      }
      if(f.getDuration()!=null) {
        Bson duration= Filters.eq("duration", f.getDuration());
        listBson.add(duration);
      }
      if(f.getListed_in()!=null) {
        Bson listed_in= Filters.regex("listed_in", f.getListed_in());
        listBson.add(listed_in);
      }
      //Iterable<Bson> it= listBson;
      Bson filters= Filters.and(listBson); 
      MongoCursor<Document> db= coll.find(filters).iterator();
      while(db.hasNext()) {
        listaS.add(db.next().toString());
        
      }
      
      return listaS;
      
    }
    
}
