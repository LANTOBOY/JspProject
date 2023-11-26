package com.data.api;

import java.util.ArrayList;

public class MovieDTO {
	private String movie_id;
	private String movie_origin_title;
	private String movie_title;
	private String movie_overview;
	private String movie_posterPath;
	private String movie_backdropPath;
	private String move_release_date;
	private String logo_path;
	private String homepage;
	private String tagline;
	private ArrayList<String> genre_ids = new ArrayList<String>();
	
	
	
	public String getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_origin_title() {
		return movie_origin_title;
	}
	public void setMovie_origin_title(String movie_origin_title) {
		this.movie_origin_title = movie_origin_title;
	}
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public String getMovie_overview() {
		return movie_overview;
	}
	public void setMovie_overview(String movie_overview) {
		this.movie_overview = movie_overview;
	}
	public String getMovie_posterPath() {
		return movie_posterPath;
	}
	public void setMovie_posterPath(String movie_posterPath) {
		this.movie_posterPath = movie_posterPath;
	}
	public String getMove_release_date() {
		return move_release_date;
	}
	public void setMove_release_date(String move_release_date) {
		this.move_release_date = move_release_date;
	}
	public String getLogo_path() {
		return logo_path;
	}
	public void setLogo_path(String logo_path) {
		this.logo_path = logo_path;
	}
	public ArrayList<String> getGenre_ids() {
		return genre_ids;
	}
	public void setGenre_ids(ArrayList<String> genre_ids) {
		this.genre_ids = genre_ids;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getTagline() {
		return tagline;
	}
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	public String getMovie_backdropPath() {
		return movie_backdropPath;
	}
	public void setMovie_backdropPath(String movie_backdropPath) {
		this.movie_backdropPath = movie_backdropPath;
	}
	
	
	
	
	
	
}




