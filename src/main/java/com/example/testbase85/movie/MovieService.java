 package com.example.testbase85.movie;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.core.Response;
import java.util.List;

 /**
  * Hanterar logik mellan {@link MovieResource} och {@link MovieRepository}
  */

 @Singleton //Gör klassen till en bean så vi kan injicera den i andra klasser
 public class MovieService {

    @Inject
    private MovieRepository movieRepository; //injicera MovieRepository


     /**
      * Metod för att hämta ett specifik Movie med id från repoistory och skicka tillbaka den till Movie resource
      * @param id
      * @return Response 200 (Med movie objekt) eller 404 (not found)
      */
    public Response get(Long id){
        Movie movie = movieRepository.getById(id); // Kalla på repository med ID och hämta Movie objekt
        if (movie != null) // Kolla om objektet finns

            // Returnera 200 med det hämtade objektet
            return Response.status(Response.Status.OK).entity(movie).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build(); // Returnera 404
    }


     /**
      * Skickar lista av Movie objekt från repository till MovieResource inuti en response
      * @return Response 200(Ok) med List eller 404(not found)
      */
    public Response getAll(){
        List<Movie> returnList = movieRepository.getList(); // Kalla på repository för listan av objekt
        boolean isValid = !returnList.isEmpty(); // Kolla om listan innehåller objekt
        if (isValid){
            // Returnera 200 med List
            return Response.status(Response.Status.OK).entity(returnList).build();
        }
        else return Response.status(Response.Status.NOT_FOUND).build(); // Returnera 404
    }


     /**
      * Skickar vidare Movie objekt från resource till repository
      * @param movie
      */
    public void add(Movie movie){
        movieRepository.persist(movie); // Kallar på repository för att ta bort objektet
    }


     /**
      * @param id
      * @param movie
      * @return Response 200 eller 400 beroende på om Movie objektet existerar
      */
    public Response update(Long id, Movie movie){
        boolean isValid = movieRepository.getById(id) != null; // Kolla om Movie objektet finns
        if (isValid){
            movie.setId(id);
            movieRepository.update(movie); // Kalla på repository för att uppdatera objektet
            return Response.status(Response.Status.OK).build(); // returnera 200 ok
        }
        else
            return Response.status(Response.Status.NOT_FOUND).build(); // returnera 404 not found
    }


    /**
     * Tar in id från movieResource och försöker att ta bort det från databasen
     * @param id
     * @return Response 200 eller 400 beroende på om Movie objektet existerar
     */
    public Response delete(Long id){
        Movie toDelete = movieRepository.getById(id); // Kolla om Movie objektet finns
        if (toDelete!=null){
            movieRepository.delete(toDelete); // Kalla på repository för att ta bort objektet
            return Response.status(Response.Status.OK).build(); // returnera 200 ok
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build(); // returnera 404 not found
        }
    }

}