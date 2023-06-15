package com.onito.dto;

public class GenreDTO {
	
    private String genres;
	
	private String primaryTitles;
	
	private long numVotes;
	
	private long total;

	public GenreDTO() {
		super();
	}

	public GenreDTO(String genres, String primaryTitles, long numVotes, long total) {
		super();
		this.genres = genres;
		this.primaryTitles = primaryTitles;
		this.numVotes = numVotes;
		this.total = total;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getPrimaryTitles() {
		return primaryTitles;
	}

	public void setPrimaryTitles(String primaryTitles) {
		this.primaryTitles = primaryTitles;
	}

	public long getNumVotes() {
		return numVotes;
	}

	public void setNumVotes(long numVotes) {
		this.numVotes = numVotes;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "GenreDTO [genres=" + genres + ", primaryTitles=" + primaryTitles + ", numVotes=" + numVotes + ", total="
				+ total + "]";
	}
	
}
