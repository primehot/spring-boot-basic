package com.springdev.springdev.repositories;

import com.springdev.springdev.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
