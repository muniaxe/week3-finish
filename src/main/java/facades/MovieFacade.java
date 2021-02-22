package facades;

import dtos.MovieDTO;
import entities.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private MovieFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getMovieFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public MovieDTO create(Movie mv){
        Movie tmpMovie = new Movie(mv.getReleaseYear(), mv.getTitle(), mv.getActors());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(tmpMovie);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new MovieDTO(tmpMovie);
    }
    public MovieDTO getMovieById(long id){
        EntityManager em = emf.createEntityManager();
        return new MovieDTO(em.find(Movie.class, id));
    }
    
    public long getMovieCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long movieCount = (long)em.createQuery("SELECT COUNT(r) FROM Movie r").getSingleResult();
            return movieCount;
        }finally{  
            em.close();
        }
        
    }
    
    public List<MovieDTO> getAllMovies(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Movie> query = em.createQuery("SELECT r FROM Movie r", Movie.class);
        List<Movie> rms = query.getResultList();
        return MovieDTO.getDtos(rms);
    }
    
    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        MovieFacade fe = getMovieFacade(emf);
        fe.getAllMovies().forEach(dto->System.out.println(dto));
    }
    
    public List<MovieDTO> getMoviesByTitle(String title) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<MovieDTO> q = em.createQuery("SELECT m FROM Movie m WHERE m.title LIKE :title", MovieDTO.class);
        q.setParameter("title", "%" + title + "%");
        List<MovieDTO> movies = q.getResultList();
        return movies;
    }

}
