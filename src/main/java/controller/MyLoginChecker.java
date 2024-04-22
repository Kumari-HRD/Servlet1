package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter({"/delete-movie","/edit-movie","/insert-movie","/showall-movies","/fetchalljsp","/showby-moviegenre","/showby-movieid","/showby-movielang","/showby-moviename","/showby-movierating"})	
public class MyLoginChecker implements Filter
{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		if(req.getSession().getAttribute("login")!=null) {
			chain.doFilter(request, response);
		}else {
			response.getWriter().print("<h1 align='center' style='color:red'>Invalid Session</h1>");
			req.getRequestDispatcher("Login.html").include(req, response);
		}
	}

}