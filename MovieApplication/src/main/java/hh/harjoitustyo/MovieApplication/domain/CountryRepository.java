package hh.harjoitustyo.MovieApplication.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository <Country, Long>{
	List<Country> findByCountryname(String countryname);
	long deleteByCountryname(String countryname);
}
