package com.rahul.moviewatchlist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.moviewatchlist.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByTitleContainingIgnoreCase(String title);
    
    List<Movie> findByWatchStatusIgnoreCase(String watchStatus);

}