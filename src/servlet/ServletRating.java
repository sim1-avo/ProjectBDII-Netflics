package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.json.simple.JSONObject;

import com.mongodb.client.MongoCollection;

import connessione.Connessione;
import dao.FilmDAO;

/**
 * Servlet implementation class ServletES
 */
@WebServlet("/ServletES")
public class ServletRating extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRating() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  doPost(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  Integer result=0;
	  ArrayList<String> rate= new ArrayList<String>();
	  ArrayList<String> count= new ArrayList<String>();
	  if(Integer.parseInt(request.getParameter("flag"))==7) {
		  result=1;
	      rate.add("TV-PG");
	      rate.add("TV-Y");
	      rate.add("TV-Y7");
	      rate.add("TV-Y7-FV");
	      rate.add("TV-14");
	      rate.add("TV-G");
	      rate.add("TV-MA");
	      
	      Connessione c = new Connessione();
          MongoCollection<Document>collection = c.conn().getCollection("Netflix");
          FilmDAO dao = new FilmDAO();
          count=dao.chartRating(rate, collection);
		  
		}
		
		JSONObject res = new JSONObject();
	    res.put("result", result);
	    res.put("rating", rate);
	    res.put("count", count);
	    PrintWriter out = response.getWriter();
	    out.println(res);
	    response.setContentType("json");
	}

}
