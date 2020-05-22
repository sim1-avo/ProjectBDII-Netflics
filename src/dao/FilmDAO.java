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
}
