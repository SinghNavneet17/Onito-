package com.onito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onito.dto.GenreDTO;
import com.onito.dto.MovieDTO;
import com.onito.dto.MovieRatingDTO;
import com.onito.exception.MoviesException;
import com.onito.model.Movies;
import com.onito.service.MoviesRatingService;

@RestController
@RequestMapping("/api/v1")
public class MoviesRatingController {
	
	@Autowired
	private MoviesRatingService moviesRatingService;
	
	@GetMapping("/longest-duration-movies")
	public ResponseEntity<List<MovieDTO>> registerUser( )throws MoviesException{
		
		List<MovieDTO> movies =moviesRatingService.getTopTenMovies();
		
		return new ResponseEntity<List<MovieDTO>>(movies, HttpStatus.CREATED);
	}
	
	@PostMapping("/new-movie")
	public ResponseEntity<String> addMovie(@RequestBody Movies movie){
		
		String message = moviesRatingService.saveMovie(movie);
		
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	
	@GetMapping("/top-rated-movies")
	public ResponseEntity<List<MovieRatingDTO>> getTopRatedMoviesList(){
		
		List<MovieRatingDTO>  movieRatingDTO = moviesRatingService.moviesWithRatingAboveSix();
		
		return new ResponseEntity<>(movieRatingDTO, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/genre-movies-with-subtotals")
	public ResponseEntity<List<GenreDTO>> getgenreMoviesWithSubtotals(){
		
		return new ResponseEntity<>(moviesRatingService.genreWiseMoviesWithSubtotals(), HttpStatus.OK);
	}
	
	@PostMapping("/update-runtime-minutes")
	public ResponseEntity<String> increaseRuntimeMinutes(){
		
		return new ResponseEntity<>(moviesRatingService.IncrementRuntimeMinutes(), HttpStatus.OK);
	}

}
