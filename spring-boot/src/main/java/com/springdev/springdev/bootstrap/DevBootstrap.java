package com.springdev.springdev.bootstrap;

import com.springdev.springdev.model.Author;
import com.springdev.springdev.model.Book;
import com.springdev.springdev.model.Publisher;
import com.springdev.springdev.repositories.AuthorRepository;
import com.springdev.springdev.repositories.BookRepository;
import com.springdev.springdev.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher harper = new Publisher("Harper Collins", "New York");
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        publisherRepository.save(harper);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Publisher worx = new Publisher("Worx", "San Francisco");
        Author rod = new Author("Rod", "Jonson");
        Book noEJB = new Book("J2EE development without EJB", "2344", worx);
        rod.getBooks().add(noEJB);

        publisherRepository.save(worx);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
