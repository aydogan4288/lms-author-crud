package com.smoothstack.spring_app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.spring_app.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
	
	public List<Author> findAll();
	
	public Author findById(int id);
}
