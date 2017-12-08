package com.springdev.springdev.repositories;

import com.springdev.springdev.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
