package com.onito.model;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;

@Entity
public class Rating {
	
	@jakarta.persistence.Id
	private String tconst;
	
	private Double averageRating;
	
	private Integer numVotes;
	
	@OneToOne(mappedBy = "rating",fetch = FetchType.EAGER)
	private Movies movies;

	public Rating() {
		super();
	}

	public Rating(String tconst, Double averageRating, Integer numVotes) {
		super();
		this.tconst = tconst;
		this.averageRating = averageRating;
		this.numVotes = numVotes;
	}

	public String getTconst() {
		return tconst;
	}

	public void setTconst(String tconst) {
		this.tconst = tconst;
	}

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

	public Integer getNumVotes() {
		return numVotes;
	}

	public void setNumVotes(Integer numVotes) {
		this.numVotes = numVotes;
	}

	@Override
	public String toString() {
		return "Rating [tconst=" + tconst + ", averageRating=" + averageRating + ", numVotes=" + numVotes + "]";
	}
	
	
}
