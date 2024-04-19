package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.MovieDao;
import dto.Movie;

@WebServlet("/edit-movie")
@MultipartConfig
public class EditMovie extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		MovieDao dao=new MovieDao();
		Movie movie=dao.findMovie(id);
		req.setAttribute("movie", movie);
		req.getRequestDispatcher("edit-movie.jsp").forward(req, resp);		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String movie_name=req.getParameter("movie_name");		
		String movie_lang=req.getParameter("movie_lang");
		Part movie_image=req.getPart("movie_image");
		String movie_genre=req.getParameter("movie_genre");	
		MovieDao dao=new MovieDao();
		try 
		{
			double movie_rating =Double.parseDouble(req.getParameter("movie_rating"));
			
			Movie movie=dao.findMovie(id);
			movie.setName(movie_name);
			movie.setLanguage(movie_lang);
			movie.setGenre(movie_genre);
			movie.setRating(movie_rating);
			
			byte[] image=new byte[movie_image.getInputStream().available()];
			movie_image.getInputStream().read(image);
			
			if(image.length>0)
			movie.setPicture(image);
			
			dao.updateMovie(movie);
			
			//resp.getWriter().print(movie_name + " " + movie_lang + " " + movie_rating + " "+ movie_image + " " + movie_genre);
			
			resp.getWriter().print("<h1 align='center' style='color:green'> Movie Updated Successfully </h1>");
			req.getRequestDispatcher("home.html").include(req, resp);	
		
		}
		catch(NumberFormatException e)
		{
			resp.getWriter().print("<h1 align='center'>Enter Proper Rating</h1>");
			req.getRequestDispatcher("edit-movie").include(req, resp);					
		}										
	}

	
}
