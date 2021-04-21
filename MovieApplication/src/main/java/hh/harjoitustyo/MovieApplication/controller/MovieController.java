package hh.harjoitustyo.MovieApplication.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import hh.harjoitustyo.MovieApplication.domain.CategoryRepository;
import hh.harjoitustyo.MovieApplication.domain.CountryRepository;
import hh.harjoitustyo.MovieApplication.domain.Movie;
import hh.harjoitustyo.MovieApplication.domain.MovieRepository;



@Controller
public class MovieController {

	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private CategoryRepository categoryrepository;
	
	@Autowired
	private CountryRepository countryrepository;
	
	//kirjautuminen
	@RequestMapping(value="/login")
		public String login() {
			return "login";
		}    
	
	//elokuvalistasivu
	@RequestMapping(value= "/movielist", method = RequestMethod.GET)
	public String getMovies(Model model) {
		List<Movie> movies = (List<Movie>) repository.findAll(); // haetaan elokuvat tietokannasta
		model.addAttribute("movies", movies); // välitetään elokuvalista html-templatelle model olion avulla
		return "movielist"; 
	}

	 //palauttaa elokuvan lisäyslomakkeen
    @RequestMapping(value = "/addmovie", method = RequestMethod.GET)
    public String addMovie(Model model){
    	model.addAttribute("movie", new Movie());
    	model.addAttribute("categories", categoryrepository.findAll());
    	model.addAttribute("countries", countryrepository.findAll());
        return "addmovie";
    }     
    //vastaanottaa elokuvalomakkeen tiedot ja tallettaa ne tietokantaan
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Movie movie, BindingResult bindingresult, Model model) {
		if (bindingresult.hasErrors()) {
			if (movie.getId() == null) { 
				
				//välitetään kategorialista tietokannasta tymeleaf-templatelle
				model.addAttribute("categories", categoryrepository.findAll());
				model.addAttribute("countries", countryrepository.findAll());
				return "addmovie"; //addmovie.html
				
			} else {
				model.addAttribute("categories", categoryrepository.findAll());
				model.addAttribute("countries", countryrepository.findAll());
				return "editmovie"; //editmovie.html
			}
		} else {
			repository.save(movie);
			return "redirect:movielist";
		}
	}
    //poistaa elokuvan id-arvon perusteella tietokannasta
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    //suojaa delete-toiminto metoditasolla @PreAuthorize-annotaatiolla vain ADMIN-roolin omaaville käyttäjille
   @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteMovie(@PathVariable(value="id") Long movieId, Model model) {
    	repository.deleteById(movieId);
        return "redirect:../movielist";
    } 
    //elokuvan tietojen muokkaus
    @RequestMapping(value = "/edit/{id}", method= RequestMethod.GET)
    public String editMovie(@PathVariable(value="id") Long movieId, Model model){
    	model.addAttribute("categories", categoryrepository.findAll());
    	model.addAttribute("countries", countryrepository.findAll());
    	model.addAttribute("movie", repository.findById(movieId));
    	return "editmovie"; //editmovie.html
    }
 // RESTful service to get all movies
    @RequestMapping(value="/movies", method = RequestMethod.GET)
    public @ResponseBody List<Movie> movieListRest() {	
        return (List<Movie>) repository.findAll();
    }    

	// RESTful service to get movie by id
    @RequestMapping(value="/movies/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Movie> findMovieRest(@PathVariable("id") Long movieId) {	
    	return repository.findById(movieId);
    } 
	
    // RESTful service to save new movie
    @RequestMapping(value="/movies", method = RequestMethod.POST)
    public @ResponseBody Movie saveMovieRest(@RequestBody Movie movie) {	
    	return repository.save(movie);
    }
}
	

