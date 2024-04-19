package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDao;

@WebServlet("/delete-movie")
public class DeleteMovie extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		MovieDao dao=new MovieDao();
		dao.deleteMovie(id);
		resp.getWriter().print("<h1 align ='center' style='color:green'> Movie removed successfully </h1>");	
		req.getRequestDispatcher("home.html").include(req, resp);
		
	}
	
}
