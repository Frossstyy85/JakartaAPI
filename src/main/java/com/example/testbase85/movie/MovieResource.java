package com.example.testbase85.movie;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Consumes(MediaType.APPLICATION_JSON) // Alla metoder returnerar text i json format
@Produces(MediaType.APPLICATION_JSON) // Alla metoder tar in text i json format
@Path("/movies") // Endpoint för att komma åt metoderna i klassen
public class MovieResource {

    @Inject // Injciera MovieService så den kan användas utan att behöva skapa en instans
    private MovieService movieService;


    /**
     * Endpoint för att hämta alla Movies från databasen
     * @return response från movieService (200 ok eller 404 not found)
     */
    @GET
    public Response getAll(){
        return movieService.getAll();
    }

    /**
     * Endppint för att hämta en specifik objekt med ID
     * @param id
     * @return response från movieService (200 ok eller 404 not found)
     */
    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id){
        return movieService.get(id);
    }

    /**
     * Endpoint för att lägga till ett nytt objekt i databasen
     * @param movie
     */
    @POST
    public void add(Movie movie){
        movieService.add(movie);
    }

    /**
     * Endpoint för att uppdatera ett objekt med ID
     * @param id
     * @param movie
     * @return response från movieService (200 ok eller 404 not found)
     */
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Movie movie){
        return movieService.update(id, movie);
    }

    /**
     * Endpoint för att ta bort object med ID
     * @param id
     * @return response från movieService (200 ok eller 404 not found)
     */
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        return movieService.delete(id);
    }

}