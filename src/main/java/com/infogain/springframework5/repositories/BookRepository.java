package com.infogain.springframework5.repositories;

import com.infogain.springframework5.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
