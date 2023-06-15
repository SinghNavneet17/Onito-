package com.onito.model;

import jakarta.persistence.Entity;

import jakarta.persistence.OneToOne;

@Entity
public class Movies {
	
	@jakarta.persistence.Id
	private String tconst;
	
	private String titleType;

	private String primaryTitle;
	
	private Integer runtimeMinutes;
	
	private String genres;
	
	@OneToOne
	private Rating rating;
	
	public Movies() {
		super();
	}

	public Movies(String tconst, String titleType, String primaryTitle, Integer runtimeMinutes, String genres) {
		super();
		this.tconst = tconst;
		this.titleType = titleType;
		this.primaryTitle = primaryTitle;
		this.runtimeMinutes = runtimeMinutes;
		this.genres = genres;
	}

	public String getTconst() {
		return tconst;
	}

	public void setTconst(String tconst) {
		this.tconst = tconst;
	}

	public String getTitleType() {
		return titleType;
	}

	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}

	public String getPrimaryTitle() {
		return primaryTitle;
	}

	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}

	public Integer getRuntimeMinutes() {
		return runtimeMinutes;
	}

	public void setRuntimeMinutes(Integer runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	@Override
	public String toString() {
		return "Movies [tconst=" + tconst + ", titleType=" + titleType + ", primaryTitle=" + primaryTitle
				+ ", runtimeMinutes=" + runtimeMinutes + ", genres=" + genres + "]";
	}
	
	
}
