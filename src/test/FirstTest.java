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
		f1.setTitle("Dino Hunt");
		Film f2 = new Film();
		f2.setTitle("Jandino: Whatever it Takes");
		f_list.add(f1);
		f_list.add(f2);
		Connessione c = new Connessione();
		MongoCollection<Document>collection = c.conn().getCollection("Netflix");
		FilmDAO dao = new FilmDAO();
		ArrayList<String>results = dao.doRetrieve(f_list, collection);
		for(int i=0;i<results.size();i++) {
			System.out.println(results.get(i));
		}
		
	}

}
