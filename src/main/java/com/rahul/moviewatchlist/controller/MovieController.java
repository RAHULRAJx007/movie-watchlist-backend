package com.rahul.moviewatchlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rahul.moviewatchlist.dto.MovieRequest;
import com.rahul.moviewatchlist.dto.MovieResponse;
import com.rahul.moviewatchlist.service.MovieService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<MovieResponse> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable Long id) {

        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PostMapping
    public ResponseEntity<MovieResponse> addMovie(
            @Valid @RequestBody MovieRequest request) {

        return ResponseEntity.ok(movieService.addMovie(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> updateMovie(
            @PathVariable Long id,
            @Valid @RequestBody MovieRequest request) {

        return ResponseEntity.ok(movieService.updateMovie(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {

        movieService.deleteMovie(id);

        return ResponseEntity.ok("Movie deleted successfully");
    }
    
    @GetMapping("/search")
    public List<MovieResponse> searchMovies(
            @RequestParam String title) {

        return movieService.searchMovies(title);
    }
    
    @GetMapping("/status")
    public List<MovieResponse> filterByStatus(
            @RequestParam String watchStatus) {

        return movieService.filterByStatus(watchStatus);
    }
}