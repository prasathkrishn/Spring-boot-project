package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Movie;
import com.example.demo.Repository.MovieRepo;

@Service
public class MovieService {
    

    private MovieRepo movieRepo;
    

    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }
    public boolean saveProduct(Movie movie)
    {
        try {
                System.out.println("Posted");
                movieRepo.save(movie);
                return true;
            } 
            catch (Exception e) {
                System.out.println("NOTPosted");
               return false;
            }
        
    }
    public Movie getProduct(int id)
    {
        return movieRepo.findById(id).orElse(null);
    }
   

    public List<Movie>getAllProduct()
    {
        return movieRepo.findAll();
    }

    public boolean updateProduct(int id,Movie movie)
    {
        if(this.getProduct(id)==null)
        {
            return false;
        }
        try {
                    movieRepo.save(movie);
            } 
            catch (Exception e) {
               return false;
            }
            return true;
        
    }

    public boolean deleteProduct(int id)
    {
        if(this.getProduct(id)==null)
        {
            return false;
        }
        try {
                movieRepo.deleteById(id);
            } 
            catch (Exception e) {
               return false;
            }
            return true;
    }

}
