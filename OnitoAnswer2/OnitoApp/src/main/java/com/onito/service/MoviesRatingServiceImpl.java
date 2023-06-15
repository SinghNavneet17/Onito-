package com.onito.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onito.dto.GenreDTO;
import com.onito.dto.MovieDTO;
import com.onito.dto.MovieRatingDTO;
import com.onito.exception.MoviesException;
import com.onito.model.Movies;
import com.onito.model.Rating;
import com.onito.repository.MoviesRepo;
import com.onito.repository.RatingRepo;

@Service
public class MoviesRatingServiceImpl implements MoviesRatingService {
	
	@Autowired
	private MoviesRepo moviesRepo;
	
	
	@Override
	public List<MovieDTO> getTopTenMovies() throws MoviesException {

		return moviesRepo.findTopTenMovies();

	}

	
	@Override
	public String saveMovie(Movies movies) {
		
      Optional<Movies> optional =	moviesRepo.findById(movies.getTconst());
		
		if(optional.isPresent()) {
			
			throw new MoviesException("Movie Already Registered..");
			
		}else {
			
			moviesRepo.save(movies);
			
			return "success";
	    }
	}
	
	@Override
	public List<MovieRatingDTO> moviesWithRatingAboveSix() throws MoviesException {
		
		List<MovieRatingDTO> movieList = moviesRepo.findTopMoviesAboveSix();
		
		return movieList;
		
     }


	@Override
	public List<GenreDTO> genreWiseMoviesWithSubtotals() {
		
		List<GenreDTO> movieList = moviesRepo.findAllGenreWiseMoviesWithSubtotals();
		
		return movieList;
		
	}


	@Override
	public String IncrementRuntimeMinutes() {
		
		moviesRepo.IncreaseRuntimeMinutes();
		
		return "Time incremented Successfully..";
	}


	


	

}
