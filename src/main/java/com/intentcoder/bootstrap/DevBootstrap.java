package com.intentcoder.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.intentcoder.model.Author;
import com.intentcoder.model.Book;
import com.intentcoder.model.Publisher;
import com.intentcoder.repositories.AuthorRepository;
import com.intentcoder.repositories.BookRepository;
import com.intentcoder.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}
	
	private void initData() {
		//Eric
		Author eric = new Author("Eric", "Evans");
		Publisher collins = new Publisher("Harper Collins", "New Jersey");
		Book ddd = new Book("Domain Driven Design", "1234", collins);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		publisherRepository.save(collins);
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		//Rod Johnson
		Author rod = new Author("Rod", "Johnson");
		Publisher worx = new Publisher("Worx", "Emeryville");
		Book noEjb = new Book("J2EE development without EJB", "5678", worx);
		eric.getBooks().add(noEjb);
		publisherRepository.save(worx);
		authorRepository.save(rod);
		bookRepository.save(noEjb);
	}
}
