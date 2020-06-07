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
    
    public Film doRetriveFilm(String id, MongoCollection<Document> collection) {
      MongoCollection<Document> coll= collection;
      Bson filters = Filters.eq("show_id", id);
      Film f1= new Film();
      for(Document document : coll.find(filters)){
        f1.setShow_id(document.getString("show_id"));
        f1.setType(document.getString("type"));
        f1.setTitle(document.getString("title"));
        f1.setDirector(document.getString("director"));
        f1.setCast(document.getString("cast"));
        f1.setCountry(document.getString("country"));
        f1.setDate(document.getString("date_added"));
        f1.setRelease_year(Integer.parseInt(document.getString("release_year")));
        f1.setRating(document.getString("rating"));
        f1.setDuration(document.getString("duration"));
        f1.setListed_in(document.getString("listed_in"));
        f1.setDescription(document.getString("description"));
        
        System.out.println(f1.toString());
    }
      
      return f1;
    }
    
    public ArrayList<Film> doRetriveAll(MongoCollection<Document> collection) {
      MongoCollection<Document> coll= collection;
      //Bson filters = Filters.eq("show_id", id);
      ArrayList<Film> list= new ArrayList<Film>();
      for(Document document : coll.find()){
        Film f= new Film(
            (document.getString("show_id")),
            (document.getString("type")),
            (document.getString("title")),
            (document.getString("director")),
            (document.getString("cast")),
            (document.getString("country")),
            (document.getString("date_added")),
            (Integer.parseInt(document.getString("release_year"))),
            (document.getString("rating")),
            (document.getString("duration")),
            (document.getString("listed_in")),
            (document.getString("description"))
        );
      list.add(f);
    }
      
      return list;
    }
    
    public ArrayList<Film> findBy(Film f, MongoCollection<Document> collection){
      
      MongoCollection<Document> coll= collection;
      ArrayList<Bson> listBson= new ArrayList<Bson>();
      ArrayList<Film> listaFilm= new ArrayList<Film>();
     // Film f1= new Film();
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
        Bson release_year= Filters.eq("release_year", ""+f.getRelease_year());
        listBson.add(release_year);
      }
      if(f.getRating()!=null) {
        Bson rating= Filters.regex("rating", f.getRating());
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
      for(Document document : coll.find(filters)){
        Film f1= new Film(
            (document.getString("show_id")),
            (document.getString("type")),
            (document.getString("title")),
            (document.getString("director")),
            (document.getString("cast")),
            (document.getString("country")),
            (document.getString("date_added")),
            (Integer.parseInt(document.getString("release_year"))),
            (document.getString("rating")),
            (document.getString("duration")),
            (document.getString("listed_in")),
            (document.getString("description"))
        );
      listaFilm.add(f1);
    }
      
      return listaFilm;
      
    }
    
}
