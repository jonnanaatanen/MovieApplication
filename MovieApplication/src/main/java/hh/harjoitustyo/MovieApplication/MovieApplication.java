package hh.harjoitustyo.MovieApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.harjoitustyo.MovieApplication.domain.Category;
import hh.harjoitustyo.MovieApplication.domain.CategoryRepository;
import hh.harjoitustyo.MovieApplication.domain.Country;
import hh.harjoitustyo.MovieApplication.domain.CountryRepository;
import hh.harjoitustyo.MovieApplication.domain.Movie;
import hh.harjoitustyo.MovieApplication.domain.MovieRepository;
import hh.harjoitustyo.MovieApplication.domain.User;
import hh.harjoitustyo.MovieApplication.domain.UserRepository;



@SpringBootApplication
public class MovieApplication {

	private static final Logger log =
			LoggerFactory.getLogger(MovieApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(CategoryRepository cRepository,MovieRepository repository,
			UserRepository urepository, CountryRepository coRepository) {
	return (args) -> {
	
	 Country country1 = new Country("USA");	
	 Country country2 = new Country("France");	
	 Country country3 = new Country("Japan");
	 
	 coRepository.save(country1);
	 coRepository.save(country2);
	 coRepository.save(country3);
		
	 Category category1 = new Category("Drama");
	 Category category2 = new Category("Action");
	 Category category3 = new Category("Fantasy");
	 
	 cRepository.save(category1);
	 cRepository.save(category2);
	 cRepository.save(category3);
		
	 Movie m1 = new Movie("Titanic", "James Cameron", "English", 194, "Finnish, Swedish", category1, country1);
	 Movie m2 = new Movie("Taken", "Pierre Morel", "English, French, Albanian, Arabic", 91, "Finnish", category2, country2);
	 Movie m3 = new Movie("My Neighbor Totoro", "Hayo Miyazaki", "Japan", 86, "English, Finnish", category3, country3);
	
	repository.save(m1);
	repository.save(m2);
	repository.save(m3);
	
	// Create users: 
	 User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@user.com", "USER");
	 User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@admin.com", "ADMIN");
	 urepository.save(user1);
	 urepository.save(user2);
	
	log.info("fetch all movies");
	for (Movie movie : repository.findAll()) {
		log.info(movie.toString());
	}
	log.info("fetch all categories");
	for (Category category : cRepository.findAll()) {
		log.info(category.toString());
	}
	};
	}
}

