package com.intentcoder.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.intentcoder.model.Author;
import com.intentcoder.model.Book;
import com.intentcoder.repositories.AuthorRepository;
import com.intentcoder.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}
	
	private void initData() {
		//Eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		//Rod Johnson
		Author rod = new Author("Rod", "Johnson");
		Book noEjb = new Book("J2EE development without EJB", "5678", "Worx");
		eric.getBooks().add(noEjb);
		authorRepository.save(rod);
		bookRepository.save(noEjb);
	}
}
