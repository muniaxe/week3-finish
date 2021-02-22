/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author tha
 */
public class MovieDTO {

    private long id;
    private String title;
    private int releaseYear;

    public static List<MovieDTO> getDtos(List<Movie> mvs) {
        List<MovieDTO> mvdtos = new ArrayList();
        mvs.forEach(rm -> mvdtos.add(new MovieDTO(rm)));
        return mvdtos;
    }

    public MovieDTO(Movie mv) {
        this.id = mv.getId();
        this.title = mv.getTitle();
        this.releaseYear = mv.getReleaseYear();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "MovieDTO{" + "id=" + id + ", title=" + title + ", releaseYear=" + releaseYear + '}';
    }

    public long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.title);
        hash = 23 * hash + this.releaseYear;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MovieDTO other = (MovieDTO) obj;
        if (this.releaseYear != other.releaseYear) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }
    
    

    
}
