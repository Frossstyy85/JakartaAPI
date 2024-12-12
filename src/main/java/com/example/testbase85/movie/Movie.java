package com.example.testbase85.movie;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "MOVIES")
public class Movie {


    @GeneratedValue
    @Id
    private Long id;

    private String title;
    private String genre;
    private String description;
    private String director;
    private Integer releaseYear;


    public Movie(String director, Integer releaseYear, String description, String genre, String title) {
        this.director = director;
        this.releaseYear = releaseYear;
        this.description = description;
        this.genre = genre;
        this.title = title;
    }

    public Movie() {
    }
//

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}