package com.springdev.springdev.repositories;

import com.springdev.springdev.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
