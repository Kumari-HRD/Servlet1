package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.MovieDao;
import dto.Movie;

@WebServlet("/showby-movielang")
public class ShowByMovielang extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("showbymovielang.html").forward(req, resp);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("<h1 align='center'> This is View by Movie Name </h1>");	
		String movie_lang=req.getParameter("movie_lang");	
		try{
			MovieDao dao = new MovieDao();
			List<Movie> list = dao.ViewByMovieLang(movie_lang);
			if(list.isEmpty())
			{
	
				resp.getWriter().print("<h1 style='color:red' align='center'> No Movies Found with lang="+ movie_lang +  "</h1>");
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
			req.getRequestDispatcher("showbymovielang.html").forward(req, resp);
    	
		}
			
		}
	}
