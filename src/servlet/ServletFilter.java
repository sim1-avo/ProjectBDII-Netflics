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
 * Servlet implementation class ServletFilter
 */
@WebServlet("/ServletFilter")
public class ServletFilter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFilter() {
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
		String submit= request.getParameter("submit");
		
		String type= request.getParameter("type");
		String title= request.getParameter("title");
		String director= request.getParameter("director");
		String cast= request.getParameter("cast");
		String country= request.getParameter("country");
		String anno= request.getParameter("year");
		int year=0;
		if(anno.length()>=3) {
		year= Integer.parseInt(anno);
		}
		String date= request.getParameter("date");
		String dateadded=date;
		//FORMATTAZIONE DATA
		if(!date.isEmpty()) {
		String d, m, y;
		y=date.substring(0, 4);
		m=date.substring(5, 7);
		d=date.substring(8, 10);
		
		System.out.println("mese"+m);
		
		switch(m) {
		case "01": m="January"; break;
		case "02": m="February"; break;
		case "03": m="March"; break;
		case "04": m="April"; break;
		case "05": m="May"; break;
		case "06": m="June"; break;
		case "07": m="July"; break; 
		case "08": m="August"; break;
		case "09": m="September"; break;
		case "10": m="October"; break;
		case "11": m="November"; break;
		case "12": m="December"; break;
		}
		switch(d) {
        case "01": d="1"; break;
        case "02": d="2"; break;
        case "03": d="3"; break;
        case "04": d="4"; break;
        case "05": d="5"; break;
        case "06": d="6"; break;
        case "07": d="7"; break;
        case "08": d="8"; break;
        case "09": d="9"; break;
        }
		dateadded= m + " "+ d + ", "+ y;
		}
		//FINE FORMATTAZIONE DATA
		
		String rating= request.getParameter("rating");
		String duration= request.getParameter("duration");
		String category= request.getParameter("category");
		
		System.out.println(date);
		//Film film= new Film("",type, title, director, cast, country, date, Integer.parseInt(year), rating, duration, category, "");
		//System.out.println(film.toString());
		Film f= new Film();
		
		f.setType(type);
		
		if(title.length()>=1) {
		  f.setTitle(title);
		}
		if(director.length()>=1) {
		  f.setDirector(director);
		}
		if(cast.length()>=1) {
		  f.setCast(cast);
		}
		if(country.length()>=1) {
		  f.setCountry(country);
		}
		if(dateadded.length()>=1) {
		  f.setDate(dateadded);
		}
		if(year!=0) {
		  f.setRelease_year(year);
		}

		  f.setRating(rating);
		
		if(duration.length()>=1) {
		  f.setDuration(duration);
		}
		if(category.length()>=1) {
		  f.setListed_in(category);
		}
		
		Connessione c = new Connessione();
	      MongoCollection<Document>collection = c.conn().getCollection("Netflix");
	      FilmDAO dao = new FilmDAO();
	      String query="";
	      
	      if(submit!=null) {
	        System.out.println(f.toString());
	        ArrayList<Film> list= dao.findBy(f, collection);
	        if(!list.isEmpty()) {
	          for(int i=0;i<list.size();i++) {
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
	        }else {
	          query+="<div> Contenuto non disponibile</div>";
	        }
	          request.setAttribute("query", query);
	          RequestDispatcher requestDisp;
	          requestDisp= request.getRequestDispatcher("template/generic.jsp");
	          requestDisp.forward(request, response);
	        
	      }
	}

}
