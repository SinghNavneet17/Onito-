package com.onito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onito.dto.GenreDTO;
import com.onito.dto.MovieDTO;
import com.onito.dto.MovieRatingDTO;
import com.onito.model.Movies;

@Repository
public interface MoviesRepo extends JpaRepository<Movies, String>{

	@Query("select new com.onito.dto.MovieDTO(m.tconst, m.primaryTitle, m.runtimeMinutes, m.genres) from Movies m ORDER BY m.runtimeMinutes DESC LIMIT 10")
	List<MovieDTO> findTopTenMovies();
//	List<MovieDTO> findTop10ByOrderByRuntimeMinutesDesc();
	List<Movies> findByAverageRatingGreaterThan(Double averageRating);
	
	
	@Query("select new com.onito.dto.MovieRatingDTO(m.tconst, m.primaryTitle, m.genres, r.averageRating) FROM Movies m JOIN m.ratings r WHERE r.averageRating > 6.0 ORDER BY r.averageRating DESC")
	List<MovieRatingDTO> findTopMoviesAboveSix();
	
	@Query("select new com.test.dto.GenreMoviesWithSubtotals(m.genres, m.primaryTitle, r.numVotes, SUM(r.numVotes)) FROM Movies m JOIN m.ratings r GROUP BY m.genres")
	List<GenreDTO> findAllGenreWiseMoviesWithSubtotals();
	
	@Modifying
	@Query(value = "update movies m set runtime_minutes = \r\n"
			+ "case \r\n"
			+ "when genres = \"Documentary\" then runtime_minutes + 15\r\n"
			+ "when genres = \"Action\" then runtime_minutes + 30\r\n"
			+ "else runtime_minutes + 45\r\n"
			+ "end ;", nativeQuery = true)
	void IncreaseRuntimeMinutes();
}
