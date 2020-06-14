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
@WebServlet("/ServletCountry")
public class ServletCountry extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCountry() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
      doPost(request, response);    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
      Integer result=0;
      Integer error=0;
      String country= request.getParameter("country");
      String country1= request.getParameter("country1");
      String country2= request.getParameter("country2");
      ArrayList<String> as= new ArrayList<String>();
      
      
      if(country!=null && !country.equals("")) {
      as.add(country);
      }
      if(country1!=null && !country1.equals("")) {
      as.add(country1);
      }
      if(country2!=null && !country2.equals("")) {
      as.add(country2);
      }
      ArrayList<String> rate= new ArrayList<String>();
      ArrayList<String> count= new ArrayList<String>();
      ArrayList<Document> doc= new ArrayList<Document>();
      if(request.getParameter("table").equals("country")) {
          result=1;
          
          
          Connessione c = new Connessione();
          MongoCollection<Document>collection = c.conn().getCollection("Netflix");
          FilmDAO dao = new FilmDAO();
          doc=dao.doRetrieveCount(collection, request.getParameter("table"), as);
          if(!doc.isEmpty()) {
          for(String s: as) {
            rate.add(s);
            System.out.println(s);
            
          }
          for(int i=0; i<doc.size(); i++) {
            count.add(""+doc.get(i).get("country"));
            System.out.println(""+doc.get(i).get("country"));
          }
      }else {
        error=1;
      }
        }
        
        JSONObject res = new JSONObject();
        res.put("error", error);
        res.put("result", result);
        res.put("rating", rate);
        res.put("count", count);
        
        PrintWriter out = response.getWriter();
        out.println(res);
        response.setContentType("json");
    }

}
