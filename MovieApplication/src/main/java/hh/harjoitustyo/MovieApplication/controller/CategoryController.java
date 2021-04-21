package hh.harjoitustyo.MovieApplication.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.harjoitustyo.MovieApplication.domain.Category;
import hh.harjoitustyo.MovieApplication.domain.CategoryRepository;

@Controller
public class CategoryController {

	
	@Autowired
	private CategoryRepository cRepository;
	
	@RequestMapping(value="/categorylist", method=RequestMethod.GET)
	public String categoryList(Model model) {
		model.addAttribute("categories", cRepository.findAll());
		return "categorylist";
	}
	
    @RequestMapping(value="/addcategory")
    public String createCategory(Model model){
    model.addAttribute("category", new Category());
    return "addcategory";
    }
    
    @RequestMapping(value="/savecategory", method=RequestMethod.POST)
    public String save(@Valid Category category, BindingResult bindingresult) {
    	if (bindingresult.hasErrors()) {
			return "addcategory";
    	}
    	cRepository.save(category);
    	return "redirect:categorylist";
    }
}
