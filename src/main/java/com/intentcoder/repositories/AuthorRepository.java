package com.intentcoder.repositories;

import org.springframework.data.repository.CrudRepository;

import com.intentcoder.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
