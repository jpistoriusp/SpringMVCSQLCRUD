package com.skilldistillery.data;

public class Movie {

	private String name;
	private String year;
	private String director;
	
	public Movie() {
	}
	
	public Movie(String name, String year) {
		this.name = name;
		this.year = year;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movie [name=");
		builder.append(name);
		builder.append(", year=");
		builder.append(year);
		builder.append(", director=");
		builder.append(director);
		builder.append("]");
		return builder.toString();
	}
}
