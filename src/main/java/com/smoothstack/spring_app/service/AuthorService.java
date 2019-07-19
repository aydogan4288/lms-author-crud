package com.smoothstack.spring_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smoothstack.spring_app.model.Author;
import com.smoothstack.spring_app.repository.AuthorRepository;

@Service
public class AuthorService {

	private final AuthorRepository authorRepository;

	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public Author createAuthor(Author author) {
		return authorRepository.save(author);
	}

	public Author updateAuthor(Author a) {
		return authorRepository.save(a);
	}

	public List<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

	public void deleteAuthor(Author a) {
		authorRepository.delete(a);
	}
	
	public Author findById(int id) {
		return authorRepository.findById(id);
	}
}
