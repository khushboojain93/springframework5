package com.infogain.springframework5.repositories;

import com.infogain.springframework5.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
