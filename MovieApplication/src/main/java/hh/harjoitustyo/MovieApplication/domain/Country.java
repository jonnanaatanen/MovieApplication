package hh.harjoitustyo.MovieApplication.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long countryid;
	@NotEmpty(message = "Country name can't be empty")
	private String countryname;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
	@JsonIgnoreProperties("country")
	private List<Movie> movies;
	
	public Country() {}
	
	public Country(String countryname) {
		super();
		this.countryname = countryname;
	}
	
	public Country(Long countryid, String countryname) {
		super();
		this.countryid = countryid;
		this.countryname = countryname;
	}

	public long getCountryid() {
		return countryid;
	}

	public void setCountryid(long countryid) {
		this.countryid = countryid;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Country [countryid=" + countryid + ", countryname=" + countryname + "]";
	}
	
}
