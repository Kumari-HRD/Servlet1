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

@WebServlet("/fetchalljsp")
public class ShowAllMoviesjsp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 MovieDao dao=new MovieDao();
    	 List<Movie> list=dao.ViewAllMovies();
    	 if (list.isEmpty())
    	 {
    		 resp.getWriter().print("<h1 style 'color:red' align='center'> No Movies to Display");
    		 req.getRequestDispatcher("home.html").include(req, resp);
    	 }
    	 else
    	 {
    		req.setAttribute("list",list);
    		req.getRequestDispatcher("fetchall.jsp").forward(req, resp);
    		
    	 }
    }
}

	
