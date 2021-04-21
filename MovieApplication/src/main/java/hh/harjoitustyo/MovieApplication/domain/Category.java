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
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long categoryid;
	@NotEmpty(message = "Category name can't be empty")
	private String cname;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	@JsonIgnoreProperties("gategory")
	private List<Movie> movies;
	
	public Category() {}
	
	public Category(String cname) {
		super();
		this.cname = cname;
	}
	
	public Category(Long categoryid, String cname) {
		super();
		this.categoryid = categoryid;
		this.cname = cname;
	}

	public long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", cname=" + cname + "]";
	}
	
}
