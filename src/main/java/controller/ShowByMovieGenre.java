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

@WebServlet("/showby-moviegenre")
public class ShowByMovieGenre extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("showbymoviegenre.html").forward(req, resp);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("<h1 align='center'> This is View by Movie Name </h1>");	
		String movie_genre=req.getParameter("movie_genre");	
		try{
			MovieDao dao = new MovieDao();
			List<Movie> list = dao.ViewByMovieGenre(movie_genre);
			if(list.isEmpty())
			{
				resp.getWriter().print("<h1 style='color:red' align='center'> No Movies Found with genre=" + movie_genre +  "</h1>");
				req.getRequestDispatcher("home.html").include(req, resp);
			}
			else
			{
				req.setAttribute("list", list);
				req.getRequestDispatcher("fetchall.jsp").forward(req, resp);
				
			}
			}
    
		catch(Exception e) {
			resp.getWriter().println("An error occurred while fetching movies.");
			req.getRequestDispatcher("showbymoviegenre.html").forward(req, resp);
    	
		}
			
		}
	}
