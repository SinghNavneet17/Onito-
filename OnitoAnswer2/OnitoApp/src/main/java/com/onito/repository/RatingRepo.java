package com.onito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onito.model.Movies;
import com.onito.model.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating, String>{

	
	
}
