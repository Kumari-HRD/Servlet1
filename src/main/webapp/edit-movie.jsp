<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="dto.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit title here</title>
</head>
<body>
	<%
	Movie movie = (Movie) request.getAttribute("movie");
	%>	
	<div align="center"> 
			<h1>Update Movie</h1>
			<form action="edit-movie" method="post" enctype="multipart/form-data">	
					<input type="hidden" name="id" value="<%=movie.getId() %>">		
					Movie Name : <br>
					<input type="text" name="movie_name" 
					value="<%=movie.getName() %>" required><br><br>
					Movie Language : <br>
					<select name="movie_lang" required="required">
						<option  selected value="<%=movie.getLanguage() %>"> <%=movie.getLanguage() %> </option>
	            		<option> Kannada</option>
	            		<option> English</option>
	            		<option> Hindi</option>
       		 		</select>	
       		 		<br> <br>
       		 		Rating : <br>
					<input type="text" name="movie_rating" value="<%=movie.getRating() %>"><br><br>
					Image : <br>
					<input type="file"  name="movie_image">
					<img height="75px" width="75px" alt="<%=movie.getName()%>"
					src="data:image/jpeg;base64,<%=Base64.encodeBase64String(movie.getPicture())%>">					
					<br><br>				
					Genre : <br>
					<select name="movie_genre" required="required">
						<option  selected value="<%=movie.getGenre()%>"> <%=movie.getGenre()%></option>
	            		<option> Horror</option>
	            		<option> Comedy</option>
	            		<option> Action</option>
	            		<option> Thriller</option>            		
       		 		</select>	
       		 		<br> <br>				
       		 		 <button>Update</button>		
			</form>		
		</div>
</body>
</html>