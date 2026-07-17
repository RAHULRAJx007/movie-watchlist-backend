package com.rahul.moviewatchlist.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.moviewatchlist.dto.MovieRequest;
import com.rahul.moviewatchlist.dto.MovieResponse;
import com.rahul.moviewatchlist.entity.Movie;
import com.rahul.moviewatchlist.exception.ResourceNotFoundException;
import com.rahul.moviewatchlist.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieResponse> getAllMovies() {

        return movieRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public MovieResponse getMovieById(Long id) {

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Movie not found with id " + id));

        return convertToResponse(movie);
    }

    public MovieResponse addMovie(MovieRequest request) {

        Movie movie = new Movie();

        movie.setTitle(request.getTitle());
        movie.setGenre(request.getGenre());
        movie.setRating(request.getRating());
        movie.setWatchStatus(request.getWatchStatus());
        movie.setReleaseYear(request.getReleaseYear());
        movie.setDescription(request.getDescription());

        return convertToResponse(movieRepository.save(movie));
    }

    public MovieResponse updateMovie(Long id, MovieRequest request) {

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Movie not found with id " + id));

        movie.setTitle(request.getTitle());
        movie.setGenre(request.getGenre());
        movie.setRating(request.getRating());
        movie.setWatchStatus(request.getWatchStatus());
        movie.setReleaseYear(request.getReleaseYear());
        movie.setDescription(request.getDescription());

        return convertToResponse(movieRepository.save(movie));
    }

    public void deleteMovie(Long id) {

        if (!movieRepository.existsById(id)) {
            throw new ResourceNotFoundException("Movie not found with id " + id);
        }

        movieRepository.deleteById(id);
    }

    private MovieResponse convertToResponse(Movie movie) {

        return new MovieResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getGenre(),
                movie.getRating(),
                movie.getWatchStatus(),
                movie.getReleaseYear(),
                movie.getDescription());
    }
    
    public List<MovieResponse> searchMovies(String title) {

        return movieRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }
    
    public List<MovieResponse> filterByStatus(String watchStatus) {

        return movieRepository.findByWatchStatusIgnoreCase(watchStatus)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }
}