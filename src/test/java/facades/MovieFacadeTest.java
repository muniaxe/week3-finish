package facades;

import dtos.MovieDTO;
import utils.EMF_Creator;
import entities.Movie;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class MovieFacadeTest {

    private static EntityManagerFactory emf;
    private static MovieFacade facade;
    Movie mv1;
    Movie mv2;
    Movie mv3;
    public MovieFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = MovieFacade.getMovieFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        mv1 = new Movie(2020, "AA", new String[]{"A", "B"});
        mv2 = new Movie(2019, "BB", new String[]{"C", "D"});
        mv3 = new Movie(2018, "AA and BB", new String[]{"E", "F"});
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Movie.deleteAllRows").executeUpdate();
            em.persist(mv1);
            em.persist(mv2);
            em.persist(mv3);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    /**
     * Test of create method, of class MovieFacade.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Movie mv = new Movie(2020, "AA", new String[] {"A", "B"});
        MovieDTO result = facade.create(mv);
        MovieDTO expResult = facade.getMovieById(result.getId());
        assertEquals(expResult.getTitle(), result.getTitle());
        assertEquals(expResult.getId(), result.getId());
    }

    /**
     * Test of getMovieById method, of class MovieFacade.
     */
    @Test
    public void testGetMovieById() {
        System.out.println("getById");
        long id = mv1.getId();
        MovieDTO expResult = new MovieDTO(mv1);
        MovieDTO result = facade.getMovieById(id);
        assertEquals(expResult.getId(), result.getId());
    }

    /**
     * Test of getMovieCount method, of class MovieFacade.
     */
    @Test
    public void testGetMovieCount() {
        System.out.println("getMovieCount");
        long expResult = 3;
        long result = facade.getMovieCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMoviesByTitle method, of class MovieFacade.
     */
    @Test
    public void testGetMoviesByTitle() {
        System.out.println("getMoviesByTitle");
        String title = "AA";
        List<MovieDTO> expResult = new ArrayList<>();
        expResult.add(new MovieDTO(mv1));
        expResult.add(new MovieDTO(mv3));
        List<MovieDTO> result = facade.getMoviesByTitle(title);
        assertEquals(expResult.toArray().length, result.toArray().length);
    }

}
