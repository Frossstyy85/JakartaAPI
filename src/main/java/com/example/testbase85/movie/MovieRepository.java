package com.example.testbase85.movie;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Transactional // Klass annotation så alla metoder är transactional (Pratar med databasen)
@Singleton //Gör klassen till en bean så vi kan injicera den i andra klasser
public class MovieRepository {

    @PersistenceContext // Injicera EntityManager
    private EntityManager entityManager; // EntityManager för att vi kan prata med databasen med java syntax

    /**
     * Hämtar ett objekt i databasen med ID
     * @param id
     * @return Movie objekt
     */
    public Movie getById(Long id){
        Movie movie = entityManager.find(Movie.class, id);
        return movie;
    }

    /**
     * Hämtar en lista av alla objekt i databasen
     * @return Lista av Movie objekt
     */
    public List<Movie> getList() {
        List<Movie>  returnList = entityManager.createNativeQuery("SELECT * FROM MOVIES").getResultList();
        return returnList;
    }

    /**
     * Lägger till ett objekt i databasen
     * @param movie
     */
    public void persist(Movie movie){
        entityManager.persist(movie);
    }

    /**
     * Uppdaterar ett objekt i databasen
     * @param movie
     */
    public void update(Movie movie){
        entityManager.merge(movie);
    }


    /**
     * Tar bort ett objekt från databasen
     * @param movie
     */
    public void delete(Movie movie){
        entityManager.remove(entityManager.merge(movie));
    }


}

