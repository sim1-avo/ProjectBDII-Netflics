package servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class ServletAllMovies
 */
@WebServlet("/ServletAllMovies")
public class ServletAllMovies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAllMovies() {
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
	  String tutto= request.getParameter("tutto");
	  Connessione c = new Connessione();
      MongoCollection<Document>collection = c.conn().getCollection("Netflix");
      FilmDAO dao = new FilmDAO();
      String query="";
      
	  if(tutto!=null) {
	    ArrayList<Film> list= dao.doRetriveAll(collection);
	      for(int i=0;i<=list.size();i++) {
	          query+="<div class=\"result_card\" style=\"display:flex\">\r\n" + 
	              "                                <div class=\"img_card\">\r\n" + 
	              "                                    <img src=\"template/images/movies-icon-128.png\">\r\n" + 
	              "                                </div>\r\n" + 
	              "                                <div class=\"info_card\">\r\n" + 
	              "                                    <div class=\"title_card\">\r\n" + 
	              "                                        <p>"+list.get(i).getTitle()+"</p>\r\n" + 
	              "                                    </div>\r\n" + 
	              "                                    <div class=\"detail_card\">\r\n" + 
	              "                                        <div class=\"type_card\">\r\n" + 
	              "                                            <p>Type:"+list.get(i).getType()+"</p>\r\n" + 
	              "                                        </div>\r\n" + 
	              "                                        <div class=\"year_card\">\r\n" + 
	              "                                            <p>Release Year:"+list.get(i).getRelease_year()+"</p>\r\n" + 
	              "                                        </div>\r\n" + 
	              "                                        <div class=\"rating_card\">\r\n" + 
	              "                                            <p>Rating:"+list.get(i).getRating()+"</p>\r\n" + 
	              "                                        </div>\r\n" + 
	              "                                    </div>\r\n" + 
	              "                                </div>\r\n" + 
	              "                                <div class=\"seemore_card\">\r\n" + 
	              "                           <a href='ServletViewMovie?id="+list.get(i).getShow_id()+"'>"+
	              "                                    <img src=\"template/images/show.png\"> </a>\r\n" + 
	              "                                </div>\r\n" + 
	              "   </div> <hr>";
	      }
	      request.setAttribute("query", query);
          RequestDispatcher requestDisp;
          requestDisp= request.getRequestDispatcher("template/generic.jsp");
          requestDisp.forward(request, response);
	    
	  }
	}

}
