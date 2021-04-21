package hh.harjoitustyo.MovieApplication.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository <Movie, Long>{

	List<Movie> findByDirector(String director);
	long deleteByDirector(String director);
}
