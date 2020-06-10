package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

import com.mongodb.client.MongoCollection;

import connessione.Connessione;
import dao.FilmDAO;

/**
 * Servlet implementation class ServletGroupByDate
 */
@WebServlet("/ServletGroupByDate")
public class ServletGroupByDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGroupByDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connessione c = new Connessione();
		FilmDAO dao = new FilmDAO();
		MongoCollection<Document>collection = c.conn().getCollection("Netflix");
		List<Document> d_list=dao.doRetrieveGroupByDate(collection);
		List<String> year_list= new ArrayList<String>();
		List<String> count_list= new ArrayList<String>();
		PrintWriter out=response.getWriter();
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
		for(int i=0;i<d_list.size();i++) {
			year_list.add(d_list.get(i).get("_id").toString());
			count_list.add(d_list.get(i).get("total").toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
