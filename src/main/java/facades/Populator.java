/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Movie;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        MovieFacade mf = MovieFacade.getMovieFacade(emf);
        mf.create(new Movie(1977, "Star Wars", new String[] {"Mark Hamill", "Carrie Fisher", "Harrison Ford"}));
        mf.create(new Movie(1984, "Terminator", new String[] {"Arnold Schwarzenegger", "Linda Hamilton", "Michael Biehn"}));
        mf.create(new Movie(1986, "Labyrinth", new String[] {"David Bowie", "Jennifer Connely"}));
        
    }
    
    public static void main(String[] args) {
        populate();
    }
}
