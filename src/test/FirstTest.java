package test;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import connessione.Connessione;
import dao.FilmDAO;
import model.*;

public class FirstTest {
	public static void main(String[] args) {
		Connessione c = new Connessione();
		MongoCollection<Document> collection = c.conn().getCollection("Netflix");
		FilmDAO dao = new FilmDAO();
		dao.CreateIndex(collection, "country", 1);
		dao.CreateIndex(collection, "release_year", 1);
		dao.CreateIndex(collection, "rating", 1);
	}
}
