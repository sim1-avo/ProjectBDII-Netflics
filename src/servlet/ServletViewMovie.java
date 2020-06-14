package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import connessione.Connessione;
import dao.FilmDAO;
import model.Film;

/**
 * Servlet implementation class ServletViewMovie
 */
@WebServlet("/ServletViewMovie")
public class ServletViewMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletViewMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	  String showid= request.getParameter("id");
	  Connessione c = new Connessione();
      MongoCollection<Document>collection = c.conn().getCollection("Netflix");
      FilmDAO dao = new FilmDAO();
	  if(showid!=null) {
	      String vedi="<div class='content' style='height:auto'>";
	      Film film= dao.doRetriveFilm(showid, collection); 
	      vedi+="<div class='titlefilm'>";
	      vedi+= "<b>"+film.getTitle()+"</b>"
	          + "<br>"+film.getType() +" &#183; "+ film.getRelease_year()+" &#183; "+film.getDuration();
	      vedi+="</div>";
	      if(!film.getDirector().equals("")) {
	      vedi+="<div class='directorfilm'>";
	      vedi+= "<b>Director:</b><br> "+film.getDirector();
	      vedi+="</div>";
	      }
	      if(!film.getCast().equals("")) {
	      vedi+="<div class='castfilm'>";
          vedi+= "<b>Cast:</b><br> "+film.getCast();
          vedi+="</div>";
	      }
	      if(!film.getCountry().equals("")) {
          vedi+="<div class='countryfilm'>";
          vedi+= "<b>Country:</b><br> "+film.getCountry();
          vedi+="</div>";
	      }
	      if(!film.getDescription().equals("")) {
          vedi+="<div class='descriptionfilm'>";
          vedi+= "<b>Description:</b><br> "+film.getDescription();
          vedi+="</div>";
	      }
	      if(!film.getListed_in().equals("")) {
          vedi+="<div class='categoryfilm'>";
          vedi+= "<b>Category:</b><br> "+film.getListed_in();
          vedi+="</div>";
	      }
          vedi+="<div class='infofilm'>";
          vedi+= "<b>Date:</b> "+film.getDate() 
              + "<br>"+ "<b>Rating:</b> " +film.getRating() + "<br>";
          vedi+="</div>";
          vedi+="</div>";
	      
	      request.setAttribute("query", vedi);
	      RequestDispatcher requestDisp;
          requestDisp= request.getRequestDispatcher("template/generic.jsp");
          requestDisp.forward(request, response);

	  }
	  
	}

}
