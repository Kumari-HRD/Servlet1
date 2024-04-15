package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDao;
import dto.Movie;

@WebServlet("/showall-movies")
public class ShowAllMovies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 MovieDao dao=new MovieDao();
    	 List<Movie> list=dao.ViewAllMovies();
    	 if (list.isEmpty())
    	 {
    		 resp.getWriter().print("<h1 style 'color:red' align='center'> No ");
    		 req.getRequestDispatcher("home.html").include(req, resp);
    	 }
    	 else
    	 {
    		resp.getWriter().print("<html><body><div align='center'><table border='1'>");
    		resp.getWriter().print("<tr>");
    		resp.getWriter().print("<th> Name </th>");
    		resp.getWriter().print("<th>Image</th>");
 			resp.getWriter().print("<th>Language</th>");
 			resp.getWriter().print("<th>Genre</th>");
 			resp.getWriter().print("<th>Rating</th>");
 			resp.getWriter().print("<th>Edit</th>");
 			resp.getWriter().print("<th>Delete</th>");
 			 resp.getWriter().print("</tr>");
    		 for(Movie movie : list)
    		 {
    			resp.getWriter().print("<tr>");
    			resp.getWriter().print("<th>" + movie.getName()  + "</th>");
        		resp.getWriter().print("<th> Image </th>");
     			resp.getWriter().print("<th>" + movie.getLanguage() + "</th>");
     			resp.getWriter().print("<th>" + movie.getGenre() + "</th>");
     			resp.getWriter().print("<th>" + movie.getRating() + "</th>");
     			resp.getWriter().print("<th><button> Edit</button> </th>");
     			resp.getWriter().print("<th><button> Delete </button> </th>");
     			 resp.getWriter().print("</tr>");
    		 } 
    		 resp.getWriter().print("</table></div></body></html>"); 
    	 }
    }
}

	
