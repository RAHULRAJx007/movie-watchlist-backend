package com.rahul.moviewatchlist.dto;

public class MovieResponse {

    private Long id;
    private String title;
    private String genre;
    private Integer rating;
    private String watchStatus;
    private Integer releaseYear;
    private String description;

    public MovieResponse() {
    }

    public MovieResponse(Long id, String title, String genre,
                         Integer rating, String watchStatus,
                         Integer releaseYear, String description) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.watchStatus = watchStatus;
        this.releaseYear = releaseYear;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getWatchStatus() {
        return watchStatus;
    }

    public void setWatchStatus(String watchStatus) {
        this.watchStatus = watchStatus;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}