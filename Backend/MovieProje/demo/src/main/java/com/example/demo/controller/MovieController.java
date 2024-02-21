package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movie;
import com.example.demo.Service.MovieService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class MovieController {
    

    private MovieService movieService;
    

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/product")
    public ResponseEntity<Movie>postProduct(@RequestBody Movie movie)
    {
        if(movieService.saveProduct(movie)==true)
        {
            return new ResponseEntity<>(movie,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Movie> getProduct(@PathVariable("id") int id)
    {
        Movie p=movieService.getProduct(id);
        if(p==null)
        {
            return new ResponseEntity<>(p,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
       
        
    }

    @GetMapping("/products")
    public ResponseEntity<List> getProducts()
    {
        List<Movie>b=movieService.getAllProduct();
        if(b.size()==0)
        {
            return new ResponseEntity<>(b,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(b,HttpStatus.OK);
    }

    @PutMapping("products/{id}")
    public ResponseEntity<Movie> putMethodName(@PathVariable("id") int id, @RequestBody  Movie movie)
    {
        if(movieService.updateProduct(id,movie)==true)
        {
            return new ResponseEntity<>(movie,HttpStatus.OK);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<Movie>delete(@PathVariable int id)
    {
        if(movieService.deleteProduct(id)==true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    
}
