package test;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import connessione.Connessione;
import dao.FilmDAO;
import model.*;

public class FirstTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Film> f_list = new ArrayList();
		Film f1= new Film();
		
		f1.setRelease_year(2019);
		f1.setRating("MA");
		
		Film f2 = new Film();
		f2.setTitle("Jandino: Whatever it Takes");
		f_list.add(f1);
		f_list.add(f2);
		
		Connessione c = new Connessione();
		MongoCollection<Document> collection = c.conn().getCollection("Netflix");
		FilmDAO dao = new FilmDAO();
		//ArrayList<Film>results = dao.findBy(f1, collection);
		ArrayList<String> as= new ArrayList<String>();
		as.add("Argentina");
		as.add("Israel");
		
		ArrayList<Document> film= dao.doRetrieveCount(collection,"country", as);
		for(Document d: film) {
		  System.out.println(d.toString());
		}
		//ArrayList<Film> list= dao.doRetriveAll(collection);
		//for(int i=0;i<results.size();i++) {
			//System.out.println(results.get(i).toString());
		//}
		
		//System.out.println(f1.toString());

		
	}

}
