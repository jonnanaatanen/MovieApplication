package hh.harjoitustyo.MovieApplication.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotEmpty(message= "Name can't be empty")
	private String name;
	@NotEmpty(message= "Director can't be empty")
	@Size(min=2, max=40)
	private String director;
	@NotNull
	@Size(min=3, max=80)
	private String language;
	@NotNull
	@Min(10)
	private int time;
	private String subtitles;
	
	@ManyToOne
	@JsonIgnoreProperties ("movies")
	@JoinColumn(name="categoryid")
	private Category category;
	
	@ManyToOne
	@JsonIgnoreProperties ("movies")
	@JoinColumn(name="countryid")
	private Country country;
	
	public Movie() {}

	public Movie(String name, String director, String language, int time, String subtitles, Category category, Country country) {
		super();
		this.name = name;
		this.director = director;
		this.language = language;
		this.time = time;
		this.subtitles = subtitles;
		this.category = category;
		this.country = country;
	}
	
	public Movie(Long movieid, String name, String director, String language, int time, String subtitles) {
		super();
		this.id = id;
		this.name = name;
		this.director = director;
		this.language = language;
		this.time = time;
		this.subtitles = subtitles;
	}
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getSubtitles() {
		return subtitles;
	}

	public void setSubtitles(String subtitles) {
		this.subtitles = subtitles;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", director=" + director + ", language=" + language + ", time="
				+ time + ", subtitles=" + subtitles + ", category=" + this.getCategory() + ", country=" + this.getCountry() + "]";
	}
	
}
