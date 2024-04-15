package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import dto.Movie;

import java.util.List;
import dto.Movie;

public class MovieDao 
{

	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dbservmovie");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public void saveMovie(Movie movie)
	{
      transaction.begin();
	  manager.persist(movie);
	  transaction.commit();
	      
	}
	
	public List<Movie> ViewAllMovies() 
	{		
		return manager.createQuery("select m from Movie m").getResultList();
		
	}
	
	public List<Movie> ViewByMovieId(int id) 
	{
        return manager.createQuery("select m from Movie m where m.id=?1").setParameter(1, id).getResultList();
    }
	
	 public List<Movie>  ViewByMovieName(String name) 
	 {
	       return manager.createQuery("select m from Movie m where m.name=?1").setParameter(1, name).getResultList();
	  } 
	 
	 public List<Movie>  ViewByMovieRating(double movie_rating)
	 {
	    return manager.createQuery("select m from Movie m where m.rating=?1").setParameter(1, movie_rating).getResultList();
	 }
	 
	 public List<Movie>  ViewByMovieLang(String movie_lang) 
	 {
	    return manager.createQuery("select m from Movie m where m.language=?1").setParameter(1, movie_lang).getResultList();
	 }
	 
	 public List<Movie>  ViewByMovieGenre(String movie_genre) 
	 {    
	     return manager.createQuery("select m from Movie m where m.genre=?1").setParameter(1, movie_genre).getResultList();
	 }
}
	

