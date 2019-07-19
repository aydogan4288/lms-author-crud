package com.smoothstack.spring_app.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smoothstack.spring_app.model.Author;
import com.smoothstack.spring_app.service.AuthorService;

@Controller
public class RouteController {
	
	private AuthorService authorService;
	
	public RouteController(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@GetMapping("/")
	public String dashboard(Model model) {
		List<Author> authors = authorService.findAllAuthors();
		model.addAttribute("authors", authors);
		
		return "index.jsp";
	}
	
	@GetMapping("/new")
	public String newAuthor() {
		
		return "new_author.jsp";
	}
	
	@PostMapping("/create_author")
	public String createAuthor(@Valid @ModelAttribute("author") Author author, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Problem found in new idea.");
			return "redirect:/new_author";
		}
		else {
			System.out.println("Creating new author");
			System.out.println(author.getName());
			
			authorService.createAuthor(author);
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value="/remove_author/{id}", method=RequestMethod.DELETE)
	public String removeAuthor(@PathVariable("id") int id) {
		Author a = authorService.findById(id);
		authorService.deleteAuthor(a);
		System.out.println("Author deleted");
		return "redirect:/";
	}
	
	@GetMapping("/authors/{id}/edit")
	public String show_author(@PathVariable("id") int id, Model model) {
		
		Author author = authorService.findById(id);
		model.addAttribute("author", author);
		
		return "edit.jsp";
	}
	
	@RequestMapping("/authors/{id}/update")
	public String updateAuthor(@PathVariable("id") int id, @ModelAttribute("author") Author author, BindingResult result) {
		
		authorService.updateAuthor(author);
		System.out.println("Updated");
		return "redirect:/";
	}
	
}
