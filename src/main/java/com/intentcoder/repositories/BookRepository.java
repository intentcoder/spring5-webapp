package com.intentcoder.repositories;

import org.springframework.data.repository.CrudRepository;

import com.intentcoder.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
