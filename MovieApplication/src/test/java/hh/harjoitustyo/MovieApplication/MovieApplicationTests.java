package hh.harjoitustyo.MovieApplication;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.harjoitustyo.MovieApplication.controller.CategoryController;
import hh.harjoitustyo.MovieApplication.controller.CountryController;
import hh.harjoitustyo.MovieApplication.controller.MovieController;

@SpringBootTest
public class MovieApplicationTests {

	@Autowired
	private MovieController movieController;
	
	@Autowired
	private CategoryController categoryController;
	
	@Autowired
	private CountryController countryController;
	
	@Test
	public void contextLoad() {
		assertThat(movieController).isNotNull();
	}

	@Test
	public void contextLoads() {
		assertThat(categoryController).isNotNull();
	}
	
	@Test
	public void contextLoadss() {
		assertThat(countryController).isNotNull();
	}
}
