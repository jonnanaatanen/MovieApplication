package hh.harjoitustyo.MovieApplication.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.harjoitustyo.MovieApplication.domain.Country;
import hh.harjoitustyo.MovieApplication.domain.CountryRepository;


@Controller
public class CountryController {

	@Autowired
	private CountryRepository coRepository;
	
	@RequestMapping(value="/countrylist", method=RequestMethod.GET)
	public String countryList(Model model) {
		model.addAttribute("countries", coRepository.findAll());
		return "countrylist";
	}
	
    @RequestMapping(value="/addcountry")
    public String createCountry(Model model){
    model.addAttribute("country", new Country());
    return "addcountry";
    }
    
    @RequestMapping(value="/savecountry", method=RequestMethod.POST)
    public String save(@Valid Country country, BindingResult bindingresult) {
    	if (bindingresult.hasErrors()) {
			return "addcountry";
    	}
    	coRepository.save(country);
    	return "redirect:countrylist";
    }
}

