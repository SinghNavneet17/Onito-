package com.onito.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onito.dto.GenreDTO;
import com.onito.dto.MovieDTO;
import com.onito.dto.MovieRatingDTO;
import com.onito.exception.MoviesException;
import com.onito.model.Movies;
@Service
public interface MoviesRatingService {
	
	List<MovieDTO> getTopTenMovies() throws MoviesException;
	
	String saveMovie(Movies movies);
	
	List<MovieRatingDTO> moviesWithRatingAboveSix();
	
	List<GenreDTO> genreWiseMoviesWithSubtotals();
	
	String IncrementRuntimeMinutes();
}
