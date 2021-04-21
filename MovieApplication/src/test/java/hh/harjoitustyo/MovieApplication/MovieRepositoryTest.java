package hh.harjoitustyo.MovieApplication;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import hh.harjoitustyo.MovieApplication.domain.Category;
import hh.harjoitustyo.MovieApplication.domain.CategoryRepository;
import hh.harjoitustyo.MovieApplication.domain.Country;
import hh.harjoitustyo.MovieApplication.domain.CountryRepository;
import hh.harjoitustyo.MovieApplication.domain.Movie;
import hh.harjoitustyo.MovieApplication.domain.MovieRepository;
import hh.harjoitustyo.MovieApplication.domain.User;
import hh.harjoitustyo.MovieApplication.domain.UserRepository;



public class MovieRepositoryTest {

    @Autowired
    private MovieRepository repository;
    
    @Autowired
    private CategoryRepository crepository;
    
    @Autowired
    private CountryRepository corepository;
    
    @Autowired
    private UserRepository urepository;

    @Test  // testataan findByDirector()-metodin toimivuutta
    public void findBookByDirector() {
        List<Movie> movies = repository.findByDirector("James Cameron");
        
        assertThat(movies).hasSize(1);
        assertThat(movies.get(0).getName()).isEqualTo("Titanic");
    }
    
    @Test // testataan save()-metodin toimivuutta
    public void createNewMovie() {
    	Movie movie = new Movie("Testileffa", "Tero Testaaja", "English", 100, "Finnish", null, null);
    	repository.save(movie);
    	assertThat(movie.getId()).isNotNull();
    }
    
    @Test // testataan delete()-metodin toimivuutta
    public void deleteMovieTest() {
    	long deleteMovies = repository.deleteByDirector("Hayo Miyazaki");
    	assertThat(deleteMovies).isEqualTo(1);
    }

	@Test //save
	public void createNewCategory() {
		Category category = new Category("Horror");
		crepository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}
	
	@Test //search
	public void findCategoryByName() {
		List<Category> categories = crepository.findByCname("Drama");
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getCname()).isEqualTo("Drama");
	}
	
	@Test //delete
	public void deleteCategoryByCname() {
		long deleteCategories = crepository.deleteByCname("Fantasy");
		assertThat(deleteCategories).isEqualTo(1);
	}
	
	@Test //save
	public void createNewCountry() {
		Country country = new Country("Spain");
		corepository.save(country);
		assertThat(country.getCountryid()).isNotNull();
	}
	
	@Test //search
	public void findCountryByName() {
		List<Country> countries = corepository.findByCountryname("USA");
		assertThat(countries).hasSize(1);
		assertThat(countries.get(0).getCountryname()).isEqualTo("USA");
	}
	
	@Test //delete
	public void deleteCountryByCountryname() {
		long deleteCountries = corepository.deleteByCountryname("France");
		assertThat(deleteCountries).isEqualTo(1);
	}
	
	@Test //save
	public void createNewUser() {
		User user = new User("user2", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user2@email.com","USER");
		urepository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test //search
	public void findUserByName() {
		User user = urepository.findByUsername("user");
		assertThat(user.getUsername()).isEqualTo("user");
	}
	
	@Test //delete
	public void deleteUserByName() {
		long deleteUser = urepository.deleteByUsername("user");
		assertThat(deleteUser).isEqualTo(1);
	}
}
